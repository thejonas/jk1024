package jk;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class HolidayTest {

  @Test
  void notAHoliday() {
    assertThat(Holiday.observed(LocalDate.of(1989, 12, 13))).isFalse();
  }

  @Test
  void july4th() {
    assertThat(Holiday.observed(LocalDate.of(2024, 7, 4))).isTrue();
  }


}
