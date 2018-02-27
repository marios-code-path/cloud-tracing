package mcp.cloudtrace;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

interface DeviceRepository extends JpaRepository<Device, Long> {
    Collection<Device> findBydeviceId(String dn);
}
