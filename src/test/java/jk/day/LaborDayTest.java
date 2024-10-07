package jk.day;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LaborDayTest {

  final LaborDay laborDay = new LaborDay();

  @Test
  void septemberStartsOnAMonday() {
    assertThat(laborDay.of(2025)).isEqualTo("2025-09-01");
  }

  @Test
  void septemberStartsBeforeMonday() {
    assertThat(laborDay.of(2024)).isEqualTo("2024-09-02");
  }

  @Test
  void septemberStartsAfterMonday() {
    assertThat(laborDay.of(2009)).isEqualTo("2009-09-07");
  }
}
