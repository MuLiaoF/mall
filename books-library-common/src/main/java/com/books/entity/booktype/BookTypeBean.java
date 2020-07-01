package com.books.entity.booktype;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName BookTypeBean
 * @Description 图书类型实体类
 */
@TableName("tbl_book_type")
public class BookTypeBean {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;         //ID
    private Integer pid;        //父ID
    private String typeName;    //图书类型名称
    private String isdel;       //是否删除
    private String status;      //状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
