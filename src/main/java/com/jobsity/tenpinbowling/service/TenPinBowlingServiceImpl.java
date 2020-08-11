package com.jobsity.tenpinbowling.service;

import com.jobsity.tenpinbowling.config.Properties;
import com.jobsity.tenpinbowling.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TenPinBowlingServiceImpl implements TenPinBowlingService {

    @Autowired
    ReadFileService readFileService;

    @Autowired
    ValidationService validationService;

    @Autowired
    ScoreService scoreService;

    @Autowired
    TransformerService transformerService;

    @Autowired
    FormatService formatService;

    @Autowired
    PrintService printService;

    @Autowired
    Properties properties;

    @Override
    public void run() {

        List<String> content = readFileService.read(properties.getInputFile());
        List<Line> listOfLines = transformerService.getLines(content);
        if (validationService.isLinesInvalid(listOfLines)) {
            throw new IllegalArgumentException("Invalid Format in lines");
        }

        Map<String, List<Integer>> chancesByName = transformerService.getChancesByName(listOfLines);
        Result result = transformerService.getFramesByName(chancesByName);

        if (!validationService.isFramesValid(result)) {
            throw new IllegalArgumentException("Invalid Input. More than ten throws");
        }

        scoreService.calculateScore(result);

        StringBuilder output = formatService.format(result);
        printService.print(output, properties.getOutputFile());

    }

}

