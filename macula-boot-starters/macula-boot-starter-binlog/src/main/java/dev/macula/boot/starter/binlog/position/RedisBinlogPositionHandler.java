package dev.macula.boot.starter.binlog.position;

import com.alibaba.fastjson.JSON;
import dev.macula.boot.starter.binlog.config.RedisConfig;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisBinlogPositionHandler implements BinlogPositionHandler {
    private JedisPool jedisPool;

    public RedisBinlogPositionHandler(RedisConfig redisConfig) {
        this.jedisPool =
            new JedisPool(new GenericObjectPoolConfig(), redisConfig.getHost(), redisConfig.getPort(), 1000,
                redisConfig.getPassword());
    }

    @Override
    public BinlogPosition loadPosition(Long serverId) {
        try (Jedis jedis = jedisPool.getResource()) {
            String value = jedis.get(serverId.toString());
            if (value != null) {
                return JSON.parseObject(value, BinlogPosition.class);
            }
        }
        return null;
    }

    @Override
    public void savePosition(BinlogPosition position) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(position.getServerId().toString(), JSON.toJSONString(position));
        }
    }
}
