package com.jobsity.tenpinbowling.service;

import com.jobsity.tenpinbowling.model.Line;
import com.jobsity.tenpinbowling.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jobsity.tenpinbowling.util.Constants.*;

@Service
public class ValidationServiceImpl implements ValidationService {


    /**
     * Check if values of lines are valid
     * @param listOfLines
     * @return boolean
     */
    @Override
    public boolean isLinesInvalid(List<Line> listOfLines) {
        return listOfLines.stream().anyMatch(line -> !isValidValue(line.getValue()));
    }

    /**
     * Check if there's more than 10 throws
     * @param result
     * @return boolean
     */
    @Override
    public boolean isFramesValid(Result result) {
        return result.getResult().entrySet().stream().anyMatch(entry -> entry.getValue().size() <= MAX_THROWS);
    }

    /**
     * Check if value of line is valid
     * @param value
     * @return boolean
     */
    private boolean isValidValue(String value) {
        return (isValidNumber(value) && isValueInsideLimits(value)) || isFoul(value);
    }

    /**
     * Check if the value is a valid number
     * @param value
     * @return boolean
     */
    private boolean isValidNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Check if number is inside Limits
     * @param value
     * @return boolean
     */
    private boolean isValueInsideLimits(String value) {
        int number = Integer.parseInt(value);
        return MIN_VALUE <= number && number <= MAX_VALUE;
    }


    /**
     * Check if value is Foul
     * @param value
     * @return
     */
    private boolean isFoul(String value) {
        return value.equals(FOUL);
    }
}
