package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.AddFriendForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.domains.Friend;
import me.hitit.api.domains.User;
import me.hitit.api.domains.pks.FriendPK;
import me.hitit.api.services.FriendService;
import me.hitit.api.services.UserService;
import me.hitit.api.utils.auth.Auth;
import me.hitit.api.utils.auth.JWT;
import me.hitit.api.utils.auth.JWT.Token;
import springfox.documentation.annotations.ApiIgnore;

/**
 * FriendController class.
 *
 * @author cheoljin_k
 */
@RestController
@RequestMapping("friend")
@Api
public class FriendController {
	private static final Logger LOG = Logger.getLogger(FriendController.class.getSimpleName());

	@Autowired
	private FriendService fs;

	@Autowired
	private UserService us;

	@PostMapping("")
	@Auth
	@Transactional
	public @ResponseBody ResponseEntity<DefaultResponse> addFrined(@RequestHeader("Authorization") final String jwt,
			@ApiIgnore User u, @ApiIgnore Friend f, @ApiIgnore FriendPK fpk,@RequestBody final AddFriendForm aff) {

		Token token = JWT.decode(jwt);
		long tuidx = token.getUidx();
		long[] fuidxs = aff.getFuidx();

		User fu = new User();
		User tu = us.getUser(tuidx);

		for (long fuidx : fuidxs) {
			fu = us.getUser(fuidx);
			if(fuidx == tuidx) {
				DefaultResponse dr = new DefaultResponse(Status.FAIL);
				return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
			} else if(fu == null) {
				DefaultResponse dr = new DefaultResponse(Status.FAIL);
				return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
			}
			fpk.setFriendUser(fu);
			fpk.setTargetUser(tu);
			f.setFriendPk(fpk);
			fs.addFriend(f);
			f = new Friend();
			fpk = new FriendPK();
		}

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@DeleteMapping("")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> deleteFriend(@RequestHeader("Authorization") final String jwt) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}
