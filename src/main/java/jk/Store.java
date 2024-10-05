package jk;

import java.time.LocalDate;

import static jk.ToolType.CHAINSAW;

public class Store {
  public RentalAgreement checkout(final String toolCode,
                                  final LocalDate checkoutDate,
                                  final Integer rentalDays,
                                  final Integer discount) {
    return new RentalAgreement(
            "CHNS",
            CHAINSAW,
            "Stihl",
            1,
            checkoutDate,
            checkoutDate,
            1.49,
            1,
            1.49,
            0,
            0.0,
            1.49);
  }

}
