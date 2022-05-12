package my.home.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("my.home.spring.aop")
@EnableAspectJAutoProxy
public class MyConfig {
}
