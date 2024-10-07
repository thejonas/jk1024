package jk.day;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

import static jk.day.DayType.WEEKEND;

public class WeekendSelector implements DayTypeSelector {
  @Override
  public Optional<DayType> selected(final LocalDate date) {
    return Optional.of(date)
                   .filter(d -> d.getDayOfWeek().getValue() > DayOfWeek.FRIDAY.getValue())
                   .map(__ -> WEEKEND);

  }
}
