package booleanoo;

import java.util.Map;
import java.util.Objects;

public class Variable implements BooleanExpression {

  private String id;

  public Variable(String id) {
    this.id = id;
  }

  @Override
  public Boolean evaluate(Map<String, Boolean> context)
          throws UnassignedVariableException {
    if (!context.containsKey(this.id)) {
      throw new UnassignedVariableException();
    }

    return context.get(this.id);
  }

  @Override
  public BooleanExpression simplify(Map<String, Boolean> context) {
    if (context.containsKey(this.id)) {
      BooleanExpression var = new BooleanValue(context.get(this.id));
      return var;
    } else {
      return this;
    }
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (!(this.getClass().equals(other.getClass()))) {
      return false;
    }
    Variable newVariable = (Variable) other;
    return Objects.equals(this.id, newVariable.id);

  }

  @Override
  public String toString() {
    return this.id;
  }

}
