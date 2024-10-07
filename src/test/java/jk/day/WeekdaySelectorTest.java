package jk.day;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.time.LocalDate;

import static jk.day.DayType.WEEKDAY;
import static org.assertj.core.api.Assertions.assertThat;

class WeekdaySelectorTest extends DaySelectorTest {

  private final WeekdaySelector weekdaySelector = new WeekdaySelector();

  @ParameterizedTest
  @FieldSource("weekdayDays")
  void weekdays(LocalDate date) {
    assertThat(weekdaySelector.selected(date)).hasValue(WEEKDAY);
  }

  @ParameterizedTest
  @FieldSource("weekendDays")
  void weekends(LocalDate date) {
    assertThat(weekdaySelector.selected(date)).isEmpty();
  }


}
