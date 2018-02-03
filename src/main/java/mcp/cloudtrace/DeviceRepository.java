package mcp.cloudtrace;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface DeviceRepository extends MongoRepository<Device, String> {
    String findByDeviceId(String device);
    List<Device> findAll();
}
