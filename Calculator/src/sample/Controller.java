package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {


    @FXML
    private TextField calculatorTextField;
    private Double num1 = null;
    private Double num2 = null;
    private Character operator = null;
    private Double result = null;

    @FXML
    void calculate(ActionEvent event) {
        try {
            num2 = Double.parseDouble(calculatorTextField.getText());
            if (operator.equals('+')) {
                result = num1 + num2;
            } else if (operator.equals('-')) {
                result = num1 - num2;
            } else if (operator.equals('*')) {
                result = num1 * num2;
            } else if (operator.equals('/')) {
                result = num1 / num2;
            }
            if (result % 1.0 == 0) {

                calculatorTextField.setText(result.intValue() + "");
            } else {
                calculatorTextField.setText(result.toString());
            }
            num1 = null;
            num2 = null;
            operator = null;
            result = null;
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    @FXML
    void clearTextField(ActionEvent event) {
        calculatorTextField.setText("");
        num1 = null;
        num2 = null;
        operator = null;
        result = null;
    }

    @FXML
    void division(ActionEvent event) {
        if (num1 == null) {
            num1 = Double.parseDouble(calculatorTextField.getText());
            operator = '/';
            calculatorTextField.setText("");
        } else {
            operator = '/';
            calculate(event);
        }
    }

    @FXML
    void multiply(ActionEvent event) {
        if (num1 == null) {
            num1 = Double.parseDouble(calculatorTextField.getText());
            operator = '*';
            calculatorTextField.setText("");
        } else {
            operator = '*';
            calculate(event);
        }
    }

    @FXML
    void showEightNumber(ActionEvent event) {
        calculatorTextField.setText(calculatorTextField.getText() + 8);

    }

    @FXML
    void showFiveNumber(ActionEvent event) {
        calculatorTextField.setText(calculatorTextField.getText() + 5);
    }

    @FXML
    void showFourNumber(ActionEvent event) {
        calculatorTextField.setText(calculatorTextField.getText() + 4);
    }

    @FXML
    void showNineNumber(ActionEvent event) {
        calculatorTextField.setText(calculatorTextField.getText() + 9);
    }

    @FXML
    void showOneNumber(ActionEvent event) {
        calculatorTextField.setText(calculatorTextField.getText() + 1);
    }

    @FXML
    void showPoint(ActionEvent event) {
        if (!calculatorTextField.getText().contains(".")) {
            calculatorTextField.setText(calculatorTextField.getText() + ".");
        }

    }

    @FXML
    void showSevenNumber(ActionEvent event) {
        calculatorTextField.setText(calculatorTextField.getText() + 7);
    }

    @FXML
    void showSixNumber(ActionEvent event) {
        calculatorTextField.setText(calculatorTextField.getText() + 6);
    }

    @FXML
    void showThreeNumber(ActionEvent event) {
        calculatorTextField.setText(calculatorTextField.getText() + 3);
    }

    @FXML
    void showTwoNumber(ActionEvent event) {
        calculatorTextField.setText(calculatorTextField.getText() + 2);
    }

    @FXML
    void showZeroNumber(ActionEvent event) {
        calculatorTextField.setText(calculatorTextField.getText() + 0);
    }

    @FXML
    void subtraction(ActionEvent event) {
        if (num1 == null) {
            num1 = Double.parseDouble(calculatorTextField.getText());
            operator = '-';
            calculatorTextField.setText("");
        } else {
            operator = '-';
            calculate(event);
        }
    }

    @FXML
    void sum(ActionEvent event) {
        if (num1 == null) {
            num1 = Double.parseDouble(calculatorTextField.getText());
            operator = '+';
            calculatorTextField.setText("");
        } else {
            operator = '+';
            calculate(event);
        }
    }

}

