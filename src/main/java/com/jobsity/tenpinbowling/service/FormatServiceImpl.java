package com.jobsity.tenpinbowling.service;

import com.jobsity.tenpinbowling.model.Frame;
import com.jobsity.tenpinbowling.model.Player;
import com.jobsity.tenpinbowling.model.Result;
import org.springframework.stereotype.Service;

import static com.jobsity.tenpinbowling.util.Constants.*;
import static java.util.Comparator.comparing;

@Service
public class FormatServiceImpl implements FormatService {

    /**
     * Format to StringBuilder with the given format
     *
     * @param result
     * @return
     */
    @Override
    public StringBuilder format(Result result) {
        StringBuilder text = new StringBuilder();
        printHeader(text);
        result.getResult().entrySet().stream().sorted(comparing(playerListEntry -> playerListEntry.getKey().getName()))
                .forEach((entry) -> {
                    printName(text, entry.getKey());
                    printPinFalls(text, entry.getValue());
                    printScores(text, entry.getValue());
                });
        return text;
    }

    private void printHeader(StringBuilder text) {
        text.append(HEADER);
    }

    /**
     * Print Name
     *
     * @param text
     * @param player
     */
    private void printName(StringBuilder text, Player player) {
        text.append(LINE_BREAK);
        text.append(player.getName());
        text.append(LINE_BREAK);
    }

    /**
     * Print Pinfalls
     *
     * @param text
     * @param frames
     */
    private void printPinFalls(StringBuilder text, java.util.List<Frame> frames) {
        text.append(PINFALLS);
        text.append(TAB);
        frames.forEach(frame -> {
            frame.getPinFalls().forEach(pinfall -> {
                text.append(pinfall);
                text.append(TAB);
            });
        });
        text.append(LINE_BREAK);
    }

    /**
     * Print Scores
     *
     * @param text
     */
    private void printScores(StringBuilder text, java.util.List<Frame> frames) {
        text.append(SCORE);
        text.append(TAB);
        frames.forEach(frame -> {
            text.append(TAB);
            text.append(frame.getCumulativeScore());
            text.append(TAB);
        });
    }

}
