package com.jobsity.tenpinbowling.service;

import com.jobsity.tenpinbowling.model.Line;
import com.jobsity.tenpinbowling.model.Result;

import java.util.List;
import java.util.Map;

public interface ValidationService {

    boolean isLinesInvalid(List<Line> listOfLines);

    boolean isFramesValid(Result result);
}
