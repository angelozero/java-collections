package com.angelozero.collections.service.store;

import com.angelozero.collections.domain.store.MasterStore;
import com.angelozero.collections.domain.store.Store;
import com.angelozero.collections.domain.store.SuperStore;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GenetareMasterStores {

    public static List<MasterStore> execute() {
        return Arrays.asList(
                // Master Store 1
                MasterStore.builder()
                        .superStoreList(Arrays.asList(
                                // Super Store 1
                                SuperStore.builder()
                                        .masterName("Super Store 1")
                                        .storeList(Arrays.asList(
                                                Store.builder()
                                                        .code("001")
                                                        .name("AAA")
                                                        .value(10)
                                                        .build(),
                                                Store.builder()
                                                        .code("002")
                                                        .name("BBB")
                                                        .value(20)
                                                        .build(),
                                                Store.builder()
                                                        .code("003")
                                                        .name("CCC")
                                                        .value(30)
                                                        .build()))
                                        .build(),
                                // Super Store 2
                                SuperStore.builder()
                                        .masterName("Super Store 2")
                                        .storeList(Arrays.asList(
                                                Store.builder()
                                                        .code("001")
                                                        .name("AAA")
                                                        .value(10)
                                                        .build(),
                                                Store.builder()
                                                        .code("004")
                                                        .name("DDD")
                                                        .value(40)
                                                        .build(),
                                                Store.builder()
                                                        .code("005")
                                                        .name("EEE")
                                                        .value(50)
                                                        .build()))
                                        .build()))
                        .build(),

                // Master Store 2
                MasterStore.builder()
                        .superStoreList(Arrays.asList(
                                // Super Store 1
                                SuperStore.builder()
                                        .masterName("Super Store 3")
                                        .storeList(Arrays.asList(
                                                Store.builder()
                                                        .code("001")
                                                        .name("AAA")
                                                        .value(10)
                                                        .build(),
                                                Store.builder()
                                                        .code("006")
                                                        .name("FFF")
                                                        .value(60)
                                                        .build(),
                                                Store.builder()
                                                        .code("007")
                                                        .name("GGG")
                                                        .value(70)
                                                        .build()))
                                        .build(),
                                // Super Store 2
                                SuperStore.builder()
                                        .masterName("Super Store 4")
                                        .storeList(Arrays.asList(
                                                Store.builder()
                                                        .code("001")
                                                        .name("AAA")
                                                        .value(10)
                                                        .build(),
                                                Store.builder()
                                                        .code("008")
                                                        .name("HHH")
                                                        .value(80)
                                                        .build(),
                                                Store.builder()
                                                        .code("009")
                                                        .name("ZZZ")
                                                        .value(90)
                                                        .build()))
                                        .build()))
                        .build()
        );
    }
}
