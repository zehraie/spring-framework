package stereotype_annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "stereotype_annotations") //We haveto specify the package. it needs to go one level up
public class AppConfig {
}
// DIKKAT sadece @ComponentScan dersek sadece config package in altina bakacak