package com.redis.SpringDataJedisSentinelSSL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.DefaultJedisClientConfig;

@Configuration
public class RedisConfiguration {
    @Value("${spring.redis.ssl}")
    private Boolean ssl;
    @Value("${spring.redis.sentinel.master}")
    private String master;
    @Value("${spring.redis.sentinel.nodes}")
    private String[] nodes;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        System.out.println(master);
        System.out.println(String.join("-", nodes));

        DefaultJedisClientConfig masterConfig = DefaultJedisClientConfig.builder()
                .user("acljedis").password("fizzbuzz").clientName("master-client").ssl(true)
                .build();

        DefaultJedisClientConfig sentinelConfig = DefaultJedisClientConfig.builder()
                .user("sentinel").password("foobared").clientName("sentinel-client").ssl(false).build();
RedisSentinelConfiguration rsc = new RedisSentinelConfiguration().addSentinel(new RedisNode());
rsc.addSentinel();
rsc.setMaster();
rsc.


        return new JedisConnectionFactory(rsc, masterConfig)
    }

    /*
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(host, port);
        configuration.setPassword(password);
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<?, ?> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }
*/
}
