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
@TestPropertySource(properties = "tenpinbowling.input.filename=src/test/resources/input-files/perfect-score.txt")
public class PerfectScoreTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String expectedResult;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    public void setUpResult() {
        expectedResult = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n" +
                "Carl\n" +
                "Pinfalls\t \tX\t \tX\t \tX\t \tX\t \tX\t \tX\t \tX\t \tX\t \tX\tX\tX\tX\t\n" +
                "Score\t\t30\t\t60\t\t90\t\t120\t\t150\t\t180\t\t210\t\t240\t\t270\t\t300\t";
    }

    @Autowired
    TenPinBowlingService tenPinBowlingService;

    @Test
    void Perfect_Score() {
        tenPinBowlingService.run();
        assertEquals(expectedResult, outContent.toString());
    }

}
