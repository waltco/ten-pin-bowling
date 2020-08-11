package com.jobsity.tenpinbowling.model;

import com.jobsity.tenpinbowling.util.Constants;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

import static com.jobsity.tenpinbowling.util.Constants.SPARE_CHARACTER;
import static com.jobsity.tenpinbowling.util.Constants.STRIKE_CHARACTER;


public class LastFrame extends Frame {



    @Override
    public boolean isStrike() {
        return getChances().get(0) == 10;
    }

    @Override
    public boolean isSpare() {
        return getKnockedPins() == 10 && getChances().get(1) == 2;
    }

    @Override
    public List<String> getPinFalls() {
        if (isStrike()) {
            return Arrays.asList(STRIKE_CHARACTER, getPinFallCode(getChances().get(1)), getPinFallCode((getChances().get(2))));
        }
        if(isSpare()){
            return Arrays.asList(getPinFallCode(getChances().get(0)), SPARE_CHARACTER,getPinFallCode(getChances().get(2)));
        }
        return Arrays.asList(getChances().get(0).toString(), getChances().get(1).toString(), getChances().get(2).toString());
    }

    @Override
    public boolean isCompleted(int frameChance) {
        return (frameChance == 2 && getKnockedPins() < 10) || (frameChance == 3);
    }

    private String getPinFallCode(Integer integer) {
        if(integer == 10){
            return STRIKE_CHARACTER;
        } else {
            return integer.toString();
        }
    }

    public LastFrame(List<Integer> chances, int frameNumber, int knockedPins) {
        super(chances, frameNumber, knockedPins);
    }
}
