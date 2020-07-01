package com.books.member.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.books.entity.member.MemMemberInfo;
import com.books.entity.member.SysAuthUser;
import com.books.entity.token.SysAccessToken;
import com.books.mapper.AuthUserMapper;
import com.books.member.controller.AuthUserController;
import com.books.member.mapper.AuthUserMapper;
import com.books.member.service.IAuthUserService;
import com.books.request.member.InitMemMiniFansReq;
import com.books.request.member.MemMiniFansReq;
import com.books.response.member.AuthUserRes;
import com.books.response.member.MemAndFansRsp;
import com.books.util.enums.ErrorCodesEnum;
import com.books.util.exception.BussinessException;
import com.books.util.token.TokenEntity;
import com.books.util.wx.AesException;
import com.books.util.wx.WXMiniBizMsgCrypt;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @author feng
 * @version 1.0
 * @date 2020/7/1 11:57
 */
@Service
public class AuthUserServiceImpl implements IAuthUserService {

    private static final Logger log = LogManager.getLogger(AuthUserServiceImpl.class);

    @Autowired
    private AuthUserMapper authUserMapper;

    @Autowired
    private MemMemberInfoMapper memMemberInfoMapper;

    /**
     * wx.login 调用获取用户信息
     * @param memMiniFansReq
     * @return
     * @throws Exception
     */
    @Override
    public AuthUserRes initMiniFans(MemMiniFansReq memMiniFansReq) throws Exception {

        String appid = memMiniFansReq.getAppid();
        String code = memMiniFansReq.getCode();

        TokenRes tokenRes = new TokenRes();
        tokenRes.setTokenUrl(tokenUrl);
        tokenRes.setTokenType(5);
        SysAccessToken sysAccessToken = systemBaseApi.getMidByAppId(appid);
        if(sysAccessToken == null && null == sysAccessToken.getThirdmid()) {
            throw new BussinessException(500 ,"APPID不存在");
        }
        String appSecret = sysAccessToken.getAppSecret();
        //获取Token值
        //SysAccessToken miniSmallToken = getTokenUtilApi.getMiniSmallToken(tokenRes);
        String accessToken = "34_svM88UA6uLgDTFRiLesbCzDqVzOoDp95mTsqhtggQWC6opufjEESjfQ7_dvkfnY__CmVH1mSXZ1YAXiskA2w4cyxooxNmYTjh33-nibVMMFS76oed7IEpC61pQQIfGntPHhfndv0Knpbs2CjIYMjAFANDR";
        String reqUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid;
        reqUrl += "&secret=" + appSecret;
        reqUrl += "&js_code=" + code + "&grant_type=authorization_code";
        //reqUrl += "&component_appid=" + openAppid + "&component_access_token=" + accessToken;
        log.info("returnRes-------->>>>>" + reqUrl);

        String returnRes = HttpUtil.sendGET(reqUrl);
        log.info("code-------->>>>>" + code);
        log.info("returnRes-------->>>>>" + returnRes);
        return wxToken(returnRes, appid, sysAccessToken);
    }

    @Override
    public SysAuthUser modifyAuthUser(InitMemMiniFansReq memMiniFans) throws Exception {

        SysAuthUser sysAuthUser = new SysAuthUser();
        sysAuthUser.setUserId(memMiniFans.getUserId());
        SysAuthUser authUserSel = authUserMapper.selectOne(Wrappers.query(sysAuthUser));
        if(authUserSel == null) {
            throw new BussinessException(ErrorCodesEnum.MERBER_FANS_NULL_ERROR.getErrorCode());
        }
        log.info("---------------> 解密参数" + memMiniFans);
        SysAuthUser authUser = modifyAuthUserAndGetToken(authUserSel.getReserve1(),
                authUserSel.getAppid(),
                memMiniFans.getUserInfo(),
                memMiniFans.getEncryptedData(),
                memMiniFans.getIv(),
                authUserSel.getId());
        authUserMapper.updateAuthUserSessionKey(memMiniFans);
        return authUser;
    }

    private SysAuthUser modifyAuthUserAndGetToken(String sessionKey, String appid, InitMemMiniFansReq.UserInfoWx userInfo, String encryptedData, String iv, Integer id) throws AesException, UnsupportedEncodingException, AesException {
        WXMiniBizMsgCrypt wxMiniBizMsgCrypt = new WXMiniBizMsgCrypt(sessionKey, appid);
        String decryptDataStr = wxMiniBizMsgCrypt.decrypt(encryptedData, iv);

        SysAuthUser authUser = new SysAuthUser();
        JSONObject decryptData = JSONObject.parseObject(decryptDataStr);

        //解密微信返回参数
        String avatarUrl = userInfo.getAvatarUrl();
        String nickName = userInfo.getNickName();
        int gender = userInfo.getGender();
        String city = userInfo.getCity();
        String province = userInfo.getProvince();
        String country = userInfo.getCountry();
        String language = userInfo.getLanguage();

        authUser.setNickName(URLEncoder.encode(nickName, "UTF-8"));
        authUser.setGender(String.valueOf(gender));
        authUser.setCity(city);
        authUser.setProvince(province);
        authUser.setCountry(country);
        authUser.setLanguage(language);
        authUser.setUpdateTime(new Date());
        //添加字段 存储url微信头像地址
        authUser.setAvatarUrl(avatarUrl);
        String unionId = decryptData.getString("unionId");
        authUser.setUnionid(unionId);
        authUser.setSessionKey(sessionKey);
        authUser.setId(id);
        return authUser;
    }


    /**
     * 第一次获取微信用户信息
     * @param returnRes 微信参数
     * @param appid 小程序APPID
     * @return
     * @throws Exception
     */
    private AuthUserRes wxToken(String returnRes, String appid, SysAccessToken sysAccessToken) throws Exception {
        if(returnRes == null || "".equals(returnRes)) {
            return null;
        }
        AuthUserRes authUserRes = createMiniFans(returnRes, appid, sysAccessToken);
        return authUserRes;
    }


    /**
     * 创建粉丝
     * @param returnRes 微信返回结果集
     * @param appid 小程序APPID
     * @return 返回结果集对象
     * @throws Exception
     */
    private AuthUserRes createMiniFans(String returnRes, String appid, SysAccessToken sysAccessToken) throws Exception {
        AuthUserRes memMiniFansRes = new AuthUserRes();
        Boolean flagUnionid = false;
        log.info("---->returnRes " + returnRes + "appid" + appid + "token对象" + sysAccessToken);
        //解析WX参数
        SysAuthUser authUser = checkWxParam(returnRes, flagUnionid , appid, sysAccessToken);

        log.info("---->是否存在Unionid" + flagUnionid);

        MemAndFansRsp memAndFansRsp = addUser(authUser);

        Boolean fansFlag = memAndFansRsp.getFansFlag();
        Boolean memFlag = memAndFansRsp.getMemFlag();
        //如果是会员
        Integer userId = null;
        if(memFlag) {
            MemMemberInfo memMemberInfo = memAndFansRsp.getMemMemberInfo();
            userId = memMemberInfo.getId();
            //如果是粉丝
        }
        Integer id = memAndFansRsp.getAuthUser().getId();
        //AuthUser authUser = new AuthUser();

        String token = creatWxToken(memAndFansRsp.getAuthUser().getMid(), id, userId);
        memMiniFansRes.setToken(token);
        memMiniFansRes.setUnionIdFlag(flagUnionid);
        return memMiniFansRes;
    }

    /**
     * 解析微信返回的参数
     * @param returnRes 微信参数
     * @param flagUnionid 是否存在flagUnionid
     * @param appid 小程序APPID
     * @param sysAccessToken 微信Token值
     * @return
     */
    private SysAuthUser checkWxParam(String returnRes, Boolean flagUnionid, String appid, SysAccessToken sysAccessToken) {
        //解析微信返回的参数
        String openId = null;
        String sessionKey = null;
        String unionid = null;
        JSONObject jsonObject = JSONObject.parseObject(returnRes);
        if (jsonObject.getString("openid") != null) {
            openId = jsonObject.getString("openid");
        }
        if (jsonObject.getString("session_key") != null) {
            sessionKey = jsonObject.getString("session_key");
        }
        if (jsonObject.getString("unionid") != null) {
            unionid = jsonObject.getString("unionid");
            flagUnionid = true;
        }
        openId = "oHsPI5T_ghi1Zin3fZtnlb_SV_80";
        unionid = "oeKYv0ps829gVBLQjzAWj4U_Wtsg";
        SysAuthUser authUser = new SysAuthUser();
        authUser.setUnionid(unionid);
        authUser.setOpenid(openId);
        authUser.setAppid(appid);
        authUser.setReserve1(sessionKey);
        authUser.setMid(Integer.valueOf(sysAccessToken.getThirdmid()));
        return authUser;
    }

    /**
     * 创建Token
     * @param mid 商户ID
     * @param userId 用户USERID
     * @return Token字符串
     * @throws Exception
     */
    private String creatWxToken(Integer mid, Integer id, Integer userId) throws Exception {
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setMid(mid);
        tokenEntity.setUserType(JWTToken.PALTFORM_WX_MINI_TOURIST);
        tokenEntity.setPaltform(JWTToken.PALTFORM_WX_MINI);
        tokenEntity.setUserId(userId);
        tokenEntity.setId(id);
        return JWTToken.createToken(tokenEntity, JWTToken.TWO, JWTToken.HOUR);
    }


    /**
     * 首先去查询会员，如果会员存在，则直接返回会员信息，并标志这是个会员
     * 如果查询到了会员，获取是否有账号ID，如果没有返回标识没有
     * 如果会员不存在，这去查询粉丝表，如果粉丝表中查询到了，则返回标志这是个粉丝
     * 并判断是否更新微信返回的sessionKey用户信息解密
     * 如果都不存在，则创建粉丝表，标明这是第一次创建
     * @param authUser 用户信息
     * @return
     */
    @Transactional()
    public MemAndFansRsp addUser(SysAuthUser authUser) throws Exception {
        SysAuthUser selAuthUser = new SysAuthUser();
        selAuthUser.setAppid(authUser.getAppid());
        selAuthUser.setOpenid(authUser.getOpenid());
        selAuthUser.setUnionid(authUser.getUnionid());
        selAuthUser.setMid(authUser.getMid());
        //返回结果
        MemAndFansRsp memAndFansRsp = new MemAndFansRsp();
        log.info("-----粉丝信息-----base--" + selAuthUser);
        //设置不是会员
        memAndFansRsp.setFansFlag(false);
        //设置不是粉丝
        memAndFansRsp.setMemFlag(false);

        checkMem(memAndFansRsp, selAuthUser);

        SysAuthUser memMiniFans = checkMemFans(selAuthUser);
        memAndFansRsp.setFansFlag(true);
        memAndFansRsp.setAuthUser(memMiniFans);
        log.info("--------> 返回结果集" + memAndFansRsp);
        return memAndFansRsp;
    }

    /**
     * 校验是否是会员
     * @param memAndFansRsp 会员与粉丝信息包装类
     * @param authUser 粉丝信息
     */
    private MemMemberInfo checkMem(MemAndFansRsp memAndFansRsp, SysAuthUser authUser) throws Exception {
        //如果其中有一项为空则不存在
        if(authUser == null || authUser.getAppid() == null || authUser.getOpenid() == null
                || authUser.getUnionid() == null || authUser.getMid() == null) {
            return null;
        }
        SysAuthUser authSel = authUserMapper.selectOne(authUser);
        log.info("查询用户---->   ----" + authSel);
        if(authSel != null && authSel.getUserId() != null) {

            MemMemberInfo  memMemberInfo = memberInfoMapper.getMemberInfoById(authSel.getUserId());

            log.info("查询----会员信息------>" + memMemberInfo);
            if(memMemberInfo != null) {
                memAndFansRsp.setMemFlag(true);
                memAndFansRsp.setMemMemberInfo(memMemberInfo);
                return memMemberInfo;
            }
        }
        return null;
    }

    /**
     * 校验是否是粉丝
     * @param authUser 粉丝信息
     */
    private SysAuthUser checkMemFans(SysAuthUser authUser) throws Exception {
        SysAuthUser authUserSel = authUserMapper.selectOne(authUser);
        //如果粉丝信息表中存在该粉丝
        if(authUserSel != null) {
            String sessionKey = authUser.getReserve1();
            //获取sessionKey,比较是否相同，相同返回，不相同修改sessionKey
            if(sessionKey != null) {
                log.info("-----粉丝信息-----base--更新SessionKey" + authUser);
                authUserSel.setReserve1(sessionKey);
                authUserMapper.updateUser(authUserSel);
            }
            return authUserSel;
        }
        log.info("-----粉丝信息-----base--插入" + authUser);
        //如果粉丝信息查询不到则插入
        authUser.setCreateTime(new Date());
        int insert = authUserMapper.insertUser(authUser);
        authUser.setId(insert);
        return authUser;
    }
}
