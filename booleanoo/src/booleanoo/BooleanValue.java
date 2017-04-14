package booleanoo;

import java.util.Map;
import java.util.Objects;

public class BooleanValue implements BooleanExpression {

  private Boolean value;

  public BooleanValue(Boolean val) {
    this.value = val;
  }

  @Override
  public Boolean evaluate(Map<String, Boolean> context) {
    return this.value;
  }

  @Override
  public BooleanExpression simplify(Map<String, Boolean> context) {
    return this;
  }

  /***
   * 
   * @param other obj.
   * @return boolean
   */
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (!(this.getClass().equals(other.getClass()))) {
      return false;
    }
    BooleanValue newBoolean = (BooleanValue) other;
    return Objects.equals(this.value, newBoolean.value);
  }

  @Override
  public String toString() {
    return this.value.toString();
  }

}
