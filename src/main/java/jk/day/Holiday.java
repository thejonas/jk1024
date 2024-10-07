package jk.day;

import java.time.LocalDate;
import java.util.List;

public class Holiday {
  private static final List<ObservedHoliday> observedHolidays = List.of(new July4th());

  private Holiday() {
  }


  public static Boolean observed(final LocalDate date) {
    return observedHolidays.stream()
                           .map(holiday -> holiday.of(date.getYear()))
                           .anyMatch(holiday -> holiday.equals(date));
  }
}
