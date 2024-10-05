package jk;

public record ChargePolicy(
        ToolType toolType,
        Double dailyCharge,
        Boolean weekdayCharge,
        Boolean weekendCharge,
        Boolean holidayCharge
) {
}
