package com.hhwy.device.info.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 王阳
 * @create 2020-07-13-14:51
 * 该类型实现设备信息的类型编号转为类型名称
 */
@Component
public class DeviceInfoDTO implements Serializable {
    private String id;
    /**
     * 所属类别
     */
    private String typeName;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 设备编号
     */
    private String deviceCode;

    private String deviceType;

    @Override
    public String toString() {
        return "DeviceInfoBO{" +
                "id='" + id + '\'' +
                ", typeName='" + typeName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
