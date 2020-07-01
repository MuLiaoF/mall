package cn.wandingkeji.member.request;

import lombok.Data;

/**
 * 初始化会员信息入参
 * @author xzf
 */
@Data
public class InitMemMiniFansReq {

    private String iv;
    private UserInfoWx userInfo;
    private String encryptedData;
    private String rowData;
    private Integer mid;
    private Integer userId;
    private String signature;


    @Data
    public class UserInfoWx {

        private String avatarUrl;
        private String nickName;
        private Integer gender;
        private String language;
        private String city;
        private String province;
        private String country;
    }

}
