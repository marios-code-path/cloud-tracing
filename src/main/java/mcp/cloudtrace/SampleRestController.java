package mcp.cloudtrace;

import lombok.extern.java.Log;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Log
class SampleRestController {
    private final DeviceRepository deviceRepo;
    private final RestTemplate restTemplate;

    public SampleRestController(DeviceRepository ds,
                                RestTemplate rt) {
        this.deviceRepo = ds;
        this.restTemplate = rt;
    }


    @GetMapping("/devices")
    public List<Device> deviceNames(@RequestHeader(name = "user-name", required = false) String username) {
        log.info("FYI: Hermia");
        log.info("name: " + username);
        return this.deviceRepo.findAll();
    }

    @GetMapping("/front")
    public String callDevices(@RequestHeader(name = "user-name", required = false) String username) {
        log.info("Username: " + username);
        return restTemplate.getForObject("http://localhost:8080/devices", String.class);
    }
}

