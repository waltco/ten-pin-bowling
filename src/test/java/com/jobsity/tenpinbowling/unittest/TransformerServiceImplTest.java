package com.jobsity.tenpinbowling.unittest;

import com.jobsity.tenpinbowling.TenPinBowlingApplication;
import com.jobsity.tenpinbowling.model.Line;
import com.jobsity.tenpinbowling.service.ScoreService;
import com.jobsity.tenpinbowling.service.TransformerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TenPinBowlingApplication.class}, initializers = ConfigFileApplicationContextInitializer.class)
class TransformerServiceImplTest {

    List<Line> lines;

    @Autowired
    TransformerService transformerService;

    @MockBean
    ScoreService scoreService;

    @BeforeEach
    public void setUp() {
        lines = new LinkedList<>(Arrays.asList(new Line("George", "10"),
                                               new Line("George", "10"),
                                               new Line("George", "10"),
                                               new Line("George", "10"),
                                               new Line("George", "10"),
                                               new Line("George", "10"),
                                               new Line("George", "10"),
                                               new Line("George", "10"),
                                               new Line("George", "10"),
                                               new Line("George", "10")));
    }


    @Test
    void verify_score_service_has_been_called_10_when_10_lines() {
        transformerService.getChancesByName(lines);
        verify(scoreService, times(10)).getScore(any());
    }

    @Test
    void verify_10_lines_become_a_hashMap_with_10_chances() {
        Map<String, List<Integer>> chancesByName = transformerService.getChancesByName(lines);
        assertThat(chancesByName.get("George"), hasSize(10));
    }
}