package com.hhwy.device.type.service;

import com.hhwy.device.type.domain.DeviceType;
import com.hhwy.device.type.domain.TreeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王阳
 * @create 2020-07-13-11:36
 */
public interface DeviceTypeService {
    /**
     * 部门类型树
     * @return
     */
    public List<TreeModel> deviceTypeTree();

    /**
     * 添加设备类型
     * @param deviceType
     * @return
     */
    public int insertDeviceType(DeviceType deviceType);

    /**
     * 删除设备类型
     * @param id
     * @return
     */
    public int delDeviceType(int id);

    /**
     * 修改设备类型
     * @param deviceType
     * @return
     */
    public int updateDeviceType(DeviceType deviceType);

    /**
     * 检测是否存在类别编码
     * @param typeCode
     * @return
     */
    public String testTypeCode(String typeCode);

    /**
     * 删除所有设备信息
     * @param id
     * @return
     */
    public int delDeviceInfos(int id);
    public boolean selectNodeByName(DeviceType deviceType);
    public int updateTypeTree(DeviceType deviceType) throws Exception;

}
