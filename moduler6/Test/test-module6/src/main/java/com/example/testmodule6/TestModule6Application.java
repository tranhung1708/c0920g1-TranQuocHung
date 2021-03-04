package com.example.testmodule6;

import com.example.testmodule6.Repository.CustomerRepository;
import com.example.testmodule6.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestModule6Application{

    public static void main(String[] args) {
        SpringApplication.run(TestModule6Application.class, args);
    }
}
