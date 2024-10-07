package jk.services;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validator {
  public static void validateParameters(final Integer rentalDays, final Integer discountPercent) {
    final var errors = Stream.concat(
            validateRentalDays(rentalDays),
            validateDiscountPercent(discountPercent)
    ).collect(Collectors.joining("\n"));

    if (!errors.isBlank()) {
      throw new IllegalArgumentException(errors);
    }
  }

  private static Stream<String> validateDiscountPercent(final Integer discountPercent) {
    final var errorTemplate = "Discount percent parameter is %d. Value must be in the range 0-100.";

    return Stream.of(discountPercent)
                 .filter(d -> d < 0 || d > 100)
                 .map(d -> String.format(errorTemplate, d));
  }

  private static Stream<String> validateRentalDays(final Integer rentalDays) {
    final var errorTemplate = "Rental days parameter is %d. Value must be 1 or greater.";

    return Stream.of(rentalDays)
                 .filter(d -> d < 1)
                 .map(d -> String.format(errorTemplate, d));

  }
}
