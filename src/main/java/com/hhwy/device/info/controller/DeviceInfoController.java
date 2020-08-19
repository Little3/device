package com.hhwy.device.info.controller;

import com.hhwy.device.info.domain.DeviceInfo;
import com.hhwy.device.info.domain.DeviceInfoDTO;
import com.hhwy.device.info.domain.DeviceInfoVo;
import com.hhwy.device.info.service.DeviceInfoService;
import com.hhwy.framework.PlatformTools;
import com.hhwy.pojo.AjaxPagingResult;
import com.hhwy.pojo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 王阳
 * @create 2020-07-13-15:21
 */
@RestController
@RequestMapping("deviceInfoController")
public class DeviceInfoController {
    @Autowired
    DeviceInfoService deviceInfoService;

    /**
     * 添加设备信息
     * @param deviceInfo
     * @return
     */
    @RequestMapping(value = "/insertDeviceInfo" ,method = RequestMethod.POST)
    public AjaxResult insertDeviceInfo(@RequestBody DeviceInfo deviceInfo) {
        AjaxResult ajaxResult = new AjaxResult();
        deviceInfo.setId(PlatformTools.getID());
        int flag;
        try {
            flag=deviceInfoService.insertDeviceInfo(deviceInfo);
            ajaxResult.setFlag(true);
            ajaxResult.setMsg("添加成功");
        } catch (Exception e){
            e.printStackTrace();
            ajaxResult.setFlag(false);
            ajaxResult.setMsg("添加失败"+ e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 分页查询设备信息
     * @param deviceInfo
     * @return
     */
    @RequestMapping(value="/listDeviceInfo",method = RequestMethod.POST)
    public AjaxPagingResult<DeviceInfoDTO> listDeviceInfo(@RequestBody DeviceInfoVo deviceInfo) {
        AjaxPagingResult<DeviceInfoDTO> ajaxResult = new AjaxPagingResult<>();
        int count;
        List<DeviceInfoDTO> dList = null;
        try {
            dList =deviceInfoService.listDeviceInfo(deviceInfo);
            count = deviceInfoService.countDeviceInfo(deviceInfo);
            ajaxResult.setRows(dList);
            ajaxResult.setFlag(true);
            ajaxResult.setTotal(count);
            ajaxResult.setMsg("查询成功");
        } catch (Exception e){
            e.printStackTrace();
            ajaxResult.setFlag(false);
            ajaxResult.setMsg("查询失败"+ e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 删除设备信息
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteDeviceInfo")
    public AjaxResult deleteDeviceInfo(String id) {
        AjaxResult ajaxResult = new AjaxResult();
        int flag;
        try {
            flag = deviceInfoService.deleteDeviceInfo(id);
            ajaxResult.setFlag(true);
            ajaxResult.setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setFlag(false);
            ajaxResult.setMsg("删除失败");
        }
        return ajaxResult;
    }
    /**
     * 修改设备信息
     * @param deviceInfo
     * @return
     */
    @PostMapping(value = "/updateDeviceInfo")
    public AjaxResult updateDeviceInfo(@RequestBody DeviceInfo deviceInfo) {
        AjaxResult ajaxResult = new AjaxResult();
        int flag;
        try {
            flag = deviceInfoService.updateDeviceInfo(deviceInfo);
            ajaxResult.setFlag(true);
            ajaxResult.setMsg("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setFlag(false);
            ajaxResult.setMsg("修改失败");
        }
        return ajaxResult;
    }
}
