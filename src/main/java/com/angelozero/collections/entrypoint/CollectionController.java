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
    private final FlatMap01 flatMapGenerateMapWithProjectFilesService;
    private final ParallelPipeline01 parallelPipelineService;
    private final ParallelPipeline02 parallelPipelineMeasureTimeService;

    @GetMapping(value = "/for", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFor() {
        return GenerateJsonResponse.execute(forService.execute());
    }

    @GetMapping(value = "/for-each", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getForEach() {
        return GenerateJsonResponse.execute(forEachService.execute());
    }

    @GetMapping(value = "/custom-functional-interface", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCustomFunctionalInterface(@PathParam("name") String name) {
        return GenerateJsonResponse.execute(customFunctionalInterfaceService.execute(name));
    }

    @GetMapping(value = "/remove-if", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCustomFunctionalInterface() {
        return GenerateJsonResponse.execute(removeIfService.execute());
    }

    @GetMapping(value = "/comparator-sorted-list-by-names", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSortedListByNamesUsingComparator() {
        return GenerateJsonResponse.execute(comparatorSortedListByNameService.execute());
    }

    @GetMapping(value = "/comparator-sorted-list-by-points", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSortedListByPointsUsingComparator() {
        return GenerateJsonResponse.execute(comparatorSortedListByPointsService.execute());
    }

    @GetMapping(value = "/comparator-natural-order", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSortedStringListUsingComparatorNaturalOrder() {
        return GenerateJsonResponse.execute(naturalOrderService.execute());
    }

    @GetMapping(value = "/method-reference-set-all-as-admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceSetAllUsersAsAdmin() {
        return GenerateJsonResponse.execute(setAdminAllUsersService.execute(false));
    }

    @GetMapping(value = "/method-reference-null-last", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceNullLast() {
        return GenerateJsonResponse.execute(nullLastService.execute());
    }

    @GetMapping(value = "/method-reference-null-first", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceNullFirst() {
        return GenerateJsonResponse.execute(nullFirstService.execute());
    }

    @GetMapping(value = "/method-reference-constructor", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceConstructor() {
        return GenerateJsonResponse.execute(methodReferenceConstructorService.execute());
    }

    @GetMapping(value = "/method-reference-constructor-parameter", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceConstructorParameter() {
        return GenerateJsonResponse.execute(methodReferenceConstructorParameterService.execute());
    }

    @GetMapping(value = "/method-reference-constructor-parameter-bi-function", produces = MediaType.APPLICATION_JSON_VALUE)
    public String methodReferenceConstructorParameterBiFunction() {
        return GenerateJsonResponse.execute(methodReferenceConstructorParameterBiFunctionService.execute());
    }

    @GetMapping(value = "/stream-and-filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamAndFilter() {
        return GenerateJsonResponse.execute(streamFilterOnlyUsersWithMoreThan25Points.execute());
    }

    @GetMapping(value = "/stream-and-sum", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamAndSum() {
        return GenerateJsonResponse.execute(streamSumAllPoints.execute());
    }


    @GetMapping(value = "/stream-and-avarage", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamAndAvarage() {
        return GenerateJsonResponse.execute(streamAvaragePoints.execute());
    }

    @GetMapping(value = "/stream-and-reduce", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamAndReduce() {
        return GenerateJsonResponse.execute(streamReducePoints.execute());
    }

    @GetMapping(value = "/stream-flatmap", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamListFlatmap() {
        return GenerateJsonResponse.execute(streamFlatmap.execute());
    }

    @GetMapping(value = "/stream-flatmap-distinct", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamListFlatmapDistinct() {
        return GenerateJsonResponse.execute(streamFlatmapDistinct.execute());
    }

    @GetMapping(value = "/flat-map-generate-map", produces = MediaType.APPLICATION_JSON_VALUE)
    public String flatMapGenerateMap() {
        return GenerateJsonResponse.execute(flatMapGenerateMapWithProjectFilesService.execute());
    }

    @GetMapping(value = "/parallel-pipeline", produces = MediaType.APPLICATION_JSON_VALUE)
    public String parallelPipeline() {
        return GenerateJsonResponse.execute(parallelPipelineService.execute());
    }

    @GetMapping(value = "/parallel-pipeline-measure-time", produces = MediaType.APPLICATION_JSON_VALUE)
    public String parallelPipelineMeasureTime() {
        return GenerateJsonResponse.execute(parallelPipelineMeasureTimeService.execute());
    }
}
