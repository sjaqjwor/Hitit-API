package me.hitit.api.services;

import me.hitit.api.domains.Device;
import me.hitit.api.domains.User;
import me.hitit.api.repositories.DeviceRepository;
import me.hitit.api.services.interfaces.DeviceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DeviceService")
public class DeviceService implements DeviceServiceInterface {
    @Autowired
    private DeviceRepository dr;

    @Override
    public Device getDevice(User u) {
        return dr.findOne(u.getIdx());
    }

    @Override
    public void deleteDevice(User u) {
        dr.delete(u.getIdx());
    }

    @Override
    public void save(Device d) {
        dr.save(d);
    }
}
