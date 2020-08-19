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
@TestPropertySource(properties = "tenpinbowling.input.filename=src/test/resources/input-files/zero-score.txt")
public class ZeroScoreTest {

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
                "Carl\n" +
                "Pinfalls\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\n" +
                "Score\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t";

    }

    @Test
    void zero_score() {
        tenPinBowlingService.run();
        assertEquals(expectedResult, outContent.toString());
    }

}
