package jk;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class ChargeCalculator {
  private static final Integer CENTS = 2;

  public ChargeSummary chargeSummary(final Integer rentalDays,
                                     final Double dailyRentalCharge,
                                     final Integer discountPercentage
  ) {
    final var preDiscountCharge = BigDecimal.valueOf(rentalDays * dailyRentalCharge);
    final var discountRate = BigDecimal.valueOf(discountPercentage / 100.0);
    final var rawDiscount = preDiscountCharge.multiply(discountRate);
    final var discount = rawDiscount.setScale(CENTS, HALF_UP);
    final var finalCharge = preDiscountCharge.subtract(discount);


    return new ChargeSummary(preDiscountCharge.doubleValue(),
                             discount.doubleValue(),
                             finalCharge.doubleValue());
  }
}
