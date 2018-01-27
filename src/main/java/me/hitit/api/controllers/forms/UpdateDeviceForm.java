package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.Device.Type;

/**
 * UpdateDeviceForm class.
 * 
 * @author devetude
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDeviceForm {
	private static final Logger LOG = Logger.getLogger(UpdateDeviceForm.class.getSimpleName());

	private Type type;
	private String uuid;
	private String token;
}