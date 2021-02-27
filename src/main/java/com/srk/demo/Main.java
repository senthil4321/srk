package com.srk.demo;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.SystemConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args)  {

	updateConfiguration();

	logger.error("This is an error message");
	logger.debug("Hello,{}", "Good Moring");
	logger.info("@|KeyStyle {}|@ = @|ValueStyle {}|@", "one", "one");
    }

    private static void updateConfiguration() {
	CompositeConfiguration cconfig = new CompositeConfiguration();

	Configurations configs = new Configurations();
	Configuration config;
	try {
	    config = configs.properties(new File("config.properties"));
		cconfig.addConfiguration(new SystemConfiguration());
		cconfig.addConfiguration(config);
	} catch (ConfigurationException e) {
	
	    e.printStackTrace();
	}
	
        Iterator<String> keys = cconfig.getKeys();
        while (keys.hasNext()) {
            String key = keys.next();
            logger.info(key + " = " + cconfig.getProperty(key));
        }
    }
}
