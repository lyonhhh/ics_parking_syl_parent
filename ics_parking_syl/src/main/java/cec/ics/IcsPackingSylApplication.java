package cec.ics;

import cec.rap2.annotation.EnableRap2;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRap2
@EnableSwagger2
@EnableKnife4j
@MapperScan("cec.ics.module.mapper")
public class IcsPackingSylApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcsPackingSylApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")// 允许跨域的访问路径
//                        .allowedOrigins("*")// 允许跨域访问的源
//                        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")// 允许请求方法
//                        .maxAge(172800)// 预检间隔时间
//                        .allowCredentials(true);// 是否允许发送 cookie
//            }
//        };
//    }
}
