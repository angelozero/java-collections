package com.angelozero.collections.entrypoint;

import com.angelozero.collections.service.Collection01;
import com.angelozero.collections.service.Collection02;
import com.angelozero.collections.service.Lambda01;
import com.angelozero.collections.service.Lambda02;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CollectionController {

    private final Collection01 service1;
    private final Collection02 service2;
    private final Lambda01 service3;
    private final Lambda02 service4;

    @GetMapping("/for")
    public String getFor() {
        return generateJsonResponse(service1.execute());
    }

    @GetMapping("/for-each")
    public String getForEach() {
        return generateJsonResponse(service2.execute());
    }

    @GetMapping("/custom-functional-interface")
    public String getCustomFunctionalInterface(@PathParam("name") String name) {
        return generateJsonResponse(service3.execute(name));
    }

    @GetMapping("/remove-if")
    public String getCustomFunctionalInterface() {
        return generateJsonResponse(service4.execute());
    }

    private String generateJsonResponse(Object obj) {

        ObjectWriter objWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return objWriter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }
}
