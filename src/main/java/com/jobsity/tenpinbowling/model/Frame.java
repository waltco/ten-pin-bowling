package com.jobsity.tenpinbowling.model;

import lombok.Data;

import java.util.List;

@Data
public abstract class Frame {
    private int frameNumber;
    private int score;
    private int cumulativeScore;
    private int knockedPins;
    private List<Integer> chances;

    public Frame(List<Integer> chances, int frameNumber, int knockedPins) {
        this.chances = chances;
        this.frameNumber = frameNumber;
        this.knockedPins = knockedPins;
    }

    public Frame(List<Integer> chances) {
        this.chances = chances;
    }

    public abstract boolean isStrike();
    public abstract boolean isSpare();
    public abstract List<String> getPinFalls();
    public abstract boolean isCompleted(int frameChance);

}
