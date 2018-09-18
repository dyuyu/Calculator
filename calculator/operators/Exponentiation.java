/*********************************************************************************************
 * File: [Assignment 01]
 * @author Diana Yu Yu
 * @since [06/16/2018]
 * Description: Subclass from operator class with its corresponding priority and execution.
 *********************************************************************************************/
package operators;
import Evaluator.Operand;
import java.util.*;

public class Exponentiation extends Operator{

    @Override
    public int priority(){
        return 3;
        }

    @Override
    public Operand execute(Operand op1, Operand op2) {

        double number = op1.getValue();
        double base = op2.getValue();
        double compute = Math.pow(number, base);
        int result = (int) compute; //casting
        Operand exponent = new Operand (result);
        return exponent;
    }
    
}

//the operand just wouldn't perform directly the power function
// so I decided to do it separately and then put the result
// in the operand object as a passing value 