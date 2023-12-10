package mk.finki.ukim.wp.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ServletComponentScan
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Lab1BApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab1BApplication.class, args);
	}

}
