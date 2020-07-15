package com.books.entity.booklabel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName BookLabelBean
 * @Description 图书标签实体类
 */
@TableName("tbl_book_label")
public class BookLabelBean {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;                     //ID
    private String labelName;          //标签名称
    private String isdel;               //是否删除  1删除 0存在

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel_name() {
        return labelName;
    }

    public void setLabel_name(String label_name) {
        this.labelName = label_name;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }
}
