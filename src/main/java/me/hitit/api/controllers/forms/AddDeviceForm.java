package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

import me.hitit.api.domains.Device.Type;

/**
 * AddDeviceForm class.
 * 
 * @author yeeeah_j, devetude
 */
public class AddDeviceForm {
	private static final Logger LOG = Logger.getLogger(AddDeviceForm.class.getSimpleName());

	private Type type;
	private String uuid;
	private String token;

	/**
	 * Constructor.
	 */
	public AddDeviceForm() {
		LOG.debug("DeviceForm");
	}

	/**
	 * Constructor.
	 * 
	 * @param type
	 * @param uuid
	 * @param token
	 */
	public AddDeviceForm(final Type type, final String uuid, final String token) {
		LOG.debug("DeviceForm");

		this.type = type;
		this.uuid = uuid;
		this.token = token;
	}

	/**
	 * Methods to get type.
	 * 
	 * @return
	 */
	public Type getType() {
		LOG.debug("getType");

		return type;
	}

	/**
	 * Methods to get uuid.
	 * 
	 * @return
	 */
	public String getUuid() {
		LOG.debug("getUuid");

		return uuid;
	}

	/**
	 * Methods to get token.
	 * 
	 * @return
	 */
	public String getToken() {
		LOG.debug("getToken");

		return token;
	}
}