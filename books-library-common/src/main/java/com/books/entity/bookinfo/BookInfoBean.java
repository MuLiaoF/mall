package com.books.entity.bookinfo;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.books.entity.booktype.BookTypeBean;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月29日 下午1:59:41
* @ClassName 类名称 BookInfoBean
* @Description 类描述 图书信息实体类
*/

@TableName("tbl_book_info")
public class BookInfoBean {
	@TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String bookName;

    private String author;

    private String publisher;

    
    private String imgUrlJson;

    private String defaultImgUrl;

    private Date createTime;

    private Date updateTime;

    private String isdel;

    @TableField(exist = false)
    private Integer[] typeIds;
    
    @TableField(exist = false)
    private Integer[] labelIds;
    
    @TableField(exist = false)
    private List<BookTypeBean> bookTypeBean;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getImgUrlJson() {
        return imgUrlJson;
    }

    public void setImgUrlJson(String imgUrlJson) {
        this.imgUrlJson = imgUrlJson == null ? null : imgUrlJson.trim();
    }

    public String getDefaultImgUrl() {
        return defaultImgUrl;
    }

    public void setDefaultImgUrl(String defaultImgUrl) {
        this.defaultImgUrl = defaultImgUrl == null ? null : defaultImgUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

	public Integer[] getTypeIds() {
		return typeIds;
	}

	public void setTypeIds(Integer[] typeIds) {
		this.typeIds = typeIds;
	}

	public Integer[] getLabelIds() {
		return labelIds;
	}

	public void setLabelIds(Integer[] labelIds) {
		this.labelIds = labelIds;
	}

	public List<BookTypeBean> getBookTypeBean() {
		return bookTypeBean;
	}

	public void setBookTypeBean(List<BookTypeBean> bookTypeBean) {
		this.bookTypeBean = bookTypeBean;
	}



	
    
}
