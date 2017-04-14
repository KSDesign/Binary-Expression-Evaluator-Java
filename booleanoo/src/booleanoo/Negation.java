package booleanoo;

import java.util.Map;

public class Negation extends UnaryExpression {

  public Negation(BooleanExpression op) {
    super(new Not(), op);
  }

  @Override
  public BooleanExpression simplify(Map<String, Boolean> context) {
    if (getOperand().getClass().equals(BooleanValue.class)) {
      BooleanValue operand = (BooleanValue) getOperand();

      if (operand.evaluate(context) == Boolean.TRUE) {
        return new BooleanValue(false);
      } else {
        return new BooleanValue(true);
      }
    } else if (!getOperand().getClass().equals(BooleanValue.class)) {
      BooleanExpression operand = this.getOperand();
      
      if (operand.simplify(context).getClass().equals(BooleanValue.class)) {
          BooleanValue simplifiedOp = (BooleanValue) (operand.simplify(context));
          if (simplifiedOp.evaluate(context) == Boolean.TRUE) {
            return new BooleanValue(false);
          } else {
            return new BooleanValue(true);
          }
        } else {
        return new Negation(operand.simplify(context));
      } 
    }
    return this;
  }
}
