package cn.wandingkeji.member.entity;

import cn.wandingkeji.comm.bean.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 会员信息对象 mem_member_info
 * 
 * @author zye
 * @date 2020-06-08
 */
@Data
public class MemMemberInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Integer id;

    /**
     * 归属商户
     */
    private Integer mid;

    /** 万鼎唯一会员卡号 */
    private String wdMemCardCode;

    /**
     * 会员号（领取会员卡后分配的会员编号）
     */
    private String memCode;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 微信昵称
     */
    private String wxName;

    /**
     * 微信头像
     */
    private String wxPic;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 住址
     */
    private String address;

    /**
     * 生日
     */
    private Date birth;

    /**
     * 行业方向
     */
    private Integer industry;

    /**
     * 出生年
     */
    // @Excel(name = "出生年")
    private Integer year;

    /**
     * 出生月
     */
    // @Excel(name = "出生月")
    private Integer month;

    /**
     * 出生日
     */
    // @Excel(name = "出生日")
    private Integer day;

    /**
     * 薪水
     */
    // @Excel(name = "薪水")
    private Integer salary;

    /**
     * 教育
     */
    // @Excel(name = "教育")
    private Integer education;

    /**
     * 卡类型
     */
    private String wdCardId;

    /**
     * 学校名称
     */
    // @Excel(name = "学校名称")
    private String gradeName;

    /**
     * 个人签名
     */
    // @Excel(name = "个人签名")
    private String msg;

    /**
     * 会员小程序openID
     */
    // @Excel(name = "会员小程序openID")
    private String openId;

    /**
     * 门店id
     */
    // @Excel(name = "门店id")
    private Integer sid;

    /**
     * 门店名称
     */
    // @Excel(name = "门店名称")
    private String storeName;

    /**
     * 省
     */
    // @Excel(name = "省")
    private Integer provinceCode;

    /**
     * 市
     */
    // @Excel(name = "市")
    private Integer cityCode;

    /**
     * $column.columnComment
     */
    // @Excel(name = "市")
    private String city;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 性别  1 男 2女
     */
    private String sex;

    /**
     *已激活 0未激活  1已激活
     * */
    private Integer hasActive;

    /**
     * 会员等级
     */
    private String level;

    /**
     * 等级名称
     */
    private String levelName;

    /**
     * 锁定状态
     */
    private String locStatus;

    /**
     * 人脸信息id
     */
    private Integer personId;

    /**
     * 小程序
     */

    private String miniAppid;

    /**
     * 小程序
     */

    private String miniOpenid;

    /**
     * （0 未删除 1 删除）
     */
    private String isDel;

    /**
     * 工资总额
     */
    // @Excel(name = "工资总额")
    private String unionid;

    /**
     * 标签
     */
    // @Excel(name = "标签")
    private String tags;

    /**
     * 中，青，老年人
     */
    // @Excel(name = "中，青，老年人")
    private Integer type;

    /**
     * 权限组用户ID
     */
    private Integer authUserId;

}
