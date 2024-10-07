package jk.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidatorTest {

  @Test
  void noValidationErrors() {
    assertThatCode(() -> Validator.validateParameters(1, 0))
            .doesNotThrowAnyException();
  }

  @Test
  void invalidRentalDayCount() {
    assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Validator.validateParameters(0, 40))
            .withMessage("Rental days parameter is 0. Value must be 1 or greater.");
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 101})
  void invalidDiscountPercent(Integer discountPercent) {
    assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Validator.validateParameters(1, discountPercent))
            .withMessage("Discount percent parameter is " + discountPercent + ". Value must be in the range 0-100.");
  }

  @Test
  void multipleInvalidParameters() {
    assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Validator.validateParameters(-10, 101))
            .withMessage("""
                                 Rental days parameter is -10. Value must be 1 or greater.
                                 Discount percent parameter is 101. Value must be in the range 0-100.""");
  }
}
