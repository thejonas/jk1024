package jk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class StoreTest {

  private Store store;

  @BeforeEach
  void setup() {
    store = new Store();
  }

  @ParameterizedTest
  @CsvSource(textBlock = """
          CHNS, 2024-10-04, 1, 0
          JAKR, 2020-07-31, 5, 10
          """)
  void copyInputValues(String toolCode, LocalDate checkoutDate, Integer rentalDays, Integer discount) {
    final var rentalAgreement = store.checkout(toolCode, checkoutDate, rentalDays, discount);

    assertThat(rentalAgreement).extracting(RentalAgreement::toolCode,
                                           RentalAgreement::checkoutDate,
                                           RentalAgreement::discountPercent)
                               .containsExactly(toolCode, checkoutDate, discount);
  }

  @ParameterizedTest
  @CsvSource(textBlock = """
          JAKD, JACKHAMMER, DeWalt
          LADW, LADDER, Werner
          """)
  void lookupTool(String toolCode, ToolType toolType, String brand) {
    final var rentalAgreement = store.checkout(toolCode, LocalDate.now(), 5, 0);

    assertThat(rentalAgreement).extracting(RentalAgreement::toolType,
                                           RentalAgreement::toolBrand)
                               .containsExactly(toolType, brand);
  }

  @ParameterizedTest
  @CsvSource(textBlock = """
          JAKR, 2.99
          LADW, 1.99
          """)
  void lookupChargePolicy(String toolCode, Double dailyCharge) {
    final var rentalAgreement = store.checkout(toolCode, LocalDate.now(), 3, 0);

    assertThat(rentalAgreement.dailyRentalCharge()).isEqualTo(dailyCharge);
  }

  @Test
  void computeSimpleCharge() {
    final var onAWednesday = LocalDate.of(2024, 10, 2);
    final var rentalAgreement = store.checkout("LADW", onAWednesday, 2, 0);

    assertThat(rentalAgreement).extracting(RentalAgreement::dueDate,
                                           RentalAgreement::chargeDays,
                                           RentalAgreement::finalCharge)
                               .containsExactly(onAWednesday.plusDays(1), 2, 3.98);
  }
}
