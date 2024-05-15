package mk.ukim.finki.emt.employeemanagement.xport.rest;

import mk.ukim.finki.emt.employeemanagement.domain.models.Employee;
import mk.ukim.finki.emt.employeemanagement.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeResource {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}

