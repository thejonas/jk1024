package jk;

import jk.models.RentalAgreement;
import jk.services.Store;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static jk.models.ToolType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AcceptanceTest {


  private static final LocalDate JULY_02_2020 = LocalDate.of(2020, 7, 2);
  private static final LocalDate JULY_02_2015 = LocalDate.of(2015, 7, 2);
  private static final LocalDate SEPT_03_2015 = LocalDate.of(2015, 9, 3);

  private final Store store = new Store();

  private static Stream<Arguments> successCases() {
    return Stream.of(
            // Test 2
            arguments("LADW", JULY_02_2020, 3, 10,
                      new RentalAgreement(
                              "LADW",
                              LADDER,
                              "Werner",
                              3,
                              JULY_02_2020,
                              JULY_02_2020.plusDays(2),
                              1.99,
                              2,
                              3.98,
                              10,
                              0.40,
                              3.58)),
            // Test 3
            arguments("CHNS", JULY_02_2015, 5, 25,
                      new RentalAgreement(
                              "CHNS",
                              CHAINSAW,
                              "Stihl",
                              5,
                              JULY_02_2015,
                              JULY_02_2015.plusDays(4),
                              1.49,
                              3,
                              4.47,
                              25,
                              1.12,
                              3.35)),
            // Test 4
            arguments("JAKD", SEPT_03_2015, 6, 0,
                      new RentalAgreement(
                              "JAKD",
                              JACKHAMMER,
                              "DeWalt",
                              6,
                              SEPT_03_2015,
                              SEPT_03_2015.plusDays(5),
                              2.99,
                              3,
                              8.97,
                              0,
                              0.0,
                              8.97)),
            // Test 5
            arguments("JAKR", JULY_02_2015, 9, 0,
                      new RentalAgreement(
                              "JAKR",
                              JACKHAMMER,
                              "Ridgid",
                              9,
                              JULY_02_2015,
                              JULY_02_2015.plusDays(8),
                              2.99,
                              6,
                              17.94,
                              0,
                              0.0,
                              17.94)),
            // Test 6
            arguments("JAKR", JULY_02_2020, 4, 50,
                      new RentalAgreement(
                              "JAKR",
                              JACKHAMMER,
                              "Ridgid",
                              4,
                              JULY_02_2020,
                              JULY_02_2020.plusDays(3),
                              2.99,
                              1,
                              2.99,
                              50,
                              1.50,
                              1.49))
    );
  }

  @ParameterizedTest
  @MethodSource("successCases")
  void successfulRental(final String toolCode,
                        final LocalDate checkoutDate,
                        final Integer rentalDays,
                        final Integer discount,
                        final RentalAgreement rentalAgreement) {
    assertThat(store.checkout(toolCode, checkoutDate, rentalDays, discount)).isEqualTo(rentalAgreement);
  }

  @Test
  void invalidDiscount() {
    assertThatThrownBy(() -> store.checkout("JAKR", SEPT_03_2015, 5, 101))
            .hasMessage("Discount percent parameter is 101. Value must be in the range 0-100.");
  }
}
