package jk;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static jk.ToolType.JACKHAMMER;
import static org.assertj.core.api.Assertions.assertThat;

class RentalAgreementTest {

  public static final RentalAgreement RENTAL_AGREEMENT = new RentalAgreement("JAKR",
                                                                             JACKHAMMER,
                                                                             "DeWalt",
                                                                             4,
                                                                             LocalDate.of(1989, 12, 13),
                                                                             LocalDate.of(2000, 2, 9),
                                                                             1.93,
                                                                             3,
                                                                             34.02,
                                                                             10,
                                                                             0.33,
                                                                             4555.33);

  @Test
  void formatSimpleInputValues() {
    assertThat(RENTAL_AGREEMENT.format())
            .contains("Tool code: JAKR", "Rental days: 4");

  }

  @Test
  void formatDates() {
    assertThat(RENTAL_AGREEMENT.format())
            .contains("Check out date: 12/13/89");
  }

  @Test
  void formatDiscountPercentage() {
    assertThat(RENTAL_AGREEMENT.format())
            .contains("Discount percent: 10%");
  }
}
