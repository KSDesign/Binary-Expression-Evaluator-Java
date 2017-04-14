package booleanoo;

import static booleanoo.Constants.NOT;

public class Not implements UnaryOperator {

  @Override
  public String toString() {
    return NOT;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (!this.getClass().equals(other.getClass())) {
      return false;
    }
    return false;
  }

  @Override
  public Boolean apply(Boolean operand) {
    return (!operand);
  }
}
