package jk.day;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static jk.day.DayType.HOLIDAY;

public class HolidaySelector implements DayTypeSelector {
  private static final List<ObservedHoliday> observedHolidays = List.of(new July4th(), new LaborDay());

  @Override
  public Optional<DayType> selected(final LocalDate date) {
    return observedHolidays.stream()
                           .map(holiday -> holiday.of(date.getYear()))
                           .filter(holiday -> holiday.equals(date))
                           .map(__ -> HOLIDAY)
                           .findFirst();

  }
}
