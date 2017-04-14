package booleanoo;

import static booleanoo.Constants.IFF;

public class Iff implements BinaryOperator {

  @Override
  public String toString() {
    return IFF;
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
    return (!(left ^ right));
  }
}
