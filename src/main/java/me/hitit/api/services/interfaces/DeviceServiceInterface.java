package me.hitit.api.services.interfaces;

import me.hitit.api.domains.Device;
import me.hitit.api.domains.User;

public interface DeviceServiceInterface {
    Device getDevice(final User u);

    void save(final Device d);

    void deleteDevice(final User u);
}