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

  private final ChargePolicy chargePolicy;

  public ChargeDaySelector(final ChargePolicy chargePolicy) {
    this.chargePolicy = chargePolicy;
  }

  private boolean chargeableDay(final DayType dayType) {
    return switch (dayType) {
      case WEEKEND -> chargePolicy.weekendCharge();
      case WEEKDAY -> chargePolicy.weekdayCharge();
      case HOLIDAY -> chargePolicy.holidayCharge();
    };
  }

  public Integer numberOfChargeDays(final LocalDate checkoutDate,
                                    final Integer rentalDays) {
    final var chargeDays = IntStream.range(0, rentalDays)
                                    .mapToObj(checkoutDate::plusDays)
                                    .filter(this::includeDate)
                                    .count();

    return Math.toIntExact(chargeDays);
  }

  private boolean includeDate(final LocalDate date) {
    return dayType(date)
            .filter(this::chargeableDay)
            .isPresent();
  }

  private Optional<DayType> dayType(LocalDate date) {
    return prioritizedDayTypeSelectors.stream()
                                      .flatMap(selector -> selector.selected(date).stream())
                                      .findFirst();


  }
}
