package com.angelozero.collections.service.store;

import com.angelozero.collections.domain.store.MasterStore;
import com.angelozero.collections.domain.store.Store;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetConsolidatedInformation {

    public List<Store> execute() {


        List<MasterStore> masterStoreList = GenetareMasterStores.execute();


        List<Store> storeList = new ArrayList<>();
        List<Store> storeFinalList = new ArrayList<>();

        masterStoreList.forEach(masterStore ->
                masterStore.getSuperStoreList().forEach(superStore ->
                        storeList.addAll(superStore.getStoreList()
                        )
                )
        );

        List<Store> repeatedValuesList = storeList.stream().filter(store ->
                        Collections.frequency(storeList, store) > 1)
                .toList().stream().sorted(Comparator.comparing(Store::getCode)).toList();

        List<Store> nonRepeatedValuesList = storeList.stream().filter(store -> Collections.frequency(storeList, store) == 1).toList();

        ListIterator<Store> iterator = repeatedValuesList.listIterator();

        int soma = repeatedValuesList.stream().filter(storeInfo -> storeInfo.getCode().equals("001")).mapToInt(Store::getValue).sum();

        while (iterator.hasNext()) {

            if (iterator.hasPrevious() && !iterator.previous().getCode().equals(iterator.next().getCode())) {
                Store storePrev = iterator.previous();
                storeFinalList.add(Store.builder()
                        .code(storePrev.getCode())
                        .name(storePrev.getName())
                        .value(repeatedValuesList.stream().filter(storeInfo -> storeInfo.getCode().equals(storePrev.getCode())).mapToInt(Store::getValue).sum())
                        .build());

            } else if (iterator.hasPrevious() && storeFinalList.stream().noneMatch(storeInfo -> storeInfo.getCode().equals(iterator.previous().getCode()))) {
                Store storePrev = iterator.previous();
                storeFinalList.add(Store.builder()
                        .code(storePrev.getCode())
                        .name(storePrev.getName())
                        .value(repeatedValuesList.stream().filter(storeInfo -> storeInfo.getCode().equals(storePrev.getCode())).mapToInt(Store::getValue).sum())
                        .build());
            } else {
                Store store = iterator.next() != null ? iterator.next() : iterator.previous();
                storeFinalList.add(Store.builder()
                        .code(iterator.next().getCode())
                        .name(iterator.next().getName())
                        .value(repeatedValuesList.stream().filter(storeInfo -> storeInfo.getCode().equals(store.getCode())).mapToInt(Store::getValue).sum())
                        .build());
            }
        }

        return storeFinalList;
    }
}
