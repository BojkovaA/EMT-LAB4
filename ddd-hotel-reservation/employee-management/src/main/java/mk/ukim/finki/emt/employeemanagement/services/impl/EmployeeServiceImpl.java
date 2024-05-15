package mk.ukim.finki.emt.employeemanagement.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.employeemanagement.domain.exceptions.EmployeeNotFoundException;
import mk.ukim.finki.emt.employeemanagement.domain.models.Employee;
import mk.ukim.finki.emt.employeemanagement.domain.models.EmployeeId;
import mk.ukim.finki.emt.employeemanagement.domain.repository.EmployeeRepository;
import mk.ukim.finki.emt.employeemanagement.services.EmployeeService;
import mk.ukim.finki.emt.employeemanagement.services.form.EmployeeForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findById(EmployeeId id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public Employee createEmployee(EmployeeForm form) {
        Employee employee = Employee.build(form.getFirstName(), form.getLastName(), form.getEmployeeType(), form.getDateOfEmployment(), form.getHotelId());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(EmployeeId id, EmployeeForm form) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employee = Employee.build(form.getFirstName(), form.getLastName(), form.getEmployeeType(), form.getDateOfEmployment(), form.getHotelId());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(EmployeeId id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}