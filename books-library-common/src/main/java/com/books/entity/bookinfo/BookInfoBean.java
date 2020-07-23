package com.books.entity.bookinfo;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.books.entity.booklabel.BookLabelBean;
import com.books.entity.booktype.BookTypeBean;
import com.fasterxml.jackson.annotation.JsonFormat;

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

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    private String isdel;
    
    private String bookCode;
    
    private String contentValidity;
    
    private String editorRecommend;

    @TableField(exist = false)
    private Integer[] typeIds;
    
    @TableField(exist = false)
    private Integer[] labelIds;
    
    @TableField(exist = false)
    private List<BookTypeBean> bookTypeList;
    
    @TableField(exist = false)
    private List<BookLabelBean> bookLabelList;
    
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

	public List<BookTypeBean> getBookTypeList() {
		return bookTypeList;
	}

	public void setBookTypeList(List<BookTypeBean> bookTypeList) {
		this.bookTypeList = bookTypeList;
	}

	public List<BookLabelBean> getBookLabelList() {
		return bookLabelList;
	}

	public void setBookLabelList(List<BookLabelBean> bookLabelList) {
		this.bookLabelList = bookLabelList;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getContentValidity() {
		return contentValidity;
	}

	public void setContentValidity(String contentValidity) {
		this.contentValidity = contentValidity;
	}

	public String getEditorRecommend() {
		return editorRecommend;
	}

	public void setEditorRecommend(String editorRecommend) {
		this.editorRecommend = editorRecommend;
	}

	




	
    
}
