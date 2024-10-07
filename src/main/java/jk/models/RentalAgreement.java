package jk.models;

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
                    Check out date: %tD
                    Daily rental charge: $%,.2f
                    Charge days: %d
                    Pre-discount charge: $%,.2f
                    Discount percent: %d%%
                    Discount amount: $%,.2f
                    Final charge: $%,.2f
                    """,
            toolCode,
            toolType.label(),
            toolBrand,
            rentalDays,
            checkoutDate,
            dailyRentalCharge,
            chargeDays,
            preDiscountCharge,
            discountPercent,
            discountAmount,
            finalCharge);
  }
}
