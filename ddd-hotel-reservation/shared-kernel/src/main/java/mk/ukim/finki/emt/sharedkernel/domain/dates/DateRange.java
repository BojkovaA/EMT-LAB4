package mk.ukim.finki.emt.sharedkernel.domain.dates;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import java.time.LocalDate;

@Embeddable
@Getter
public class DateRange implements ValueObject {

    private final LocalDate startDate;
    private final LocalDate endDate;

    protected DateRange() {
        this.startDate = null;
        this.endDate = null;
    }

    public DateRange(@NonNull LocalDate startDate, @NonNull LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static DateRange valueOf(@NonNull LocalDate startDate, @NonNull LocalDate endDate) {
        return new DateRange(startDate, endDate);
    }

    public boolean overlaps(DateRange other) {
        return startDate.isBefore(other.endDate) && endDate.isAfter(other.startDate);
    }

    public long days() {
        return startDate.until(endDate).getDays();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateRange dateRange = (DateRange) o;
        return startDate.equals(dateRange.startDate) && endDate.equals(dateRange.endDate);
    }
}
