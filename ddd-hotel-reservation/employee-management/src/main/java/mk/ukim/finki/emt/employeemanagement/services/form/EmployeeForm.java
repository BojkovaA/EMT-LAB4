package mk.ukim.finki.emt.employeemanagement.services.form;

import lombok.Data;
import mk.ukim.finki.emt.employeemanagement.domain.models.EmployeeType;
import mk.ukim.finki.emt.employeemanagement.domain.valueobjects.HotelId;
import mk.ukim.finki.emt.sharedkernel.domain.dates.DateRange;

import java.time.LocalDate;

@Data
public class EmployeeForm {

    private String firstName;
    private String lastName;
    private EmployeeType employeeType;
    private LocalDate dateOfEmployment;
    private HotelId hotelId;
}