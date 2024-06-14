package org.redis.flow;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.test.context.TestConfiguration;
import redis.embedded.RedisServer;

import java.io.IOException;

@TestConfiguration
public class EmbeddedRedis {
    private final RedisServer redisServer;

    public EmbeddedRedis() throws IOException {
        // 기본 포트랑 겹치지 않게
        this.redisServer = new RedisServer(63790);
    }

    @PostConstruct
    public void start() throws IOException {
        this.redisServer.start();
    }

    @PreDestroy
    public void stop() throws IOException {
        this.redisServer.stop();
    }
}
