package me.hitit.api.controllers;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.AddFriendsForm;
import me.hitit.api.controllers.forms.UpdateFriendBlockForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.data.friend.FriendResponseData;
import me.hitit.api.controllers.responses.data.friend.GetFriendResponseData;
import me.hitit.api.domains.Friend;
import me.hitit.api.domains.User;
import me.hitit.api.services.FriendService;
import me.hitit.api.utils.auth.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("")
@Api
public class FriendController {
    @Autowired
    FriendService fs;

    @GetMapping("friends")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> getFriends(
            @Valid @RequestHeader("Authorization") String jwt, @RequestParam("page") Long page,
            @RequestParam("sort") String sort, @ApiIgnore User u) throws Exception {
        List<Friend> friends = fs.getFriends(u.getIdx(), sort, page);
        List<FriendResponseData> frds = friends.stream().map(f -> FriendResponseData.builder()
                .fuidx(f.getFriendPk().getFriendUser().getIdx())
                .email(f.getFriendPk().getFriendUser().getEmail())
                .name(f.getFriendPk().getFriendUser().getName())
                .phoneNumber(f.getFriendPk().getFriendUser().getPhoneNumber())
                .checkBlock(f.getCheckBlock())
                .build())
                .collect(Collectors.toList());
        GetFriendResponseData gfrd = GetFriendResponseData.builder().friendResponseDatas(frds).build();
        return new ResponseEntity<>(new DefaultResponse(gfrd), HttpStatus.OK);
    }

    @GetMapping("friends/find/{keyword}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> findFriends(
            @Valid @RequestHeader("Authorization") String jwt, @RequestParam("page") Long page,
            @RequestParam("sort") String sort, @PathVariable("keyword") String keyword, @ApiIgnore User u) {
        List<Friend> friends = fs.getFindFriends(u.getIdx(), sort, page, keyword);
        List<FriendResponseData> frds = friends.stream().map(f -> FriendResponseData.builder()
                .fuidx(f.getFriendPk().getFriendUser().getIdx())
                .email(f.getFriendPk().getFriendUser().getEmail())
                .name(f.getFriendPk().getFriendUser().getName())
                .phoneNumber(f.getFriendPk().getFriendUser().getPhoneNumber())
                .checkBlock(f.getCheckBlock())
                .build())
                .collect(Collectors.toList());
        GetFriendResponseData gfrd = GetFriendResponseData.builder().friendResponseDatas(frds).build();
        return new ResponseEntity<>(new DefaultResponse(gfrd), HttpStatus.OK);
    }

    @PutMapping("friends")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> addFriends(@Valid @RequestHeader("Authorization") String jwt, AddFriendsForm aff) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PutMapping("friend/block/{fuidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> updateFriendBlock(
            @Valid @RequestHeader("Authorization") String jwt, @PathVariable("fuidx") Long fuidx,
            @ApiIgnore User u, @RequestBody UpdateFriendBlockForm ufbf) throws Exception {
        Friend f = fs.updateFriendBlock(u.getIdx(), fuidx, ufbf);
        FriendResponseData frd = FriendResponseData.builder()
                .fuidx(f.getFriendPk().getFriendUser().getIdx())
                .email(f.getFriendPk().getFriendUser().getEmail())
                .name(f.getFriendPk().getFriendUser().getName())
                .phoneNumber(f.getFriendPk().getFriendUser().getPhoneNumber())
                .checkBlock(f.getCheckBlock())
                .build();
        GetFriendResponseData gfrd = GetFriendResponseData.builder()
                .friendResponseData(frd)
                .build();
        return new ResponseEntity<>(new DefaultResponse(gfrd), HttpStatus.OK);
    }
}
