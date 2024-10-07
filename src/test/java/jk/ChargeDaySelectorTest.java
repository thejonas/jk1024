package jk;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static jk.ToolType.JACKHAMMER;
import static jk.ToolType.LADDER;
import static org.assertj.core.api.Assertions.assertThat;

class ChargeDaySelectorTest {

  private static final LocalDate MONDAY = LocalDate.of(2019, 4, 29);

  private final ChargeDaySelector chargeDaySelector = new ChargeDaySelector();

  @Test
  void weekdays() {
    final var weekdays = new ChargePolicy(LADDER,
                                          1.0,
                                          true,
                                          false,
                                          false);

    assertThat(chargeDaySelector.numberOfChargeDays(weekdays, MONDAY, 5)).isEqualTo(5);
  }

  @Test
  void countWeekdaysAndWeekends() {
    final var weekdaysAndWeekends = new ChargePolicy(JACKHAMMER,
                                                     1.0,
                                                     true,
                                                     true,
                                                     false);

    assertThat(chargeDaySelector.numberOfChargeDays(weekdaysAndWeekends, MONDAY, 7)).isEqualTo(7);
  }

  @Test
  void countWeekdaysNotWeekends() {
    final var weekdaysAndWeekends = new ChargePolicy(JACKHAMMER,
                                                     1.0,
                                                     true,
                                                     false,
                                                     false);

    assertThat(chargeDaySelector.numberOfChargeDays(weekdaysAndWeekends, MONDAY, 7)).isEqualTo(5);
  }

  @Test
  void countWeekdaysHolidaysAndWeekdends() {
    final var allDays = new ChargePolicy(JACKHAMMER,
                                         1.0,
                                         true,
                                         true,
                                         true);

    final var july4th = LocalDate.of(2024, 7, 4);

    assertThat(chargeDaySelector.numberOfChargeDays(allDays, july4th, 5)).isEqualTo(5);
  }

  @Test
  void countWeekdaysOnly() {
    final var allDays = new ChargePolicy(JACKHAMMER,
                                         1.0,
                                         true,
                                         false,
                                         false);

    final var july4th = LocalDate.of(2024, 7, 4);

    assertThat(chargeDaySelector.numberOfChargeDays(allDays, july4th, 5)).isEqualTo(2);

  }
}
