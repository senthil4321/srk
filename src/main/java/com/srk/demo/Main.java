package com.srk.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println("Hello World");
        System.out.println("Hello World 2");
        logger.error("This is an error message");
    }

}
