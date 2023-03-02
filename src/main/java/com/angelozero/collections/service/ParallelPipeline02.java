package com.angelozero.collections.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;


@Service
@AllArgsConstructor
public class ParallelPipeline02 {

    private static final DecimalFormat decimal = new DecimalFormat("0.00");

    /**
     * Filter users with more out of 100 points,
     * order them and collect the result in a list
     */
    public Map<String, String> execute() {

        double startTimeWithParallel = (double) System.nanoTime() / 1_000_000_000;
        LongStream.range(0, 1_000_000_000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .sum();
        double stopTimeWithParallel = (double) System.nanoTime() / 1_000_000_000;


        double startTimeWithoutParallel = (double) System.nanoTime() / 1_000_000_000;
        LongStream.range(0, 1_000_000_000)
                .filter(x -> x % 2 == 0)
                .sum();
        double endTimeWithoutParallel = (double) System.nanoTime() / 1_000_000_000;

        return Stream.of(
                        new AbstractMap.SimpleEntry<>("Time with Parallel   ", decimal.format(stopTimeWithParallel - startTimeWithParallel) + " seconds"),
                        new AbstractMap.SimpleEntry<>("Time without Parallel", decimal.format(endTimeWithoutParallel - startTimeWithoutParallel) + " seconds"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
