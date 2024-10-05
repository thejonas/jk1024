package jk;

import java.time.LocalDate;

public class Store {

  private final ToolRepository toolRepository = new ToolRepository();

  public RentalAgreement checkout(final String toolCode,
                                  final LocalDate checkoutDate,
                                  final Integer rentalDays,
                                  final Integer discountPercent) {
    final var tool = toolRepository.lookup(toolCode);

    return new RentalAgreement(
            toolCode,
            tool.toolType(),
            tool.brand(),
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
