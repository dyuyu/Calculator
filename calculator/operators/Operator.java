/*****************************************************************************
 * File: [Assignment 01]
 * @author Diana Yu Yu
 * @since [06/16/2018]
 * Description: Operator class with a HashMap that stores operators,
 *order the operators by priority and check if the token is a valid operator.
 *****************************************************************************/
package operators;

import Evaluator.Operand;
import java.util.*;
public abstract class Operator {
  /*My own comments*/
  // HashMap operators = new HashMap();
    
  // The Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.
  // ALL subclasses of operator MUST be in their own file.
  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );
    

  //Create HashMap with operators as objects
  private static final Map <String, Operator> symbols = new HashMap <String, Operator>();
      
      static{
      symbols.put("+", new Addition());
      symbols.put("-", new Subtraction());
      symbols.put("*", new Multiplication());
      symbols.put("/", new Division());
      symbols.put("^", new Exponentiation());
      symbols.put("(", new OpenParenthesis());
      symbols.put(")", new CloseParenthesis());
      
      }
      
  
  
  public static Operator returnOperator(String token){

          return symbols.get(token);
  }
  
  
  //priority of operators 
  public abstract int priority(); //define in the subclasses
  
  //Perform the operations of each operator
  public abstract Operand execute( Operand op1, Operand op2 ); //define in the subclasses




  //Check if the operators are valid +-*/^()
  //next time just use the function getContain to include all operators
  public static boolean check( String token ) {
      if (token.equals("+")){
      return true;
      }
      if(token.equals("-")){
      return true;
      }
      if(token.equals("*")){
      return true;
      }
      if(token.equals("/")){
      return true;
      }
      if(token.equals("^")){
      return true;
      }
      if(token.equals("(")){
      return true;
      }
      if(token.equals(")")){
      return true;
      }
      else{
      return false;
      }
  }

  
}
