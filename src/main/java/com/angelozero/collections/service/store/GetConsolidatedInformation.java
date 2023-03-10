package com.angelozero.collections.service.store;

import com.angelozero.collections.domain.store.MasterStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetConsolidatedInformation {

    public List<MasterStore> execute() {

        List<MasterStore> masterStoreList = GenetareMasterStores.execute();

        System.out.println(masterStoreList);

        return masterStoreList;
    }
}
