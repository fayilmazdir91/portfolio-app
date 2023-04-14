package com.project.portfolioapp.config;

//
//@Configuration
//@EnableRedisHttpSession
//public class RedisConfig {
//
//    @Value("${spring.redis.host}")
//    private String redisHost;
//
//    @Value("${spring.redis.port}")
//    private int redisPort;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private int maxIdle;
//
//    @Value("${spring.redis.jedis.pool.min-idle}")
//    private int minIdle;
//
//    @Bean
//    @Primary
//    public RedisConnectionFactory reactiveRedisConnectionFactory(RedisConfiguration defaultRedisConfig) {
//        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
//                .build();
//        return new LettuceConnectionFactory(defaultRedisConfig, clientConfig);
//    }
//
//    @Bean
//    public RedisConfiguration defaultRedisConfig() {
//        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
//            config.setHostName(redisHost);
//            config.setPort(redisPort);
//            config.setPassword(RedisPassword.of(password));
//        return config;
//    }
//}