package com.hhwy.device.info.service.impl;

import com.hhwy.device.info.domain.DeviceInfo;
import com.hhwy.device.info.domain.DeviceInfoDTO;
import com.hhwy.device.info.domain.DeviceInfoVo;
import com.hhwy.device.info.service.DeviceInfoService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王阳
 * @create 2020-07-13-15:20
 */
@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    @Override
    public int insertDeviceInfo(DeviceInfo deviceInfo) {
        int flag = sqlSessionTemplate.insert("deviceInfo.sql.insertDeviceInfo",deviceInfo);
        return flag;
    }

    @Override
    public List<DeviceInfoDTO> listDeviceInfo(DeviceInfoVo deviceInfoVo) {
        List<DeviceInfo> list = sqlSessionTemplate.selectList("deviceInfo.sql.listDeviceInfo",deviceInfoVo);
        List<DeviceInfoDTO> results = new ArrayList<>();
        /**
         * 将设备信息实体 转换为 另一个实体，实现给用户直接文字展示所属类别
         */
        if (list.size()>0) {
            results = new ArrayList<>();
            for (DeviceInfo deviceInfo : list) {
                DeviceInfoDTO deviceInfoDetail = new DeviceInfoDTO();
                BeanUtils.copyProperties(deviceInfo, deviceInfoDetail);
                String typeCode = deviceInfo.getDeviceType();
                String typeName = sqlSessionTemplate.selectOne("deviceInfo.sql.selectTypeName", typeCode);
                deviceInfoDetail.setTypeName(typeName);
                results.add(deviceInfoDetail);
            }
        }
        return results;
    }

    @Override
    public int countDeviceInfo(DeviceInfoVo deviceInfo) {
        int count = sqlSessionTemplate.selectOne("deviceInfo.sql.countDeviceInfo",deviceInfo);
        return count;
    }

    @Override
    public int deleteDeviceInfo(String id) {
        int flag = sqlSessionTemplate.delete("deviceInfo.sql.delDeviceInfo",id);
        return flag;
    }

    @Override
    public int updateDeviceInfo(DeviceInfo deviceInfo) {
        int flag = sqlSessionTemplate.update("deviceInfo.sql.updateDeviceInfo",deviceInfo);
        return flag;
    }
}
