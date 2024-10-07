package jk.day;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static jk.day.DayType.HOLIDAY;
import static org.assertj.core.api.Assertions.assertThat;

class HolidaySelectorTest {

  private final HolidaySelector holidaySelector = new HolidaySelector();

  @Test
  void notAHoliday() {
    assertThat(holidaySelector.selected(LocalDate.of(1989, 12, 13))).isEmpty();
  }

  @Test
  void july4th() {
    assertThat(holidaySelector.selected(LocalDate.of(2024, 7, 4))).hasValue(HOLIDAY);
  }


}
