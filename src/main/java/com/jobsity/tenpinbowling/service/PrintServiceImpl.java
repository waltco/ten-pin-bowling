package com.jobsity.tenpinbowling.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PrintServiceImpl implements PrintService {

    Logger logger = LoggerFactory.getLogger(PrintServiceImpl.class);

    /**
     * Print the value in a File of a given content and filepath as String
     * @param content
     *
     */
    @Override
    public void print(StringBuilder content) {
        System.out.print(content);
    }

}
