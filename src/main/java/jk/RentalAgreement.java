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
                    Rental days: %d
                    Check out date: %tD
                    """, toolCode, rentalDays, checkoutDate);
  }
}
