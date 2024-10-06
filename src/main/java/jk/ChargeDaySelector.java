package jk;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.IntStream;

import static jk.DayType.WEEKDAY;
import static jk.DayType.WEEKEND;


public class ChargeDaySelector {
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
      case HOLIDAY -> false;
    };
  }

  private DayType dayType(LocalDate date) {
    if (date.getDayOfWeek().getValue() >= DayOfWeek.SATURDAY.getValue()) {
      return WEEKEND;
    } else {
      return WEEKDAY;
    }
  }
}
