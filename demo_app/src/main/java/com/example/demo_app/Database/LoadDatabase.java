package com.example.demo_app.Database;

import com.example.demo_app.Model.Employee;
import com.example.demo_app.Model.Order;
import com.example.demo_app.Model.Status;
import com.example.demo_app.Repo.EmployeeRepository;
import com.example.demo_app.Repo.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Aske K. Jørgensen", "Kontorchef")));
            log.info("Preloading " + employeeRepository.save(new Employee("Vanessa Tyndeskov", "Product Owner")));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));

        };
    }
}

