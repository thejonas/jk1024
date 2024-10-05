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
}
