package me.hitit.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.hitit.api.domains.Device;

/**
 * DeviceRepository interface.
 * 
 * @author yeeeah_j, devetude
 */
public interface DeviceRepository extends JpaRepository<Device, Long> {
}