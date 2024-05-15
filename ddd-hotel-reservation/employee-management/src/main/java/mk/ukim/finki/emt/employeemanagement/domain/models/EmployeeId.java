package mk.ukim.finki.emt.employeemanagement.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class EmployeeId extends DomainObjectId {

    private EmployeeId() {
        super(EmployeeId.randomId(EmployeeId.class).getId());
    }

    public EmployeeId(@NonNull String uuid) {
        super(uuid);
    }

    public static EmployeeId of(String uuid) {
        return new EmployeeId(uuid);
    }
}
