package me.hitit.api.controllers;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.UpdateDeviceForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@Api
public class DeviceController {
    @GetMapping("devices/{uidx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> getDevices(
            @RequestHeader("Authorization") String jwt, @PathVariable("uidx") Long uidx) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
    }

    @GetMapping("device/{didx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> getDevice(
            @RequestHeader("Authorization") String jwt, @PathVariable("didx") Long didx) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
    }

    @DeleteMapping("device/{didx}")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> deleteDevice(
            @RequestHeader("Authorization") String jwt, @PathVariable("didx") Long didx) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
    }

    @PutMapping("device")
    @Auth
    @ResponseBody
    public ResponseEntity<DefaultResponse> updateDevice(
            @RequestHeader("Authorization") String jwt, UpdateDeviceForm udf) {
        DefaultResponse dr = new DefaultResponse();
        return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
    }
}
