package jk;

import java.time.LocalDate;

import static java.time.Month.JULY;


public class July4th implements ObservedHoliday {
  public LocalDate of(Integer year) {
    final var july4thActual = LocalDate.of(year, JULY, 4);
    final var adjustment = switch (july4thActual.getDayOfWeek()) {
      case SATURDAY -> -1;
      case SUNDAY -> 1;
      default -> 0;
    };

    return july4thActual.plusDays(adjustment);
  }
}
