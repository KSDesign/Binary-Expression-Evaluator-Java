package booleanoo;

import static booleanoo.Constants.OR;

public class Or implements BinaryOperator {

  @Override
  public String toString() {
    return OR;
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
  public Boolean apply(Boolean left, Boolean right) {
    return (left | right);
  }
}
