package jk.day;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class July4thTest {
  private final ObservedHoliday july4th = new July4th();

  @Test
  void july4OnAWeekday() {
    assertThat(july4th.of(2024)).isEqualTo("2024-07-04");
  }

  @Test
  void july4OnASaturday() {
    assertThat(july4th.of(2020)).isEqualTo("2020-07-03");
  }

  @Test
  void july4thOnASunday() {
    assertThat(july4th.of(2021)).isEqualTo("2021-07-05");
  }
}
