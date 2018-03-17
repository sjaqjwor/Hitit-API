package me.hitit.api.controllers;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.AddChatMember;
import me.hitit.api.controllers.forms.AddMessageForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@Api
public class ChatController {
    @GetMapping("chats")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> getChats(@RequestHeader("Authorization") String jwt) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PostMapping("chat/{uidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> addChat(
            @RequestHeader("Authorization") String jwt, @PathVariable("uidx") Long uidx) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PostMapping("chat/message")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> addMessage(@RequestHeader("Authorization") String jwt, AddMessageForm amf) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @PostMapping("chat/member")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> addChatMember(
            @RequestHeader("Authorization") String jwt, AddChatMember acm) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }

    @DeleteMapping("chat/{cidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> deleteChat(
            @RequestHeader("Authorization") String jwt, @PathVariable("cidx") Long cidx) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<>(dr, HttpStatus.OK);
    }
}
