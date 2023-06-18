package io.swagger;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.context.WebApplicationContext;
import springfox.documentation.oas.annotations.EnableOpenApi;


@SpringBootApplication
@EnableOpenApi
@ComponentScan (basePackages = { "io.swagger", "io.swagger.api" , "io.swagger.configuration"})
@EnableMongoRepositories (basePackages = { "io.swagger.repository"} )
public class Swagger2SpringBoot  extends SpringBootServletInitializer  {

    @Override
    public WebApplicationContext run(SpringApplication app)  {
        return super.run(app);
        
    } 
  
    public static void main(String[] args) throws Exception {
        
        SpringApplication.run(Swagger2SpringBoot.class, args);
        System.out.println("version: " + SpringVersion.getVersion());
    }
    
    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            //
            
            return 10;
        }

    }


  
}

