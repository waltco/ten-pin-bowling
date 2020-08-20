package com.jobsity.tenpinbowling.service;

import com.jobsity.tenpinbowling.model.Frame;
import com.jobsity.tenpinbowling.model.GenericFrame;
import com.jobsity.tenpinbowling.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jobsity.tenpinbowling.util.Constants.FOUL;

@Service
public class ScoreServiceImpl implements ScoreService {

    /**
     * Return
     * @param value
     * @return knocked pins as int. If Foul returns 0
     */
    @Override
    public int getScore(String value) {
        int knockedPins;
        if (FOUL.equals(value)) {
            knockedPins = 0;
        } else {
            knockedPins = Integer.parseInt(value);
        }
        return knockedPins;
    }

    /**
     * Calculate Scores of Frames
     * @param result
     */
    @Override
    public void calculateScore(Result result) {
        result.getResult().forEach((player, frames) -> {
            int cumulativeScore = 0;
            for (int i = 0; i < frames.size(); i++) {
                int score = 0;
                score = frames.get(i).getKnockedPins();
                score = calculateScore(frames, i, score);
                cumulativeScore += score;
                frames.get(i).setScore(score);
                frames.get(i).setCumulativeScore(cumulativeScore);
            }
        });
    }


    /**
     * Calculate Score of given Frames.
     * @param frames
     * @param i
     * @param score
     * @return
     */
    public int calculateScore(List<Frame> frames, int i, int score) {
        if (frames.get(i) instanceof GenericFrame) {
            score = calculateScoreOfGenericFrame(frames, i, score);
        }
        return score;
    }


    /**
     * Calculate Score of Frame in a List of Frames
     * @param frames
     * @param i
     * @param score
     * @return
     */
    private int calculateScoreOfGenericFrame(List<Frame> frames, int i, int score) {
        if (frames.get(i).isSpare()) {
            score += frames.get(i + 1).getChances().get(0);
        }
        if (frames.get(i).isStrike()) {
            score += frames.get(i + 1).getChances().get(0);
            if (frames.get(i + 1).getChances().size() == 1) {
                score += frames.get(i + 2).getChances().get(0);
            } else {
                score += frames.get(i + 1).getChances().get(1);
            }
        }
        return score;
    }
}
