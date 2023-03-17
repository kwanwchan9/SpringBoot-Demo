package com.example.demo.employee;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Random;

@Configuration
public class EmployeeConfiguration {

    @Value("${info.app.name}")
    private String appName;

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            System.out.println("EmployeeConfiguration");
            System.out.println(appName);

            Faker faker = new Faker();
            for (int i = 0; i < 20; i++) {
                String name = faker.name().fullName();
                Gender gender = Gender.values()[new Random().nextInt(Gender.values().length)];
                Date dateOfBirth = faker.date().birthday();
                String address = faker.address().fullAddress();
                Employee employee = new Employee(name, gender, dateOfBirth, address);
                employeeRepository.save(employee);
                System.out.println(faker.date().birthday());
            }
        };
    }
}

