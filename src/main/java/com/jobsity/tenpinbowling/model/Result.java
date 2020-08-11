package com.jobsity.tenpinbowling.model;

import lombok.Data;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Result {
    Map<Player, List<Frame>> result;
}
