package com.jobsity.tenpinbowling.integrationtest;

import com.jobsity.tenpinbowling.service.TenPinBowlingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestPropertySource(properties = "tenpinbowling.input.filename=src/test/resources/input-files/two-players-score.txt")
public class TwoPlayersScoreTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String expectedResult;

    @Autowired
    TenPinBowlingService tenPinBowlingService;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    public void setUpExpectedResult() {
        expectedResult = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n" +
                "Jeff\n" +
                "Pinfalls\t \tX\t7\t/\t9\t0\t \tX\t0\t8\t8\t/\t0\t6\t \tX\t \tX\tX\t8\t1\t\n" +
                "Score\t\t20\t\t39\t\t48\t\t66\t\t74\t\t84\t\t90\t\t120\t\t148\t\t167\t\n" +
                "John\n" +
                "Pinfalls\t3\t/\t6\t3\t \tX\t8\t1\t \tX\t \tX\t9\t0\t7\t/\t4\t4\tX\t9\t0\t\n" +
                "Score\t\t16\t\t25\t\t44\t\t53\t\t82\t\t101\t\t110\t\t124\t\t132\t\t151\t";

    }

    @Test
    void two_players_score() {
        tenPinBowlingService.run();
        assertEquals(expectedResult, outContent.toString());
    }

}
