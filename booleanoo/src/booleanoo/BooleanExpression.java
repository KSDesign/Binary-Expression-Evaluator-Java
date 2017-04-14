package booleanoo;

import java.util.Map;

public interface BooleanExpression {

  public Boolean evaluate(Map<String, Boolean> context)
          throws UnassignedVariableException;

  public BooleanExpression simplify(Map<String, Boolean> context);

  public boolean equals(Object other);

  public String toString();
}
