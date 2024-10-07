package jk.repositories;

import jk.models.Tool;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static jk.models.ToolType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ToolRepositoryTest {

  private final ToolRepository toolRepository = new ToolRepository();

  private static Stream<Arguments> tools() {
    return Stream.of(
            arguments(new Tool("CHNS", CHAINSAW, "Stihl")),
            arguments(new Tool("LADW", LADDER, "Werner")),
            arguments(new Tool("JAKD", JACKHAMMER, "DeWalt")),
            arguments(new Tool("JAKR", JACKHAMMER, "Ridgid"))
    );
  }

  @ParameterizedTest
  @MethodSource("tools")
  void lookupTools(Tool tool) {
    assertThat(toolRepository.lookup(tool.toolCode())).isEqualTo(tool);
  }
}
