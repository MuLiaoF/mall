package com.books.entity.goodsInfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.books.entity.bookinfo.BookInfoBean;
import com.fasterxml.jackson.annotation.JsonFormat;

@TableName("tbl_goods_info")
public class GoodsInfoBean implements Serializable{
    /**
	 * 序列化
	 */
	private static final long serialVersionUID = -4091122098811190372L;

	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;

    private Integer bookInfoId;

    private BigDecimal benefitPrice;

    private Integer discount;

    private BigDecimal oldPrice;

    private String benefitType;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date putDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date offDate;

    private Integer sort;

    private String isdel;
    
    private String isOff;

    @TableField(exist = false)
    private BookInfoBean bookInfoBean;
    
    @TableField(exist = false)
    private Integer stockNumber;
    
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

    public BigDecimal getBenefitPrice() {
        return benefitPrice;
    }

    public void setBenefitPrice(BigDecimal benefitPrice) {
        this.benefitPrice = benefitPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType == null ? null : benefitType.trim();
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    public Date getOffDate() {
        return offDate;
    }

    public void setOffDate(Date offDate) {
        this.offDate = offDate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

	public String getIsOff() {
		return isOff;
	}

	public void setIsOff(String isOff) {
		this.isOff = isOff;
	}

	public BookInfoBean getBookInfoBean() {
		return bookInfoBean;
	}

	public void setBookInfoBean(BookInfoBean bookInfoBean) {
		this.bookInfoBean = bookInfoBean;
	}

	public Integer getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
    
    
}