package restApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@EnableAutoConfiguration
@ComponentScan
@Configuration
@SpringBootApplication
public class TestMain {
	
	public static void main(String[] args) {  
        SpringApplication.run(TestMain.class, args);  
    } 

}
