/**********************************************************************************
 * File: [Assignment 01]
 * @author Diana Yu Yu
 * @since [06/16/2018]
 * Description: GUI of the calculator where the user interact with the interface.
 *******************************************************************************8**/
package Evaluator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[bText.length];
    private int result;
    String TempSpace;
    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new Button(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = bt;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent arg0) {

        for(int i = 0 ; i < 14; i++){
            if(arg0.getSource() == buttons[i]){
                txField.setText(txField.getText() + arg0.getActionCommand());
            }
        }

        //set "=" to use the eval function for the result
        if(arg0.getSource() == buttons[14]) {
            Evaluator compute = new Evaluator(); //object of the evaluator class
            result = compute.eval(txField.getText());
            txField.setText(Integer.toString(result)); //cast result
        }


        for(int j = 15 ; j < 18; j++){
            if(arg0.getSource() == buttons[j]){
                txField.setText(txField.getText() + arg0.getActionCommand());
            }
        }

        //Set the whole text to blank C
        if(arg0.getSource() == buttons[18]){
            txField.setText("");
        }

        //Go one step back by erasing either operand or operator CE
        if(arg0.getSource() == buttons[19]){
            if(txField.getText().length() <= 1){
                TempSpace = "";
                txField.setText("0");
            }	
            else{ //return a new string that goes back one index
                TempSpace = txField.getText().substring(0, txField.getText().length() - 1);
                txField.setText(TempSpace);
            }
    }


    }
}

