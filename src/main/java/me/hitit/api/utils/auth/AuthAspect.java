package me.hitit.api.utils.auth;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.domains.User;
import me.hitit.api.services.UserService;
import me.hitit.api.utils.auth.JWT.Token;
import me.hitit.api.utils.res.Strings;

/**
 * AuthAspect class.
 * 
 * @author devetude
 */
@Component
@Aspect
public class AuthAspect {
	@Autowired
	private HttpServletRequest hsr;

	@Autowired
	private UserService us;

	/**
	 * Methods to process authorization.
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 * @see me.hitit.api.utils.auth.Auth
	 */
	@Around("@annotation(me.hitit.api.utils.auth.Auth)")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String jwt = hsr.getHeader("Authorization");

		if (jwt == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.MUST_NEED_JWT);
			return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		Token t = JWT.decode(jwt);

		if (t == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.FAIL_TO_DECODE_TOKEN);
			return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		User u = us.getUser(t.getUidx());

		if (u == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_USER);
			return new ResponseEntity<>(dr, HttpStatus.UNAUTHORIZED);
		}

		Object[] params = pjp.getArgs();

		for (int i = 0; i < params.length; i++) {
			if (params[i] instanceof User) {
				params[i] = u;

				break;
			}
		}

		return pjp.proceed(params);
	}
}