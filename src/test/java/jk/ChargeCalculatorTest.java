package jk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ChargeCalculatorTest {


  private static Stream<Arguments> charges() {
    return Stream.of(
            arguments(5, 10.0, 0, new ChargeSummary(50.0, 0.0, 50.0)),
            arguments(7, 1.99, 15, new ChargeSummary(13.93, 2.09, 11.84)),
            arguments(193, 23.01, 43, new ChargeSummary(4440.93, 1909.60, 2531.33))
    );
  }

  @ParameterizedTest
  @MethodSource("charges")
  void calculate(Integer rentalDays, Double dailyRentalCharge, Integer discount, ChargeSummary chargeSummary) {
    final var calculator = new ChargeCalculator();

    assertThat(calculator.chargeSummary(rentalDays, dailyRentalCharge, discount))
            .isEqualTo(chargeSummary);
  }
}
