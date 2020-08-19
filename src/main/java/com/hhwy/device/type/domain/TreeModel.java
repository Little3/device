package com.hhwy.device.type.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author 王阳
 * @create 2020-07-13-11:21
 * 树的Bean类
 */
@Component
public class TreeModel {
    private int id;//id
    private String text;//标题内容
    private String state;//状态 closed-合起、open-打开
    private ArrayList<TreeModel> children;//子节点，子节点有0个或多个，所以用链表存放
    private int level_id;//层级 根层级为1
    private int parent_id;  //父节点   根节点为0
    private String typeCode;//类别编码

    @Override
    public String toString() {
        return "TreeModel{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", children=" + children +
                ", level_id=" + level_id +
                ", parent_id=" + parent_id +
                ", typeCode='" + typeCode + '\'' +
                '}';
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<TreeModel> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TreeModel> children) {
        this.children = children;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }
}
