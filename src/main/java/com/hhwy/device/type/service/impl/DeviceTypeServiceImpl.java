package com.hhwy.device.type.service.impl;

import com.hhwy.device.type.domain.DeviceType;
import com.hhwy.device.type.domain.TreeModel;
import com.hhwy.device.type.domain.TreeNode;
import com.hhwy.device.type.service.DeviceTypeService;
import com.hhwy.fweb.cached.api.core.CacheClient;
import com.hhwy.fweb.cached.api.core.CacheClientFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王阳
 * @create 2020-07-13-11:39
 */
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public boolean selectNodeByName(DeviceType deviceType) {
        boolean flag = false;
        String result = sqlSessionTemplate.selectOne("deviceType.sql.selectNodeByName",deviceType);
        if (result != null) {
            flag = true;
        }
        return flag;
    }

    @Override
    public int updateTypeTree(DeviceType deviceType) throws Exception{
        int flag;
        flag = sqlSessionTemplate.update("deviceType.sql.updateTypeTree",deviceType);
        return flag;
    }
    /**
     * 生成设备树
     * @return
     */
    @Override
    public List<TreeModel> deviceTypeTree() {
            ArrayList<TreeModel> root = new ArrayList<>();
            List<DeviceType> list = null;
//        CacheClient client = null;
            try {
                 //在缓存查询数据
//                client = CacheClientFactory.getInstance().getResource();
//                list = client.getSerializable("treeNode", List.class);
//                if (list == null || list.size() == 0) {
                    list = sqlSessionTemplate.selectList("deviceType.sql.listDeviceType");
//                    client.setSerializable("treeNode", list);
//                }
                //遍历节点集合，将设备类型转换为树类型
                //后台直接获取对象生成树
                List<TreeModel> tree = new ArrayList<>();
                for (DeviceType deviceType:list) {
                    TreeModel node = new TreeModel();
                    node.setId(deviceType.getId());
                    node.setText(deviceType.getTypeName());
                    node.setParent_id(deviceType.getParentId());
                    node.setTypeCode(deviceType.getTypeCode());
                    tree.add(node);
                }
                root = TreeNode.getTree(tree);
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if(client != null) {
                    client.close();
                }
            }
            return root;
    }

    /**
     * 添加设备类型
     * @param deviceType
     * @return
     */
    @Override
    public int insertDeviceType(DeviceType deviceType) {
//        CacheClient client = null;
        int flag = 0;
        try {
//            client = CacheClientFactory.getInstance().getResource();
//            client.del("treeNode");
            flag = sqlSessionTemplate.insert("deviceType.sql.insertDeviceType",deviceType);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            if(client != null) {
//                client.close();
//            }
//        }
        return flag;
    }

    /**
     * 删除设备类型
     * @param id
     * @return
     */
    @Override
    public int delDeviceType(int id) {
        int flag = 0;
//        CacheClient client = null;
        try {
//            client = CacheClientFactory.getInstance().getResource();
//            client.del("treeNode");
            flag = sqlSessionTemplate.delete("deviceType.sql.delDeviceType",id);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            if(client != null) {
//                client.close();
//            }
//        }
        return flag;
    }

    /**
     * 更新设备类型
     * @param deviceType
     * @return
     */
    @Override
    public int updateDeviceType(DeviceType deviceType) {
        int flag = 0;
//        CacheClient client = null;
        try {
//            client = CacheClientFactory.getInstance().getResource();
//            client.del("treeNode");
            flag = sqlSessionTemplate.update("deviceType.sql.updateDeviceType",deviceType);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            if(client != null) {
//                client.close();
//            }
//        }
        return flag;
    }

    /**
     * 查询编码是否存在
     * @param typeCode
     * @return
     */
    @Override
    public String testTypeCode(String typeCode) {
        String flag= null;
        flag = sqlSessionTemplate.selectOne("deviceType.sql.testTypeCode",typeCode);
        return flag;
    }

    /**
     * 删除节点下边所有设备信息
     * @param id
     * @return
     */
    @Override
    public int delDeviceInfos(int id) {
        int flag = 0;
//        CacheClient client = null;
        try {
//            client = CacheClientFactory.getInstance().getResource();
//            client.del("treeNode");
            flag = sqlSessionTemplate.delete("deviceType.sql.delDeviceInfos",id);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            if(client != null) {
//                client.close();
//            }
//        }
        return flag;
    }
}
