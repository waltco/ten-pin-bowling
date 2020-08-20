package com.jobsity.tenpinbowling.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReadFileServiceImpl implements ReadFileService {

    /**
     * Read the content of a File of a given filepath as a String
     * @param inputFilePath
     * @return
     */
    @Override
    public List<String> read(String inputFilePath) {
        try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))){
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found");
        }
    }
}
