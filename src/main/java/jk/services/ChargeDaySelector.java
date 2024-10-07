package jk.services;

import jk.day.DayType;
import jk.day.Holiday;
import jk.models.ChargePolicy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.IntStream;

import static jk.day.DayType.*;


public class ChargeDaySelector {
  private static boolean weekend(final LocalDate date) {
    return date.getDayOfWeek().getValue() >= DayOfWeek.SATURDAY.getValue();
  }

  public Integer numberOfChargeDays(final ChargePolicy chargePolicy,
                                    final LocalDate checkoutDate,
                                    final Integer rentalDays) {
    final var chargeDays = IntStream.range(0, rentalDays)
                                    .mapToObj(checkoutDate::plusDays)
                                    .filter(date -> includeDate(chargePolicy, date))
                                    .count();

    return Math.toIntExact(chargeDays);
  }

  private boolean includeDate(final ChargePolicy chargePolicy, final LocalDate date) {
    return switch (dayType(date)) {
      case WEEKEND -> chargePolicy.weekendCharge();
      case WEEKDAY -> chargePolicy.weekdayCharge();
      case HOLIDAY -> chargePolicy.holidayCharge();
    };
  }

  private DayType dayType(LocalDate date) {
    if (Holiday.observed(date)) {
      return HOLIDAY;
    } else if (weekend(date)) {
      return WEEKEND;
    } else {
      return WEEKDAY;
    }
  }
}
