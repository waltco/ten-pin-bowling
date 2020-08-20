package com.jobsity.tenpinbowling.unittest;

import com.jobsity.tenpinbowling.service.ReadFileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
class ValidReadFileServiceTest {

    @Autowired
    ReadFileService readFileService;

    String fileInput;

    @BeforeEach
    public void setUp(){
        fileInput = "src/test/resources/unittest/two-players-score.txt";
    }

    @Test
    void file_is_valid_contains_a_foul() {
        List<String> content = readFileService.read(fileInput);
        assertThat(content, hasItem("Jeff F"));
    }

    @Test
    void file_is_valid_contains_a_strike() {
        List<String> content = readFileService.read(fileInput);
        assertThat(content, hasItem("John 10"));
    }

    @Test
    void file_is_valid_contains_35_lines() {
        List<String> content = readFileService.read(fileInput);
        assertThat(content, hasSize(35));
    }
}