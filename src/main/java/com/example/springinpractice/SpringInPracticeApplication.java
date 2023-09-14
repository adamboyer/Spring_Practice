package com.example.springinpractice;

import com.example.springinpractice.configurationproperties.AppProperties;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Set;


@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringInPracticeApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringInPracticeApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringInPracticeApplication.class, args);;

        AppService appService = applicationContext.getBean(AppService.class);
        log.info(appService.getAppProperties().toString());
    }

    @Override
    public void run(String[] args) {
        Course course = new Course();
        course.setId(1);
        course.setRating(0);
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Course>> violations = validator.validate(course);

        violations.forEach(courseConstraintViolation -> {
            log.error("A constraint violation has occurred. Violation details: [{}].", courseConstraintViolation);
        });
    }

}
