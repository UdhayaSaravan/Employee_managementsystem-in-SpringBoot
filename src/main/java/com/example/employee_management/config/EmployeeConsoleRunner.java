package com.example.employee_management.config;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class EmployeeConsoleRunner {

    @Bean
    public CommandLineRunner consoleRunner(EmployeeRepository repository) {
        return args -> {

            Scanner scanner = new Scanner(System.in);

            System.out.println("=== Add Employee from Console ===");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Department: ");
            String department = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            Employee employee = new Employee();
            employee.setName(name);
            employee.setEmail(email);
            employee.setDepartment(department);
            employee.setSalary(salary);

            repository.save(employee);

            System.out.println("✅ Employee saved successfully!");
        };
    }
}
