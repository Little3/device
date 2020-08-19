package com.hhwy.device.type.controller;

import com.hhwy.device.info.service.DeviceInfoService;
import com.hhwy.device.type.domain.DeviceType;
import com.hhwy.device.type.domain.TreeModel;
import com.hhwy.device.type.service.DeviceTypeService;
import com.hhwy.framework.PlatformTools;
import com.hhwy.pojo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 王阳
 * @create 2020-07-13-12:18
 */
@RestController
@RequestMapping("deviceTypeController")
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceService;
    @Autowired
    DeviceInfoService deviceInfoService;

    /**
     * 生成设备类型树
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deviceTypeTree",method = RequestMethod.GET)
    public List<TreeModel> getDeviceTypeTree() throws Exception {
        List<TreeModel> deviceTypeList = deviceService.deviceTypeTree();
        return deviceTypeList;
    }

    /**
     * 添加设备类型
     * @param deviceType
     * @return
     */
    @RequestMapping(value = "/insertDeviceType",method = RequestMethod.POST)
    public AjaxResult insertDeviceType(@RequestBody DeviceType deviceType) {
        AjaxResult ajaxResult = new AjaxResult();
        /**
         * 截取部分字符串生成int类型的ID
         * 方便遍历父节点
         */
        String id = PlatformTools.getID().substring(1,10);
        deviceType.setId(Integer.parseInt(id));
        try {
            Integer flag=deviceService.insertDeviceType(deviceType);
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
     * 根据ID删除设备类型
     * @param id
     * @return
     */
    @RequestMapping(value = "/delDeviceType",method = RequestMethod.GET)
    public AjaxResult delDeviceType( int id) {
        AjaxResult ajaxResult = new AjaxResult();
        int flag = 0;
        try {
            flag=deviceService.delDeviceType(id);
            deviceService.delDeviceInfos(id);
            ajaxResult.setFlag(true);
            ajaxResult.setMsg("删除成功");
        } catch (Exception e){
            e.printStackTrace();
            ajaxResult.setFlag(false);
            ajaxResult.setMsg("删除失败"+ e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 修改设备类型
     * @param deviceType
     * @return
     */
    @RequestMapping(value = "/updateDeviceType",method = RequestMethod.POST)
    public AjaxResult updateDeviceType(@RequestBody DeviceType deviceType) {
        AjaxResult ajaxResult = new AjaxResult();
        int flag = 0;
        try {
            flag=deviceService.updateDeviceType(deviceType);
            ajaxResult.setFlag(true);
            ajaxResult.setMsg("修改成功");
        } catch (Exception e){
            e.printStackTrace();
            ajaxResult.setFlag(false);
            ajaxResult.setMsg("修改失败"+ e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 查询类型编码是否已存在
     * @param typeCode
     * @return
     */
    @RequestMapping(value = "/testTypeCode",method = RequestMethod.GET)
    public AjaxResult testTypeCode(String typeCode) {
        AjaxResult ajaxResult = new AjaxResult();
        String flag = null;
        try {
            flag=deviceService.testTypeCode(typeCode);
            System.out.println("Controller的flag"+flag);
            ajaxResult.setFlag(true);
            ajaxResult.setMsg(flag);
        } catch (Exception e){
            e.printStackTrace();
            ajaxResult.setFlag(false);
            ajaxResult.setMsg("查询失败"+ e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 拖拽修改节点，如果节点已存在，则提示用户
     * @param deviceType
     * @return
     */
    @GetMapping("/updatedeviceTypeTree")
    public AjaxResult updatedeviceTypeTree(DeviceType deviceType) {
        AjaxResult result = new AjaxResult();
        boolean flag = false;
        try {
            flag = deviceService.selectNodeByName(deviceType);
            if (flag) {
                result.setFlag(false);
                result.setMsg("该资源名称已存在！");
            } else {
                deviceService.updateTypeTree(deviceType);
                result.setFlag(true);
                result.setMsg("修改成功！");
            }
        } catch (Exception e) {
            result.setFlag(false);
            result.setMsg("修改失败1！");
        }
        return result;
    }
}
