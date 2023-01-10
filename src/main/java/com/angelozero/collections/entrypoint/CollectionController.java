package com.angelozero.collections.entrypoint;

import com.angelozero.collections.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CollectionController {

    private final Collection01 forService;
    private final Collection02 forEachService;
    private final Lambda01 customFunctionalInterfaceService;
    private final Lambda02 removeIfService;
    private final Comparator01 comparatorSortedListByNameService;
    private final Comparator02 comparatorSortedListByPointsService;
    private final Comparator03 naturalOrderService;

    @GetMapping("/for")
    public String getFor() {
        return generateJsonResponse(forService.execute());
    }

    @GetMapping("/for-each")
    public String getForEach() {
        return generateJsonResponse(forEachService.execute());
    }

    @GetMapping("/custom-functional-interface")
    public String getCustomFunctionalInterface(@PathParam("name") String name) {
        return generateJsonResponse(customFunctionalInterfaceService.execute(name));
    }

    @GetMapping("/remove-if")
    public String getCustomFunctionalInterface() {
        return generateJsonResponse(removeIfService.execute());
    }

    @GetMapping("/comparator-sorted-list-by-names")
    public String getSortedListByNamesUsingComparator() {
        return generateJsonResponse(comparatorSortedListByNameService.execute());
    }

    @GetMapping("/comparator-sorted-list-by-points")
    public String getSortedListByPointsUsingComparator() {
        return generateJsonResponse(comparatorSortedListByPointsService.execute());
    }

    @GetMapping("/comparator-natural-order")
    public String getSortedStringListUsingComparatorNaturalOrder() {
        return generateJsonResponse(naturalOrderService.execute());
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
