package com.hhwy.device.type.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author 王阳
 * @create 2020-07-13-9:56
 * DeviceType实体类
 */
@Component
public class DeviceType implements Serializable {
    private int id;
    /**
     * 类别名称
     */
    private String typeName;
    /**
     * 类别编码
     */
    private String typeCode;
    /**
     * 父Id
     */
    private int parentId;

    @Override
    public String toString() {
        return "DeviceType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", parentId=" + parentId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
