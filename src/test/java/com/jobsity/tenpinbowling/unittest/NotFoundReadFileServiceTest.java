package com.jobsity.tenpinbowling.unittest;

import com.jobsity.tenpinbowling.service.ReadFileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
class NotFoundReadFileServiceTest {

    @Autowired
    ReadFileService readFileService;

    String fileInput;

    @BeforeEach
    public void setUp(){
        fileInput = "/not-found-file.txt";
    }

    @Test
    void not_found_file_throws_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            readFileService.read(fileInput);
        });
    }


}