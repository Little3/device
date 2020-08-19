package com.hhwy.device.info.service;

import com.hhwy.device.info.domain.DeviceInfo;
import com.hhwy.device.info.domain.DeviceInfoDTO;
import com.hhwy.device.info.domain.DeviceInfoVo;

import java.util.List;

/**
 * @author 王阳
 * @create 2020-07-13-15:18
 */
public interface DeviceInfoService {
    /**
     * 添加设备信息
     * @param deviceInfo
     * @return
     */
    public int insertDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 查询设备信息
     * @param deviceInfoVo
     * @return
     */
    public List<DeviceInfoDTO> listDeviceInfo(DeviceInfoVo deviceInfoVo);

    /**
     * 统计设备信息记录
     * @param deviceInfo
     * @return
     */
    public int countDeviceInfo(DeviceInfoVo deviceInfo);

    /**
     * 删除设备信息
     * @param id
     * @return
     */
    public int deleteDeviceInfo(String id);

    /**
     * 修改设备信息
     * @param deviceInfo
     * @return
     */
    public int updateDeviceInfo(DeviceInfo deviceInfo);
}
