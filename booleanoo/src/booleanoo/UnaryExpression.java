package booleanoo;

import java.util.Map;
import java.util.Objects;

public abstract class UnaryExpression implements BooleanExpression {

  private UnaryOperator operator;
  private BooleanExpression operand;

  public UnaryExpression(UnaryOperator operator, BooleanExpression operand) {
    this.operator = operator;
    this.operand = operand;
  }

  @Override
  public Boolean evaluate(Map<String, Boolean> context) throws UnassignedVariableException {
    return this.operator.apply(this.operand.evaluate(context));
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (!this.getClass().equals(other.getClass())) {
      return false;
    }
    UnaryExpression newUnary = (UnaryExpression) other;
    return Objects.equals(this.operator, newUnary.operator)
            && Objects.equals(this.operand, newUnary.operand);
  }

  @Override
  public String toString() {
    return "(" + this.operator + " " + this.operand + ")";
  }

  protected final BooleanExpression getOperand() {
    return this.operand;
  }

  protected final UnaryOperator getOperator() {
    return this.operator;
  }
}
