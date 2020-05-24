package com.srk.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.error("This is an error message");
        logger.debug("Hello,{}", "Good Moring");
        logger.info("@|KeyStyle {}|@ = @|ValueStyle {}|@", "one", "one");
    }
}
