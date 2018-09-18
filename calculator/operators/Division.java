/*********************************************************************************************
 * File: [Assignment 01]
 * @author Diana Yu Yu
 * @since [06/16/2018]
 * Description: Subclass from operator class with its corresponding priority and execution.
 *********************************************************************************************/
package operators;
import Evaluator.Operand;

public class Division extends Operator{

	@Override
	public int priority(){
		return 2;
		}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		Operand divide = new Operand (op1.getValue() / op2.getValue());
		return divide;
		}
    
    
}
