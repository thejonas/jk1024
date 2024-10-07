package jk.services;

import jk.day.*;
import jk.models.ChargePolicy;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


public class ChargeDaySelector {
  private static final List<DayTypeSelector> prioritizedDayTypeSelectors = List.of(
          new HolidaySelector(),
          new WeekendSelector(),
          new WeekdaySelector()
  );

  private static boolean chargeableDay(final ChargePolicy chargePolicy, final DayType d) {
    return switch (d) {
      case WEEKEND -> chargePolicy.weekendCharge();
      case WEEKDAY -> chargePolicy.weekdayCharge();
      case HOLIDAY -> chargePolicy.holidayCharge();
    };
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
    return dayType(date)
            .filter(d -> chargeableDay(chargePolicy, d))
            .isPresent();
  }

  private Optional<DayType> dayType(LocalDate date) {
    return prioritizedDayTypeSelectors.stream()
                                      .flatMap(selector -> selector.selected(date).stream())
                                      .findFirst();


  }
}
