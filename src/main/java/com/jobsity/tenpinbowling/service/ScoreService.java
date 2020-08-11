package com.jobsity.tenpinbowling.service;

import com.jobsity.tenpinbowling.model.Frame;
import com.jobsity.tenpinbowling.model.Result;

import java.util.List;

public interface ScoreService {

    int getScore(String value);

    void calculateScore(Result result);


}
