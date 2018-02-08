package me.hitit.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * SpringBootApplication class.
 * 
 * @author devetude
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class HititApplication {
	private static final Logger LOG = Logger.getLogger(HititApplication.class.getSimpleName());

	public static void main(String[] args) {
		LOG.debug("main");

		SpringApplication.run(HititApplication.class, args);
	}

	@PersistenceContext
	private EntityManager em;

	@Bean
	public JPAQueryFactory queryFactory() {
		return new JPAQueryFactory(em);
	}
}