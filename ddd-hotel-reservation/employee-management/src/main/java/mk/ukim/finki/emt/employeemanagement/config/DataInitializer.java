package mk.ukim.finki.emt.employeemanagement.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.employeemanagement.domain.models.Employee;
import mk.ukim.finki.emt.employeemanagement.domain.models.EmployeeType;
import mk.ukim.finki.emt.employeemanagement.domain.repository.EmployeeRepository;
import mk.ukim.finki.emt.employeemanagement.domain.valueobjects.HotelId;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final EmployeeRepository employeeRepository;
    @PostConstruct
    public void initData() {

        Employee e1 = Employee.build("Ana", "Andova", EmployeeType.ROOM_SERVICE, LocalDate.parse("2007-02-12"), new HotelId());
        Employee e2 = Employee.build("Mile", "Milov", EmployeeType.ADMINISTRATOR, LocalDate.parse("2008-05-12"), new HotelId());

        if (employeeRepository.findAll().isEmpty()) {
            employeeRepository.saveAll(Arrays.asList(e1,e2));
        }
    }

}
