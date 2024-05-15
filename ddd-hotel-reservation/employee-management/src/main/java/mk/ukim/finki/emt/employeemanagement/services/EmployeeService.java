package mk.ukim.finki.emt.employeemanagement.services;

import mk.ukim.finki.emt.employeemanagement.domain.models.Employee;
import mk.ukim.finki.emt.employeemanagement.domain.models.EmployeeId;
import mk.ukim.finki.emt.employeemanagement.services.form.EmployeeForm;

import java.util.List;

public interface EmployeeService {

    Employee findById(EmployeeId id);
    Employee createEmployee(EmployeeForm form);
    Employee updateEmployee(EmployeeId id, EmployeeForm form);
    void deleteEmployee(EmployeeId id);
    List<Employee> getAll();
}