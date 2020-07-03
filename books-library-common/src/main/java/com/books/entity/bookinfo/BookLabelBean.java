package com.books.entity.bookinfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author Zhao yongbing
* @version 创建时间：2020年7月3日 上午11:05:43
* @ClassName 类名称  图书标签实体类
* @Description 类描述
*/
@TableName("tbl_book_label")
public class BookLabelBean {

	@TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String labelName;

    private String isdel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }
}
