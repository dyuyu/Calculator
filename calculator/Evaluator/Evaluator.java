/*********************************************************************************************
 * File: [Assignment 01]
 * @author Diana Yu Yu
 * @since [06/16/2018]
 * Description: Evaluator class calculates the operations between the operands and operators.
 ********************************************************************************************/
package Evaluator;

import operators.Operator;
import java.util.*;

public class Evaluator {
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/() ";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }
  

  public int eval( String expression ) {
      String token;

      // The 3rd argument is true to indicate that the delimiters should be used
      // as tokens, too. But, we'll need to remember to filter out spaces.
      this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

      // initialize operator stack - necessary with operator priority schema
      // the priority of any operator in the operator stack other than
      // the usual mathematical operators - "+-*/" - should be less than the priority
      // of the usual operators

      // TODO Operator is abstract - this will need to be fixed:


      while (this.tokenizer.hasMoreTokens()) {
          // filter out spaces
          if (!(token = this.tokenizer.nextToken()).equals(" ")) {
              // check if token is an operand
              //algorithm step a
              if (Operand.check(token)) {
                  operandStack.push(new Operand(token));
              } else { //beginning of else

                  if (!Operator.check(token)) {
                      System.out.println("*****invalid token******");
                      throw new RuntimeException("*****invalid token******");
                  }


                  if (token.equals(")")) { //algorithm step e
                      while (operatorStack.peek().priority() >= 1 ) {
                          Operator oldOpr = operatorStack.pop();
                          Operand op2 = operandStack.pop();
                          Operand op1 = operandStack.pop();
                          operandStack.push(oldOpr.execute(op1, op2));
                      }
                      operatorStack.pop();
                      continue; //goes back to the beginning of the loop

                  }

                  //algorithm step d
                  if (token.equals("(")) {
                      operatorStack.push(Operator.returnOperator("("));
                      continue;
                  }


                  Operator newOperator = Operator.returnOperator(token);
                  //algorithm step b
                  if (operatorStack.isEmpty()) {
                      operatorStack.push(newOperator);
                      continue;
                  }


                  if (!(operatorStack.isEmpty())) {    //probably pointless
                      if (operatorStack.peek().priority() >= newOperator.priority()) {
                          // note that when we eval the expression 1 - 2 we will
                          // push the 1 then the 2 and then do the subtraction operation
                          // This means that the first number to be popped is the
                          // second operand, not the first operand - see the following code
                          Operator oldOpr = operatorStack.pop();
                          Operand op2 = operandStack.pop();
                          Operand op1 = operandStack.pop();
                          operandStack.push(oldOpr.execute(op1, op2));
                      }

                      operatorStack.push(newOperator);

                  } //close if when operatorStack! empty

              } //close else

          } //close first if

      } //close the first while

      //loop that performs the procedure after finding 2 or more operands
      while ((operandStack.size() >= 2) && (operatorStack.peek().priority() >= 1)) {
          Operator oldOpr = operatorStack.pop();
          Operand op2 = operandStack.pop();
          Operand op1 = operandStack.pop();
          operandStack.push(oldOpr.execute(op1, op2));
          }


    //return the result as an operand
    return operandStack.pop().getValue();

} //close the Eval method



}//close the whole class


