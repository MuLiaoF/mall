package com.books.util.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.books.util.enums.ErrorCodesEnum;
import com.books.util.exception.BussinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWTToken {

    public final static String PALTFORM_WX_MINI = "WX_MINI";
    public final static String PALTFORM_WX_MINI_TOURIST = "WX_MINI_TOURIST";

    /**
     * APP登录Token的生成和解析
     * 
     */

    /** token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj */
    public static final String SECRET = "JKKLJOoasdlfj";
    /** token 过期时间: 10天 */
    public static final int DAY = Calendar.DATE;
    public static final int TEN = 10;

    /** token 过期时间: 2小时 */
    public static final int HOUR = Calendar.HOUR;
    public static final int TWO = 2;
    /**
     * JWT生成Token.<br/>
     * 
     * JWT构成: header, payload, signature
     * 
     * @param tokenEntity
     *            登录成功后用户user_id, 参数user_id不可传空
     */
    public static String createToken(TokenEntity tokenEntity, Integer calendarField, Integer calendarInterval) throws Exception {
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        Integer mid = tokenEntity.getMid();
        Integer sid = tokenEntity.getSid();
        Integer userId = tokenEntity.getUserId();
        String userType = tokenEntity.getUserType();
        String paltform = tokenEntity.getPaltform();
        Integer id = tokenEntity.getId();
        // build token
        // param backups {iss:Service, aud:APP}
        String token = JWT.create().withHeader(map) // header
                .withClaim("iss", "Service") // payload
                .withClaim("aud", "APP")
                .withClaim("mid", null == mid ? null : mid)
                .withClaim("sid", null == sid ? null : sid)
                .withClaim("user_id", null == userId ? null : userId)
                .withClaim("user_type", null == userType ? null : userType)
                .withClaim("id", null == id ? null : id)
                .withClaim("paltform", paltform)
                .withIssuedAt(iatDate) // sign time
                .withExpiresAt(expiresDate) // expire time
                .sign(Algorithm.HMAC256(SECRET)); // signature
        return token;
    }

    /**
     * 解密Token
     * 
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            log.info("token 校验失败, 抛出Token验证非法异常");
            throw new BussinessException(ErrorCodesEnum.ERROR_TOKEN_AUTH_ERROR.getErrorCode());
        }
        return jwt.getClaims();
    }

    /**
     * 根据Token获取user_id
     * 
     * @param token
     * @return user_id
     */
    public static TokenEntity getAppUID(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim user_id_claim = claims.get("user_id");
        Claim mid_claim = claims.get("mid");
        Claim sid_claim = claims.get("sid");
        Claim user_type_claim = claims.get("user_type");
        Claim paltform = claims.get("paltform");
        Claim id = claims.get("id");
        TokenEntity tokenEntity = new TokenEntity();
        if (!StringUtils.isNotEmpty(paltform.asString())) {
            // token 校验失败, 抛出Token验证非法异常
            throw new BussinessException(ErrorCodesEnum.ERROR_TYPE_PARAM_PLATFORM.getErrorCode());
        }
        if(!StringUtils.isNotEmpty(user_type_claim.asString())) {
            throw new BussinessException(ErrorCodesEnum.ERROR_TYPE_PARAM_USER.getErrorCode());
        }
        if(PALTFORM_WX_MINI.equals(paltform.asString()) && PALTFORM_WX_MINI_TOURIST.equals(user_type_claim.asString())) {
            tokenEntity.setUserType(user_type_claim.asString());
            tokenEntity.setPaltform(PALTFORM_WX_MINI);
            tokenEntity.setMid(mid_claim.asInt());
            if (null != user_id_claim) {
                tokenEntity.setUserId(user_id_claim.asInt());
            }
            if(null != sid_claim) {
                tokenEntity.setSid(sid_claim.asInt());
            }
        } else {
            if (null == user_id_claim) {
                // token 校验失败, 抛出Token验证非法异常
                throw new BussinessException(ErrorCodesEnum.ERROR_CODE_NOT_HOST.getErrorCode());
            }
            if (null == mid_claim) {
                // token 校验失败, 抛出Token验证非法异常
                throw new BussinessException(ErrorCodesEnum.ERROR_MID_NOT_HOST.getErrorCode());
            }
            tokenEntity.setId(id.asInt());
            tokenEntity.setUserId(user_id_claim.asInt());
            tokenEntity.setMid(mid_claim.asInt());
            if(null != sid_claim) {
                tokenEntity.setSid(sid_claim.asInt());
            }
        }
        tokenEntity.setId(id.asInt());
        return tokenEntity;
    }
}
