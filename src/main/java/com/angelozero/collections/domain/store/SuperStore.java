package com.angelozero.collections.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperStore {

    private String masterName;
    private List<Store> storeList;
}
