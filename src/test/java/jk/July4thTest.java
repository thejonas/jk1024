package jk;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class July4thTest {
  private final ObservedHoliday july4th = new July4th();

  @Test
  void july4OnAWeekday() {
    assertThat(july4th.of(2024)).isEqualTo(LocalDate.of(2024, 7, 4));
  }

  @Test
  void july4OnASaturday() {
    assertThat(july4th.of(2020)).isEqualTo(LocalDate.of(2020, 7, 3));
  }

  @Test
  void july4thOnASunday() {
    assertThat(july4th.of(2021)).isEqualTo(LocalDate.of(2021, 7, 5));
  }
}
