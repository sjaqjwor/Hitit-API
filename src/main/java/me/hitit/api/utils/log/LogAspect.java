package me.hitit.api.utils.log;

import java.sql.Timestamp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import me.hitit.api.controllers.responses.DefaultResponse;

/**
 * LogAspect class.
 * 
 * @author devetude
 */
@Component
@Aspect
public class LogAspect {
	/**
	 * Methods to process controller log.
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 * @see me.hitit.api.utils.log.ControllerLog
	 */
	@Around("@annotation(me.hitit.api.utils.log.ControllerLog)")
	public ResponseEntity<DefaultResponse> controllerLogAround(ProceedingJoinPoint pjp) throws Throwable {
		long startTM = System.currentTimeMillis();
		@SuppressWarnings("unchecked")
		ResponseEntity<DefaultResponse> re = (ResponseEntity<DefaultResponse>) pjp.proceed();
		long endTM = System.currentTimeMillis();

		Signature s = pjp.getSignature();
		Class<?> c = s.getDeclaringType();
		Gson g = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

		StringBuilder sb = new StringBuilder();
		sb.append("[Current Time] ").append(new Timestamp(System.currentTimeMillis())).append("\n");
		sb.append("[Controller Name] ").append(getClassName(c)).append("\n");
		sb.append("[API Name] ").append(s.getName()).append("\n");
		sb.append("[Request Objects] ").append("\n");
		sb.append(g.toJson(pjp.getArgs())).append("\n");
		sb.append("[Response Objects] ").append(re.getStatusCode()).append("\n");
		sb.append(g.toJson(re.getBody())).append("\n");
		sb.append("[Total Run Time] ").append(endTM - startTM).append("ms");

		System.out.print(sb.toString());

		return re;
	}

	private static String getClassName(Class<?> c) {
		if (c.isAnonymousClass())
			return getClassName(c.getEnclosingClass());

		return c.getName();
	}
}
