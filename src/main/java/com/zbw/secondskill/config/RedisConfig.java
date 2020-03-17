package com.zbw.secondskill.config;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Component;

/**
 * @ClassName RedisConfig.java
 * @Description Redis配置类
 * @Author ZBW
 * @Date 2020年03月17日 08:26
 **/
@Component
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class RedisConfig {


}
