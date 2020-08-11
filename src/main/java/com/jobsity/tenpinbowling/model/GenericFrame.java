package com.jobsity.tenpinbowling.model;

import java.util.Arrays;
import java.util.List;

import static com.jobsity.tenpinbowling.util.Constants.SPARE_CHARACTER;
import static com.jobsity.tenpinbowling.util.Constants.STRIKE_CHARACTER;

public class GenericFrame extends Frame {


    public GenericFrame(List<Integer> chances, int frameNumber, int knockedPins) {
        super(chances, frameNumber, knockedPins);
    }

    @Override
    public boolean isStrike() {
        return getChances().get(0) == 10;
    }


    @Override
    public boolean isSpare() {
        return getKnockedPins() == 10 && getChances().size() == 2;
    }

    @Override
    public List<String> getPinFalls() {
        if (isStrike()) {
            return Arrays.asList(" ", STRIKE_CHARACTER);
        }
        if (isSpare()) {
            return Arrays.asList(getChances().get(0).toString(), SPARE_CHARACTER);
        }
        return Arrays.asList(getChances().get(0).toString(), getChances().get(1).toString());
    }

    @Override
    public boolean isCompleted(int frameChance) {
        return (getKnockedPins() == 10 || frameChance == 2);
    }


}
