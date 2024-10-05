package jk;

import org.junit.jupiter.api.BeforeEach;
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
}
