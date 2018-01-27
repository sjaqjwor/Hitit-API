package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.Device.Type;

/**
 * AddDeviceForm class.
 * 
 * @author yeeeah_j, devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddDeviceForm {
	private static final Logger LOG = Logger.getLogger(AddDeviceForm.class.getSimpleName());

	private Type type;
	private String uuid;
	private String token;
}