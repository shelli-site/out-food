package lmj.outfood;

/*import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lmj.outfood.annotation.AnonymousAccess;
import lmj.outfood.utils.SpringContextHolder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;*/

/**
 * @author Zheng Jie
 * @date 2018/11/15 9:20:19
 */
/*@EnableAsync
@RestController
@SpringBootApplication//(exclude = DruidDataSourceAutoConfigure.class)
@EnableScheduling
@EnableTransactionManagement
@MapperScan(basePackages = {"mb.te.mapper"})
@ComponentScan(basePackages = {"lmj.outfood", "mb.te"})*/
public class AppRun {
/*
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    @Bean
    public ServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory fa = new TomcatServletWebServerFactory();
        fa.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "[]{}"));
        return fa;
    }

    *//**
     * 访问首页提示
     *
     * @return /
     *//*
    @GetMapping("/")
    @AnonymousAccess
    public String index() {
        return "Backend service started successfully";
    }*/
}
