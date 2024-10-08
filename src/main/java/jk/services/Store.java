package jk.services;

import jk.models.RentalAgreement;
import jk.repositories.ChargePolicyRepository;
import jk.repositories.ToolRepository;

import java.time.LocalDate;

public class Store {

  private final ToolRepository toolRepository = new ToolRepository();
  private final ChargePolicyRepository chargePolicyRepository = new ChargePolicyRepository();
  private final ChargeCalculator chargeCalculator = new ChargeCalculator();

  public RentalAgreement checkout(final String toolCode,
                                  final LocalDate checkoutDate,
                                  final Integer rentalDays,
                                  final Integer discountPercent) {

    Validator.validateParameters(rentalDays, discountPercent);

    final var tool = toolRepository.lookup(toolCode);
    final var chargePolicy = chargePolicyRepository.lookup(tool.toolType());
    final var chargeDaySelector = new ChargeDaySelector(chargePolicy);
    final var chargeDays = chargeDaySelector.numberOfChargeDays(checkoutDate, rentalDays);
    final var chargeSummary = chargeCalculator.chargeSummary(chargeDays, chargePolicy.dailyCharge(), discountPercent);

    return new RentalAgreement(
            toolCode,
            tool.toolType(),
            tool.brand(),
            rentalDays,
            checkoutDate,
            checkoutDate.plusDays(rentalDays - 1),
            chargePolicy.dailyCharge(),
            chargeDays,
            chargeSummary.preDiscountCharge(),
            discountPercent,
            chargeSummary.discountAmount(),
            chargeSummary.finalCharge());
  }
}
