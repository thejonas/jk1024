package jk.day;

import java.time.LocalDate;

import static java.time.DayOfWeek.MONDAY;
import static java.time.Month.SEPTEMBER;

public class LaborDay implements ObservedHoliday {

  public static final int DAYS_IN_A_WEEK = 7;

  @Override
  public LocalDate of(final Integer year) {
    final var sept1st = LocalDate.of(year, SEPTEMBER, 1);
    final var daysTilMonday = Math.floorMod(MONDAY.getValue() - sept1st.getDayOfWeek().getValue(), DAYS_IN_A_WEEK);

    return sept1st.plusDays(daysTilMonday);
  }
}
