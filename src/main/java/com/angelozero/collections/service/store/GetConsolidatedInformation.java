package com.angelozero.collections.service.store;

import com.angelozero.collections.domain.store.MasterStore;
import com.angelozero.collections.domain.store.Store;
import com.angelozero.collections.domain.store.SuperStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

@Service
public class GetConsolidatedInformation {

    public MasterStore execute() {

        List<MasterStore> masterStoreList = GenetareMasterStores.execute();

        List<Store> storeList = new ArrayList<>();
        List<Store> storeFinalList = new ArrayList<>();

        masterStoreList.forEach(masterStore -> masterStore.getSuperStoreList().forEach(superStore -> storeList.addAll(superStore.getStoreList())));

        for (List<Store> storeMapList : storeList.stream().collect(Collectors.groupingBy(Store::getCode)).values()) {
            storeFinalList.add(sumStores(storeMapList));
        }

        return MasterStore.builder()
                .superStoreList(Collections
                        .singletonList(
                                SuperStore.builder()
                                        .name("Final Store Name")
                                        .storeList(storeFinalList)
                                        .build()))
                .build();
    }

    private Store sumStores(List<Store> storeList) {
        return storeList.stream()
                .collect(Collectors.teeing(
                        Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Store::getCode))),
                        Collectors.summingInt(Store::getValue), (optionalMax, sum) ->
                                new Store(optionalMax.get().getCode(), optionalMax.get().getName(), sum)));
    }
}
