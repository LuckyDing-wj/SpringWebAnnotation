package com.example.annotation.controller;

import com.example.annotation.model.DeviceInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @PostMapping("/device/add")
    public String addDeviceInfo(@RequestParam("deviceInfo") DeviceInfo deviceInfo) {
        return deviceInfo.toString();
    }
}
