package jk;

import java.time.LocalDate;

public class Store {

  private final ToolRepository toolRepository = new ToolRepository();
  private final ChargePolicyRepository chargePolicyRepository = new ChargePolicyRepository();

  public RentalAgreement checkout(final String toolCode,
                                  final LocalDate checkoutDate,
                                  final Integer rentalDays,
                                  final Integer discountPercent) {
    final var tool = toolRepository.lookup(toolCode);
    final var chargePolicy = chargePolicyRepository.lookup(tool.toolType());

    return new RentalAgreement(
            toolCode,
            tool.toolType(),
            tool.brand(),
            rentalDays,
            checkoutDate,
            null,
            chargePolicy.dailyCharge(),
            null,
            null,
            discountPercent,
            null,
            null);
  }

}
