package com.example.annotation.model;

import lombok.Data;

@Data
public class DeviceInfo {

    private String item1;
    private String item2;
    private String item3;
    private String item4;
    private String item5;

    public DeviceInfo(String item, String item1, String item2, String item3, String item4) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item;
    }
}
