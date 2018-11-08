package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.sql.SQLOutput;

public class Controller {
    @FXML
    private TextField purchaseAmountField;
    @FXML
    private TextField downPaymentField;
    @FXML
    private TextField interestRateField;

    @FXML
    private TextField tenYearLoanField;

    @FXML
    public void onCalculateClicked(ActionEvent e) {
        try {

            if(!interestRateField.getText().isEmpty() && !purchaseAmountField.getText().isEmpty() && !downPaymentField.getText().isEmpty())
            {
                double interestRateMonthly = (Double.parseDouble(interestRateField.getText()) / 100) / 12;
                double purchasePrice = Double.parseDouble(purchaseAmountField.getText());
                double downPayment = Double.parseDouble(downPaymentField.getText());

                double tenYears = 12 * 10;
                double twentyYears = 12 * 20;
                double thirtyYears = 12 * 30;

                double totalRepayment= purchasePrice * ((topPartMortage(interestRateMonthly, tenYears)) / (bottomPartMortgage(interestRateMonthly,tenYears)));
                String total = String.format("%.2f", totalRepayment);

                tenYearLoanField.setText(total);
            }else
            {
                System.out.println("Empty fields");
            }

        } catch (Exception ex) {
                ex.printStackTrace();
        }

    }

    private double topPartMortage(double interestRate, double months)
    {
        return (java.lang.Math.pow((1 + interestRate), months)) * interestRate ;
    }

    private double bottomPartMortgage(double interestRate, double months)
    {
        return (java.lang.Math.pow((1 + interestRate), months)) - 1;
    }

}
