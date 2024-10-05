package jk;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static jk.ToolType.JACKHAMMER;
import static org.assertj.core.api.Assertions.assertThat;

class RentalAgreementTest {

  public static final RentalAgreement RENTAL_AGREEMENT = new RentalAgreement("JAKR",
                                                                             JACKHAMMER,
                                                                             "Ridgid",
                                                                             4,
                                                                             LocalDate.of(1989, 12, 13),
                                                                             LocalDate.of(2000, 2, 9),
                                                                             1.93,
                                                                             3,
                                                                             34.02,
                                                                             10,
                                                                             0.3,
                                                                             4555.33);

  @Test
  void formatSimpleInputValues() {
    assertThat(RENTAL_AGREEMENT.format())
            .contains("Tool code: JAKR",
                      "Tool type: Jackhammer",
                      "Tool brand: Ridgid",
                      "Rental days: 4");

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

  @Test
  void formatCurrencies() {
    assertThat(RENTAL_AGREEMENT.format())
            .contains("Daily rental charge: $1.93\n",
                      "Pre-discount charge: $34.02\n",
                      "Discount amount: $0.30\n",
                      "Final charge: $4,555.33\n");
  }
}
