package mk.ukim.finki.emt.employeemanagement.domain.repository;

import mk.ukim.finki.emt.employeemanagement.domain.models.Employee;
import mk.ukim.finki.emt.employeemanagement.domain.models.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {
}