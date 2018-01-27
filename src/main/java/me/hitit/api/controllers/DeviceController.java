package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.hitit.api.controllers.forms.UpdateDeviceForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.utils.auth.Auth;

@RestController
@RequestMapping("")
@Api
public class DeviceController {
	private static final Logger LOG = Logger.getLogger(DeviceController.class.getSimpleName());

	@GetMapping("devices/{uidx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getDevices(@RequestHeader("Authorization") final String jwt,
			@PathVariable("uidx") final Long uidx) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@GetMapping("device/{didx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getDevice(@RequestHeader("Authorization") final String jwt,
			@PathVariable("didx") final Long didx) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@DeleteMapping("device/{didx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> deleteDevice(@RequestHeader("Authorization") final String jwt,
			@PathVariable("didx") final Long didx) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("device")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> updateDevice(
			@RequestHeader("Authorization") final String jwt, final UpdateDeviceForm udf) {
		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}