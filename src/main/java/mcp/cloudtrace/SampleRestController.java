package mcp.cloudtrace;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class SampleRestController {
    private DeviceRepository deviceRepo;

    public SampleRestController(DeviceRepository ds) {
        this.deviceRepo = ds;
    }

    @GetMapping("/devices")
    public List<Device> deviceNames() {
       // log.info("Traces in the wind");
       // log.finest("This is the finest log");
        return this.deviceRepo.findAll();
    }
}
