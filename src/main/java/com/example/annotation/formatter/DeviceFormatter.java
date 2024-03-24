package com.example.annotation.formatter;

import com.example.annotation.model.DeviceInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;
import java.util.StringJoiner;

@Configuration
public class DeviceFormatter implements Formatter<DeviceInfo> {

    @Override
    public DeviceInfo parse(String text, Locale locale) throws ParseException {
        if (StringUtils.hasLength(text)) {
            String[] items = text.split(";");
            return new DeviceInfo(items[0], items[1], items[2], items[3], items[4]);
        }
        return null;
    }

    @Override
    public String print(DeviceInfo object, Locale locale) {
        StringJoiner joiner = new StringJoiner("#");
        joiner.add(object.getItem1()).add(object.getItem2()).add(object.getItem3()).add(object.getItem4()).add(object.getItem5());
        return joiner.toString();
    }
}
