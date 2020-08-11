package com.jobsity.tenpinbowling.service;

import com.jobsity.tenpinbowling.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.jobsity.tenpinbowling.util.Constants.DELIMITER;
import static com.jobsity.tenpinbowling.util.Constants.MAX_THROWS;

@Service
public class TransformerServiceImpl implements TransformerService {

    @Autowired
    ScoreService scoreService;

    /**
     * Get Line (name, value) of List of strings split by delimiter (tab)
     * @param content
     * @return
     */
    @Override
    public List<Line> getLines(List<String> content) {
        return content.stream().map(x -> {
            String[] value = x.split(DELIMITER);
            return new Line(value[0], value[1]);
        }).collect(Collectors.toList());
    }

    /**
     * Get a Map of Player name and all the shots done
     * @param listOfLines
     * @return
     */
    @Override
    public Map<String, List<Integer>> getChancesByName(List<Line> listOfLines) {
        return listOfLines.stream().collect((Collectors.groupingBy(Line::getName,
                Collectors.mapping(line -> scoreService.getScore(line.getValue()), Collectors.toList()))));
    }

    /**
     * Return a formatted Result of given Map(name, chances)
     * @param chancesByName
     * @return
     */
    @Override
    public Result getFramesByName(Map<String, List<Integer>> chancesByName) {
        Map<Player, List<Frame>> framesByName = new HashMap<>();

        chancesByName.forEach((name, values) -> {
            int frameChance = 0;

            List<Frame> frames = new ArrayList<>();
            List<Integer> pinsKnockedInASingleShot = new ArrayList<>();

            for (Integer value : values) {
                frameChance++;
                pinsKnockedInASingleShot.add(value);

                int knockedPins = getSumOfList(pinsKnockedInASingleShot);
                int frameNumber = frames.size() + 1;

                Frame frame;
                if (frameNumber != MAX_THROWS) {
                    frame = new GenericFrame(pinsKnockedInASingleShot, frameNumber, knockedPins);
                } else {
                    frame = new LastFrame(pinsKnockedInASingleShot, frameNumber, knockedPins);
                }

                if (frame.isCompleted(frameChance)) {
                    frames.add(frame);
                    pinsKnockedInASingleShot = new ArrayList<>();
                    frameChance = 0;
                }

            }
            framesByName.put(new Player(name), frames);
        });

        return new Result(framesByName);
    }


    /**
     * Return a sum of integer list
     * @param intList
     * @return
     */
    private int getSumOfList(List<Integer> intList) {
        return intList.stream().mapToInt(Integer::intValue).sum();
    }



}
