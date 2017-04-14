package booleanoo;

import java.util.Map;
import java.util.Objects;

public abstract class BinaryExpression implements BooleanExpression {

  private BinaryOperator operator;
  private BooleanExpression left;
  private BooleanExpression right;

  /***
   * 
   * @param operator operator.
   * @param left left expr
   * @param right right expr
   */
  public BinaryExpression(BinaryOperator operator, BooleanExpression left,
          BooleanExpression right) {
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  @Override
  public Boolean evaluate(Map<String, Boolean> context) throws UnassignedVariableException {
    return this.operator.apply(this.left.evaluate(context),
            this.right.evaluate(context));
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (!this.getClass().equals(other.getClass())) {
      return false;
    }
    BinaryExpression newBinary = (BinaryExpression) other;
    return Objects.equals(this.operator, newBinary.operator)
            && Objects.equals(this.left, newBinary.left)
            && Objects.equals(this.right, newBinary.right);
  }

  @Override
  public String toString() {
    return "(" + this.left + " " + this.operator + " " + this.right + ")";
  }

  protected final BooleanExpression getLeft() {
    return this.left;
  }

  protected final BooleanExpression getRight() {
    return this.right;
  }

  protected final BinaryOperator getOperator() {
    return this.operator;
  }

}
