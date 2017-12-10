package me.hitit.api;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringBootApplication class.
 * 
 * @author devetude
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class HititApplication {
	private static final Logger LOG = Logger.getLogger(HititApplication.class.getSimpleName());

	/**
	 * Methods to run spring application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.debug("main");

		SpringApplication.run(HititApplication.class, args);
	}
}