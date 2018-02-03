package mcp.cloudtrace;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

class SampleRestController {
    DeviceRepository deviceRepo;

    public void SampleRestController(DeviceRepository ds) {
        this.deviceRepo = ds;
    }

    @GetMapping("/devices")
    public List<Device> deviceNames() {
        return deviceRepo.findAll();
    }
}
