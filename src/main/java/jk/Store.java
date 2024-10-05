package jk;

import java.time.LocalDate;

public class Store {

  private final ToolRepository toolRepository = new ToolRepository();
  private final ChargePolicyRepository chargePolicyRepository = new ChargePolicyRepository();
  private final ChargeCalculator chargeCalculator = new ChargeCalculator();

  public RentalAgreement checkout(final String toolCode,
                                  final LocalDate checkoutDate,
                                  final Integer rentalDays,
                                  final Integer discountPercent) {
    final var tool = toolRepository.lookup(toolCode);
    final var chargePolicy = chargePolicyRepository.lookup(tool.toolType());
    final var chargeSummary = chargeCalculator.chargeSummary(rentalDays, chargePolicy.dailyCharge(), discountPercent);

    return new RentalAgreement(
            toolCode,
            tool.toolType(),
            tool.brand(),
            rentalDays,
            checkoutDate,
            checkoutDate.plusDays(rentalDays - 1),
            chargePolicy.dailyCharge(),
            rentalDays,
            chargeSummary.preDiscountCharge(),
            discountPercent,
            chargeSummary.discountAmount(),
            chargeSummary.finalCharge());
  }

}
