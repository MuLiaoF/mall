package com.books.token.job;

import com.books.entity.token.AccessToken;
import com.books.token.consts.AccessTokenTypeEnum;
import com.books.token.service.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AccessTokenTask {

    private final long UPDATE_ACCESS_TOKEN_SECOND = 20 * 60 * 1000;

    private final long UPDATE_TYPE_FIVE_ACCESS_TOKEN_SECOND = UPDATE_ACCESS_TOKEN_SECOND + 10 * 60 * 1000;

    @Autowired
    private AccessTokenService accessTokenService;

    @Scheduled(fixedDelay = 1000 * 60 * 3)
    public void initiativeUpdateAccessToken() {
        long currentTimeMillis = System.currentTimeMillis();
        long intervalTime = (currentTimeMillis - UPDATE_ACCESS_TOKEN_SECOND) / 1000;
        List<AccessToken> accessTokenCaches =
                accessTokenService.selectWithExpiresTime(intervalTime);
        log.info("===自动更新AccessToken轮训任务开始===,过期时间:{}", intervalTime);
        for (AccessToken accessTokenCache : accessTokenCaches) {
            log.info("更新过期的AccessToken:{}", accessTokenCache);
           // GlobalAccessTokenHelper.updateAccessTokenToCacheAndDB(accessTokenCache, false);
        }
        log.info("===自动更新AccessToken轮训任务结束===,过期时间:{}", intervalTime);
    }

    @Scheduled(fixedDelay = 1000 * 60 * 5)
    public void initiativeUpdateAccessTokenByType() {
        long currentTimeMillis = System.currentTimeMillis();
        long intervalTime = (currentTimeMillis - UPDATE_TYPE_FIVE_ACCESS_TOKEN_SECOND) / 1000;
        List<AccessToken> accessTokenCaches =
                accessTokenService.selectWithExpiresTime(intervalTime);
        log.info("===自动更新AccessToken轮训任务开始，类型{}===,过期时间:{}", AccessTokenTypeEnum.FIVE.getValue(), intervalTime);
        accessTokenCaches.forEach(e -> {
            if (AccessTokenTypeEnum.FIVE.getValue() == e.getType()) {
                log.info("更新类型为{}过期的AccessToken:{}", AccessTokenTypeEnum.FIVE.getValue(), e);
                //GlobalAccessTokenHelper.updateAccessTokenToCacheAndDB(e, false);
            }
        });
        log.info("===自动更新类型为{}的AccessToken轮训任务结束===类型{},过期时间:{}", AccessTokenTypeEnum.FIVE.getValue(),
                intervalTime);
    }

}
