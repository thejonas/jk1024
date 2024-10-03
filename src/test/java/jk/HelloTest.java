package jk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloTest {

  @Test
  void test() {
    assertThat("hello").isEqualTo("world");
  }
}
