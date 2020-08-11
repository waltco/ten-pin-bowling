package com.jobsity.tenpinbowling.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

@Service
public class PrintServiceImpl implements PrintService {

    Logger logger = LoggerFactory.getLogger(PrintServiceImpl.class);

    /**
     * Print the value in a File of a given content and filepath as String
     * @param content
     * @param outputFilePath
     */
    @Override
    public void print(StringBuilder content, String outputFilePath) {
        try {
            Path out = Paths.get(outputFilePath);
            Files.write(out, Collections.singleton(content), Charset.defaultCharset());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
