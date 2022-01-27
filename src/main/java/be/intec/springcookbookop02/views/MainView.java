package be.intec.springcookbookop02.views;

import be.intec.springcookbookop02.repositories.EmployeeRepository;
import be.intec.springcookbookop02.repositories.IEmployeeRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee API", version = "1.0", description = "Employee Api Information"))
public class MainView {
    public static void main(String[] args) {
        SpringApplication.run(MainView.class, args);
    }
    @Bean
    public IEmployeeRepository getEmployeeRepositoryBean(){
        return new EmployeeRepository();
    }
}