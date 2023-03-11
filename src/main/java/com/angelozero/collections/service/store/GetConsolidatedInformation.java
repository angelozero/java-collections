package com.angelozero.collections.service.store;

import com.angelozero.collections.domain.store.MasterStore;
import com.angelozero.collections.domain.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetConsolidatedInformation {

    public List<List<Store>> execute() {


        List<MasterStore> masterStoreList = GenetareMasterStores.execute();




        return null;
    }
}
