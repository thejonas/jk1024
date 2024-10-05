package jk;

import java.time.LocalDate;

public record RentalAgreement(
        String toolCode,
        ToolType toolType,
        String toolBrand,
        Integer rentalDays,
        LocalDate checkoutDate,
        LocalDate dueDate,
        Double dailyRentalCharge,
        Integer chargeDays,
        Double preDiscountCharge,
        Integer discountPercent,
        Double discountAmount,
        Double finalCharge
) {
  public String format() {
    return String.format(
            """
                    Tool code: %s
                    Tool type: %s
                    Tool brand: %s
                    Rental days: %d
                    Daily rental charge: $%,.2f
                    Check out date: %tD
                    Discount percent: %d%%
                    Final charge: $%,.2f
                    """,
            toolCode,
            toolType.label(),
            toolBrand,
            rentalDays,
            dailyRentalCharge,
            checkoutDate,
            discountPercent,
            finalCharge);
  }
}
