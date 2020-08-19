package com.hhwy.device.info.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 王阳
 * @create 2020-07-13-14:51
 * 设备信息实体
 */
public class DeviceInfo implements Serializable {
    private String id;
    /**
     * 所属类别
     */
    private String deviceType;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 设备编号
     */
    private String deviceCode;

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "id='" + id + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

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
}
