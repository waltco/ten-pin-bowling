package com.jobsity.tenpinbowling.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class Properties {
    @Value("${tenpinbowling.input.filename}")
    private String inputFile;

    @Value("${tenpinbowling.output.filename}")
    private String outputFile;
}
