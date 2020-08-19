package com.hhwy.device.info.domain;

import com.hhwy.pojo.PagingProperty;
import org.springframework.stereotype.Component;

import java.io.StringReader;

/**
 * @author 王阳
 * @create 2020-07-13-14:55
 */
@Component
public class DeviceInfoVo extends PagingProperty {
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 设备编码
     */
    private String deviceCode;
    /**
     * 所属类别
     */
    private String deviceType;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
