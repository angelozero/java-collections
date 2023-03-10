package com.angelozero.collections.entrypoint;

import com.angelozero.collections.service.store.GetConsolidatedInformation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StoreController {

    private final GetConsolidatedInformation getConsolidatedInformation;

    @GetMapping(value = "/store-consolidated", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getConsolidatedStores() {
        return GenerateJsonResponse.execute(getConsolidatedInformation.execute());
    }
}
