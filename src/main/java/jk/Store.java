package jk;

import java.time.LocalDate;

public class Store {
  public RentalAgreement checkout(final String toolCode,
                                  final LocalDate checkoutDate,
                                  final Integer rentalDays,
                                  final Integer discountPercent) {
    return new RentalAgreement(
            toolCode,
            null,
            null,
            rentalDays,
            checkoutDate,
            null,
            null,
            null,
            null,
            discountPercent,
            null,
            null);
  }

}
