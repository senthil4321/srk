package com.srk.demo.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class EnvConfig1 {
	private final String myprop;

	@Inject
	public EnvConfig1(@Named("vin") String myprop) {
		this.myprop = myprop;
	}

	public String getMyprop() {
		return myprop;
	}
}
class EnvConfig2 {
	private final String myprop;

	@Inject
	public EnvConfig2(@Named("serialNo") String myprop) {
		this.myprop = myprop;
	}

	public String getMyprop() {
		return myprop;
	}
}
public class EnvConfig {
	public static void main(String[] args) {
		AbstractModule module = new AbstractModule() {
			@Override
			protected void configure() {
				Properties defaults = new Properties();
				defaults.setProperty("vin", "default");
				try {
					Properties props = new Properties(defaults);
					props.load(new FileInputStream("EnvConfig.properties"));
					Names.bindProperties(binder(), props);
				} catch (IOException e) {
					// logger.error("Could not load config: ", e);
					System.out.println("Y");
					System.exit(1);
				}
			}
		};

		final EnvConfig1 instance = Guice.createInjector(module).getInstance(EnvConfig1.class);
		final EnvConfig2 instance2 = Guice.createInjector(module).getInstance(EnvConfig2.class);

		System.out.println("vin = " + instance.getMyprop());
		System.out.println("vin = " + instance2.getMyprop());
	}
}
