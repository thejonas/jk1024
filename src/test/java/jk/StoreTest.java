package jk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static jk.ToolType.CHAINSAW;
import static org.assertj.core.api.Assertions.assertThat;

class StoreTest {

  private Store store;

  @BeforeEach
  void setup() {
    store = new Store();
  }

  @Test
  void oneDayRentalNoDiscount() {
    final var checkoutDate = LocalDate.of(2024, 10, 4);
    final var rentalAgreement = store.checkout("CHNS", checkoutDate, 1, 0);

    assertThat(rentalAgreement).isEqualTo(new RentalAgreement(
                    "CHNS",
                    CHAINSAW,
                    "Stihl",
                    1,
                    checkoutDate,
                    checkoutDate,
                    1.49,
                    1,
                    1.49,
                    0,
                    0.0,
                    1.49
            )
    );
  }
}
