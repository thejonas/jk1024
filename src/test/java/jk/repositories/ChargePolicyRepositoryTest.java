package jk.repositories;

import jk.models.ChargePolicy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

import static jk.models.ToolType.*;
import static org.assertj.core.api.Assertions.assertThat;

class ChargePolicyRepositoryTest {

  private static final List<ChargePolicy> chargePolicies = List.of(
          new ChargePolicy(LADDER, 1.99, true, true, false),
          new ChargePolicy(CHAINSAW, 1.49, true, false, true),
          new ChargePolicy(JACKHAMMER, 2.99, true, false, false)
  );

  private final ChargePolicyRepository chargePolicyRepository = new ChargePolicyRepository();

  @ParameterizedTest
  @FieldSource("chargePolicies")
  void lookup(ChargePolicy chargePolicy) {
    assertThat(chargePolicyRepository.lookup(chargePolicy.toolType()))
            .isEqualTo(chargePolicy);
  }

}
