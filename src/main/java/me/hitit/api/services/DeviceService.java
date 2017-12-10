package me.hitit.api.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.hitit.api.domains.Device;
import me.hitit.api.domains.User;
import me.hitit.api.repositories.DeviceRepository;
import me.hitit.api.services.interfaces.DeviceServiceInterface;

/**
 * DeviceService class.
 *
 * @author yeeeah_j, devetude
 */
@Service("DeviceService")
public class DeviceService implements DeviceServiceInterface {
	private static final Logger LOG = Logger.getLogger(DeviceService.class.getSimpleName());

	@Autowired
	private DeviceRepository dr;

	@Override
	public Device getDevice(final User u) {
		LOG.debug("getDevice");

		return dr.findOne(u.getIdx());
	}

	@Override
	public void deleteDevice(final User u) {
		LOG.debug("deleteUser");

		dr.delete(u.getIdx());
	}

	@Override
	public void save(final Device d) {
		LOG.debug("add Device.");

		dr.save(d);
	}
}