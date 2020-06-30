package com.books.entity.bookinfo;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月30日 下午10:25:07
* @ClassName 类名称
* @Description 类描述
*/

import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月30日 下午6:36:24
* @ClassName 类名称  图书标签关系表
* @Description 类描述
*/
@TableName("tbl_book_info_label")
public class BookInfoLabelBean {
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	
	private Integer labelId;
	
	private Integer bookInfoId;
	
	private String isdel;
	
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getBookInfoId() {
		return bookInfoId;
	}

	public void setBookInfoId(Integer bookInfoId) {
		this.bookInfoId = bookInfoId;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getLabelId() {
		return labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	
	

}
