package me.hitit.api.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.hitit.api.controllers.forms.AddDeviceForm;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.domains.Device;
import me.hitit.api.domains.User;
import me.hitit.api.services.DeviceService;
import me.hitit.api.services.UserService;
import me.hitit.api.utils.auth.Auth;
import me.hitit.api.utils.log.ControllerLog;
import me.hitit.api.utils.res.Strings;
import springfox.documentation.annotations.ApiIgnore;

/*
 * DeviceController class.
 *
 * @author yeeeah_j, devetude
*/
@RestController
@RequestMapping("device")
public class DeviceController {
	private static final Logger LOG = Logger.getLogger(DeviceController.class.getSimpleName());

	@Autowired
	private UserService us;

	@Autowired
	private DeviceService ds;

	/**
	 * Methods to get device by user index.
	 *
	 * @param jwt
	 * @param u
	 * @param uidx
	 * @return
	 */
	@GetMapping("/{uidx}")
	@Auth
	@ControllerLog
	public ResponseEntity<DefaultResponse> getDevice(@RequestHeader("Authorization") final String jwt,
			@ApiIgnore final User u, @PathVariable("uidx") final long uidx) {
		DefaultResponse dr = new DefaultResponse(ds.getDevice(us.getUser(uidx)));
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	/**
	 * Methods to add device.
	 *
	 * @param jwt
	 * @param u
	 * @param adf
	 * @return
	 */
	@PostMapping("")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addDevice(@RequestHeader("Authorization") final String jwt,
			@ApiIgnore final User u, @RequestBody final AddDeviceForm adf) {
		Device d = u.getDevice();

		if (d == null) {
			d = new Device();
			d.setUser(u);
		}

		d.setToken(adf.getToken());
		d.setType(adf.getType());
		d.setUuid(adf.getUuid());

		ds.save(d);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}

	/**
	 * Methods to delete device by user index.
	 *
	 * @param jwt
	 * @param u
	 * @return
	 */
	@DeleteMapping("")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> deleteDevice(@RequestHeader("Authorization") final String jwt,
			@ApiIgnore final User u) {
		Device d = ds.getDevice(u);

		if (d == null) {
			LOG.warn(Strings.CAN_NOT_FOUND_DEVICE);

			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_DEVICE);
			return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		ds.deleteDevice(u);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}
}
