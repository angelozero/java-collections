package com.angelozero.collections.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.Files.lines;
import static java.nio.file.Files.list;

@Service
@AllArgsConstructor
public class FlatMap01 {

    public Map<Path, Long> execute() {
        Map<Path, Long> linesPerFile = new HashMap<>();

        try {
            list(Paths.get("src/main/java/com/angelozero/collections/service/"))
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(p ->
                    {
                        try {
                            linesPerFile.put(p.getFileName(), lines(p).count());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
            return linesPerFile;

        } catch (Exception ex) {
            return Collections.emptyMap();
        }
    }
}
