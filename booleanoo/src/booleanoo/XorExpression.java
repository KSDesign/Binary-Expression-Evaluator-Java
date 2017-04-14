package booleanoo;

import java.util.Map;

public class XorExpression extends BinaryExpression {

  public XorExpression(BooleanExpression left, BooleanExpression right) {
    super(new Xor(), left, right);
  }

  @Override
  public BooleanExpression simplify(Map<String, Boolean> context) {
    if (getLeft().getClass().equals(BooleanValue.class)
            && getRight().getClass().equals(BooleanValue.class)) {

      BooleanValue left = (BooleanValue) getLeft();
      BooleanValue right = (BooleanValue) getRight();

      if (right.evaluate(context) == left.evaluate(context)) {
        return new BooleanValue(false);
      } else {
        return new BooleanValue(true);
      }
    } else if (!(getLeft().getClass().equals(BooleanValue.class))
            && getRight().getClass().equals(BooleanValue.class)) {

      BooleanExpression left = this.getLeft();
      BooleanValue right = (BooleanValue) getRight();
      //Returns accordingly based on the Boolean value of Right
      if (right.evaluate(context) == Boolean.TRUE) {
        return new Negation(left.simplify(context));
      } else if (right.evaluate(context) == Boolean.FALSE) {
        return left.simplify(context);
      }
    } else if (getLeft().getClass().equals(BooleanValue.class)
            && (!(getRight().getClass().equals(BooleanValue.class)))) {
      BooleanValue left = (BooleanValue) getLeft();
      BooleanExpression right = this.getRight();
      //Returns accordingly based on Boolean value of left
      if (left.evaluate(context) == Boolean.TRUE) {
        return new Negation(right.simplify(context));
      } else if (left.evaluate(context) == Boolean.FALSE) {
        return right.simplify(context);
      }
    } else if (!(getLeft().getClass().equals(BooleanValue.class)
            && (!(getRight().getClass().equals(BooleanValue.class))))) {

      BooleanExpression left = this.getLeft();
      BooleanExpression right = this.getRight();
      //Return either left or right if they're equal
      if ((left.simplify(context)).equals(right.simplify(context))) {
        return left.simplify(context);
      } else {
        return new XorExpression(left.simplify(context), right.simplify(context)).simplify(context);
      }
    }
    return this;
  }
}
