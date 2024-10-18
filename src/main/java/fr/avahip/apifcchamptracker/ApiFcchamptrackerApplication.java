package fr.avahip.apifcchamptracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiFcchamptrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiFcchamptrackerApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer myMvcConfigurer() {

        return new WebMvcConfigurer() {

            // CORS ORIGIN
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/swagger-ui/index.html").allowedMethods("GET", "POST", "PUT").allowedOrigins("*");
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("*", "GET", "POST", "PUT", "DELETE", "OPTIONS").allowedHeaders("*")
                ;
            }
        };
    }

}
