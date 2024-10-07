package jk.day;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.time.LocalDate;

import static jk.day.DayType.WEEKEND;
import static org.assertj.core.api.Assertions.assertThat;

class WeekendSelectorTest extends DaySelectorTest {

  private final WeekendSelector weekendSelector = new WeekendSelector();

  @ParameterizedTest
  @FieldSource("weekendDays")
  void weekends(LocalDate day) {
    assertThat(weekendSelector.selected(day)).hasValue(WEEKEND);
  }

  @ParameterizedTest
  @FieldSource("weekdayDays")
  void weekdays(LocalDate day) {
    assertThat(weekendSelector.selected(day)).isEmpty();
  }

}
