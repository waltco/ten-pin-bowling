package com.jobsity.tenpinbowling.service;

import com.jobsity.tenpinbowling.model.Line;
import com.jobsity.tenpinbowling.model.Result;

import java.util.List;
import java.util.Map;

public interface TransformerService {
    List<Line> getLines(List<String> content);
    Map<String, List<Integer>>  getChancesByName(List<Line> listOfLines);
    Result getFramesByName(Map<String, List<Integer>> chancesByName);
}
