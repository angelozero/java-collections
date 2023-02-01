package com.angelozero.collections.entrypoint;

import com.angelozero.collections.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
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
    private final MethodReferences01 setAdminAllUsersService;
    private final MethodReferences02 nullLastService;
    private final MethodReferences03 nullFirstService;
    private final Supplier01 methodReferenceConstructorService;
    private final Supplier02 methodReferenceConstructorParameterService;
    private final Supplier03 methodReferenceConstructorParameterBiFunctionService;
    private final Stream01 streamFilterOnlyUsersWithMoreThan25Points;
    private final Stream02 streamSumAllPoints;
    private final Stream03 streamAvaragePoints;
    private final Stream04 streamReducePoints;
    private final Stream05 streamFlatmap;
    private final Stream06 streamFlatmapDistinct;

    @GetMapping(value = "/for", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFor() {
        return generateJsonResponse(forService.execute());
    }

    @GetMapping(value = "/for-each", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getForEach() {
        return generateJsonResponse(forEachService.execute());
    }

    @GetMapping(value = "/custom-functional-interface", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCustomFunctionalInterface(@PathParam("name") String name) {
        return generateJsonResponse(customFunctionalInterfaceService.execute(name));
    }

    @GetMapping(value = "/remove-if", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCustomFunctionalInterface() {
        return generateJsonResponse(removeIfService.execute());
    }

    @GetMapping(value = "/comparator-sorted-list-by-names", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSortedListByNamesUsingComparator() {
        return generateJsonResponse(comparatorSortedListByNameService.execute());
    }

    @GetMapping(value = "/comparator-sorted-list-by-points", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSortedListByPointsUsingComparator() {
        return generateJsonResponse(comparatorSortedListByPointsService.execute());
    }

    @GetMapping(value = "/comparator-natural-order", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSortedStringListUsingComparatorNaturalOrder() {
        return generateJsonResponse(naturalOrderService.execute());
    }

    @GetMapping(value = "/method-reference-set-all-as-admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceSetAllUsersAsAdmin() {
        return generateJsonResponse(setAdminAllUsersService.execute(false));
    }

    @GetMapping(value = "/method-reference-null-last", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceNullLast() {
        return generateJsonResponse(nullLastService.execute());
    }

    @GetMapping(value = "/method-reference-null-first", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceNullFirst() {
        return generateJsonResponse(nullFirstService.execute());
    }

    @GetMapping(value = "/method-reference-constructor", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceConstructor() {
        return generateJsonResponse(methodReferenceConstructorService.execute());
    }

    @GetMapping(value = "/method-reference-constructor-parameter", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceConstructorParameter() {
        return generateJsonResponse(methodReferenceConstructorParameterService.execute());
    }

    @GetMapping(value = "/method-reference-constructor-parameter-bi-function", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceConstructorParameterBiFunction() {
        return generateJsonResponse(methodReferenceConstructorParameterBiFunctionService.execute());
    }

    @GetMapping(value = "/stream-and-filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamAndFilter() {
        return generateJsonResponse(streamFilterOnlyUsersWithMoreThan25Points.execute());
    }

    @GetMapping(value = "/stream-and-sum", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamAndSum() {
        return generateJsonResponse(streamSumAllPoints.execute());
    }


    @GetMapping(value = "/stream-and-avarage", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamAndAvarage() {
        return generateJsonResponse(streamAvaragePoints.execute());
    }

    @GetMapping(value = "/stream-and-reduce", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamAndReduce() {
        return generateJsonResponse(streamReducePoints.execute());
    }

    @GetMapping(value = "/stream-flatmap", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamListFlatmap() {
        return generateJsonResponse(streamFlatmap.execute());
    }

    @GetMapping(value = "/stream-flatmap-distinct", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamListFlatmapDistinct() {
        return generateJsonResponse(streamFlatmapDistinct.execute());
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
