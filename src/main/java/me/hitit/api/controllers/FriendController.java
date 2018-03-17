package me.hitit.api.controllers;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.AddFriendsForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@Api
public class FriendController {
    @GetMapping("friends")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> getFriends(
            @RequestHeader("Authorization") String jwt, @RequestParam("page") Long page,
            @RequestParam("sort") String sort) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
    }

    @GetMapping("friends/find/{keyword}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> findFriends(
            @RequestHeader("Authorization") String jwt, @RequestParam("page") Long page,
            @RequestParam("sort") String sort, @PathVariable("keyword") String keyword) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
    }

    @PutMapping("friends")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> addFriends(@RequestHeader("Authorization") String jwt, AddFriendsForm aff) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
    }

    @PutMapping("friend/{uidx}/block/{status}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> updateFriendBlock(
            @RequestHeader("Authorization") String jwt, @PathVariable("uidx") String uidx,
            @PathVariable("status") Boolean status) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
    }
}
