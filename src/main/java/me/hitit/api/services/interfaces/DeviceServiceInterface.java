package me.hitit.api.services.interfaces;

import me.hitit.api.domains.Device;
import me.hitit.api.domains.User;

/**
 * DeviceService Interface.
 *
 * @author yeeeah_j, devetude
 */
public interface DeviceServiceInterface {
	/**
	 * Methods to get device by user.
	 *
	 * @param u
	 * @return
	 */
	public Device getDevice(final User u);

	public void save(final Device d);

	/**
	 * Methods to delete device by user.
	 *
	 * @param u
	 */
	public void deleteDevice(final User u);
}