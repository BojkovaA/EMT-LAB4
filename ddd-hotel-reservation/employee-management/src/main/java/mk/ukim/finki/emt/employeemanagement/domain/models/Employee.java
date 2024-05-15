package mk.ukim.finki.emt.employeemanagement.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.employeemanagement.domain.valueobjects.HotelId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.dates.DateRange;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@Getter
public class Employee extends AbstractEntity<EmployeeId> {

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    private LocalDate dateOfEmployment;

    @AttributeOverride(name = "id", column = @Column(name = "hotel_id", nullable = false))
    private HotelId hotelId;

    protected Employee() {
        super(EmployeeId.randomId(EmployeeId.class));
    }

    public static Employee build(String firstName, String lastName, EmployeeType employeeType, LocalDate dateOfEmployment, HotelId hotelId) {
        Employee employee = new Employee();
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.employeeType = employeeType;
        employee.dateOfEmployment = dateOfEmployment;
        employee.hotelId = hotelId;
        return employee;
    }
}

