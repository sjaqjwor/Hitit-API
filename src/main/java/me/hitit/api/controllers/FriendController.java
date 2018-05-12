package me.hitit.api.controllers;

import io.swagger.annotations.Api;
import lombok.NonNull;
import me.hitit.api.controllers.forms.AddFriendsForm;
import me.hitit.api.controllers.forms.UpdateFriendBlockForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.data.friend.BlockFriendsResponseData;
import me.hitit.api.controllers.responses.data.friend.FriendResponseData;
import me.hitit.api.controllers.responses.data.friend.GetFriendsResponseData;
import me.hitit.api.domains.Friend;
import me.hitit.api.domains.User;
import me.hitit.api.services.FriendService;
import me.hitit.api.utils.auth.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("")
@Api
public class FriendController {
    @NonNull
    @Autowired
    FriendService fs;

    @GetMapping("friends")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> getFriends(
            @RequestHeader("Authorization") String jwt,
            @RequestParam("page") Long page,
            @RequestParam("sort") String sort,
            @ApiIgnore User u) throws Exception {
        List<FriendResponseData> frds = fs.getFriends(u.getIdx(), sort, page);
        GetFriendsResponseData gfrd = GetFriendsResponseData.builder().friendResponseData(frds).build();
        return new ResponseEntity<>(new DefaultResponse(gfrd), HttpStatus.OK);
    }

    @GetMapping("friends/block")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> getBlockFriends(
            @RequestHeader("Authorization") String jwt,
            @RequestParam("page") Long page,
            @RequestParam("sort") String sort,
            @ApiIgnore User u) throws Exception {
        List<BlockFriendsResponseData> bfrds = fs.getBlockFriends(u.getIdx(), sort, page);
        GetFriendsResponseData gfrd = GetFriendsResponseData.builder().blockFriendsResponseData(bfrds).build();
        return new ResponseEntity<>(new DefaultResponse(gfrd), HttpStatus.OK);
    }

    @GetMapping("friends/find/{keyword}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> findFriends(
            @RequestHeader("Authorization") String jwt,
            @RequestParam("page") Long page,
            @RequestParam("sort") String sort,
            @PathVariable("keyword") String keyword,
            @ApiIgnore User u) {
        List<FriendResponseData> frds = fs.getFindFriends(u.getIdx(), sort, page, keyword);
        GetFriendsResponseData gfrd = GetFriendsResponseData.builder().friendResponseData(frds).build();
        return new ResponseEntity<>(new DefaultResponse(gfrd), HttpStatus.OK);
    }

    @PutMapping("friends")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> addFriends(@RequestHeader("Authorization") String jwt, AddFriendsForm aff) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PutMapping("friend/block/{fuidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> updateFriendBlock(
            @RequestHeader("Authorization") String jwt,
            @PathVariable("fuidx") Long fuidx,
            @ApiIgnore User u,
            @RequestBody Boolean changeBlock) throws Exception {
        fs.updateFriendBlock(u.getIdx(), fuidx, changeBlock);
        return new ResponseEntity<>(new DefaultResponse(), HttpStatus.OK);
    }
}
