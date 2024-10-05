package jk;

import java.util.Map;

import static jk.ToolType.*;

public class ChargePolicyRepository {
  private static final Map<ToolType, ChargePolicy> repository = Map.of(
          LADDER, new ChargePolicy(LADDER, 1.99, true, true, false),
          CHAINSAW, new ChargePolicy(CHAINSAW, 1.49, true, false, true),
          JACKHAMMER, new ChargePolicy(JACKHAMMER, 2.99, true, false, false)
  );

  public ChargePolicy lookup(final ToolType toolType) {
    return repository.get(toolType);
  }
}
