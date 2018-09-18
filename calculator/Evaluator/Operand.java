/***************************************************************************
 * File: [Assignment 01]
 * @author Diana Yu Yu
 * @since [06/16/2018]
 * Description: Operand tokens that are converted in integers and checked.
 ***************************************************************************/
package Evaluator;

public class Operand {
    private int number;
  
 /*Constructor*/  
  public Operand( String token ) { //convert string into an int bc the operands will be numbers
      this.number = Integer.parseInt(token);
  }

  /*Constructor*/
  public Operand( int value ) {
      this.number = value;
  }

  /*Getter for value*/
  public int getValue() {
      return this.number;
  }

  
  //Check if the conversion has done correctly
  public static boolean check( String token ) {
      try {
          Integer.parseInt(token);
          return true;
      }

      catch (NumberFormatException e) {
      return false;
    }
  }
}