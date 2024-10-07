package jk.day;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

import static jk.day.DayType.WEEKDAY;

public class WeekdaySelector implements DayTypeSelector {

  @Override
  public Optional<DayType> selected(final LocalDate date) {
    return Optional.of(date)
                   .filter(d -> d.getDayOfWeek().getValue() < DayOfWeek.SATURDAY.getValue())
                   .map(__ -> WEEKDAY);
  }
}
