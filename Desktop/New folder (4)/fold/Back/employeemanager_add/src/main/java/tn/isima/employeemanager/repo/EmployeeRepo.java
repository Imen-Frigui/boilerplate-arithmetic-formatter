package tn.isima.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.isima.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
   

    Optional<Employee> findEmployeeById(Long id);
}
