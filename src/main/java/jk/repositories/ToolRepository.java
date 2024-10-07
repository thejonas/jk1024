package jk.repositories;

import jk.models.Tool;

import java.util.Map;

import static jk.models.ToolType.*;

public class ToolRepository {
  private static final Map<String, Tool> repository = Map.of(
          "CHNS", new Tool("CHNS", CHAINSAW, "Stihl"),
          "LADW", new Tool("LADW", LADDER, "Werner"),
          "JAKD", new Tool("JAKD", JACKHAMMER, "DeWalt"),
          "JAKR", new Tool("JAKR", JACKHAMMER, "Ridgid")
  );

  public Tool lookup(final String toolCode) {
    return repository.get(toolCode);
  }
}
