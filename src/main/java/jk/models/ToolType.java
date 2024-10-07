package jk.models;

public enum ToolType {
  CHAINSAW("Chainsaw"),
  LADDER("Ladder"),
  JACKHAMMER("Jackhammer");

  private final String label;

  ToolType(final String label) {
    this.label = label;
  }

  public String label() {
    return label;
  }

}
