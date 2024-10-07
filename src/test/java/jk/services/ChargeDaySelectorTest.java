package jk.services;

import jk.models.ChargePolicy;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static jk.models.ToolType.JACKHAMMER;
import static jk.models.ToolType.LADDER;
import static org.assertj.core.api.Assertions.assertThat;

class ChargeDaySelectorTest {

  private static final LocalDate MONDAY = LocalDate.of(2019, 4, 29);


  @Test
  void weekdays() {
    final var weekdays = new ChargePolicy(LADDER,
                                          1.0,
                                          true,
                                          false,
                                          false);
    final var chargeDaySelector = new ChargeDaySelector(weekdays);

    assertThat(chargeDaySelector.numberOfChargeDays(MONDAY, 5)).isEqualTo(5);
  }

  @Test
  void countWeekdaysAndWeekends() {
    final var weekdaysAndWeekends = new ChargePolicy(JACKHAMMER,
                                                     1.0,
                                                     true,
                                                     true,
                                                     false);

    final var chargeDaySelector = new ChargeDaySelector(weekdaysAndWeekends);

    assertThat(chargeDaySelector.numberOfChargeDays(MONDAY, 7)).isEqualTo(7);
  }

  @Test
  void countWeekdaysNotWeekends() {
    final var weekdaysNotWeekends = new ChargePolicy(JACKHAMMER,
                                                     1.0,
                                                     true,
                                                     false,
                                                     false);

    final var chargeDaySelector = new ChargeDaySelector(weekdaysNotWeekends);

    assertThat(chargeDaySelector.numberOfChargeDays(MONDAY, 7)).isEqualTo(5);
  }

  @Test
  void countWeekdaysHolidaysAndWeekdends() {
    final var allDays = new ChargePolicy(JACKHAMMER,
                                         1.0,
                                         true,
                                         true,
                                         true);

    final var july4th = LocalDate.of(2024, 7, 4);

    final var chargeDaySelector = new ChargeDaySelector(allDays);

    assertThat(chargeDaySelector.numberOfChargeDays(july4th, 5)).isEqualTo(5);
  }

  @Test
  void countWeekdaysOnly() {
    final var allDays = new ChargePolicy(JACKHAMMER,
                                         1.0,
                                         true,
                                         false,
                                         false);

    final var july4th = LocalDate.of(2024, 7, 4);

    final var chargeDaySelector = new ChargeDaySelector(allDays);

    assertThat(chargeDaySelector.numberOfChargeDays(july4th, 5)).isEqualTo(2);

  }
}
