package io.swagger;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.configuration.LocalDateConverter;
import io.swagger.configuration.LocalDateTimeConverter;
import springfox.documentation.oas.annotations.EnableOpenApi;

// @SpringBootApplication
// @EnableOpenApi
// @ComponentScan (basePackages = { "io.swagger", "io.swagger.api" , "io.swagger.configuration"})
// @EnableMongoRepositories (basePackages = { "io.swagger.repository"} )
public class SpringBootMainFile  implements CommandLineRunner  {
   
    public static void main(String[] args) throws Exception {
        System.out.println(LocalDateTime.now());
        //SpringApplication.run(Swagger2SpringBoot.class, args);
    }
    // @Configuration
    // static class CustomDateConfig  implements WebMvcConfigurer   {
    //     @Override
    //     public void addFormatters(FormatterRegistry registry) {
    //         registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
    //         registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
    //     }
    // }
    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            //
            
            return 10;
        }

    }

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

	
}
