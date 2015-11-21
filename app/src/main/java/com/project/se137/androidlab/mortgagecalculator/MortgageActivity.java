package com.project.se137.androidlab.mortgagecalculator;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MortgageActivity extends FragmentActivity {
    EditText homeValueEditText;
    EditText downPaymentEditText;
    EditText interestRateEditText;
    EditText propertyTaxEditText;
    Spinner termsSpinner;
    TextView monthlyPaymentTextView;
    TextView interestPaidTextView;
    TextView propertyTaxPaidTextView;
    TextView payOffTextView;
    TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage);

        //Get refernces to all widgets
        homeValueEditText = (EditText)findViewById(R.id.home_value_edit_text);
        downPaymentEditText = (EditText)findViewById(R.id.down_payment_edit_text);
        interestRateEditText = (EditText)findViewById(R.id.apr_edit_text);
        propertyTaxEditText = (EditText)findViewById(R.id.tax_rate_edit_text);
        termsSpinner = (Spinner)findViewById(R.id.terms_spinner);
        monthlyPaymentTextView = (TextView)findViewById(R.id.monthly_payment_text_view);
        interestPaidTextView = (TextView)findViewById(R.id.total_interest_paid_text_view);
        propertyTaxPaidTextView = (TextView)findViewById(R.id.total_tax_paid_text_view);
        payOffTextView = (TextView)findViewById(R.id.pay_off_date_text_view);
        errorTextView = (TextView)findViewById(R.id.error_text_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Get MenuInflater to inflate the desired menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_mortgage, menu);
        return true;
    }

    // Resets all items in the activity to their default state
    public void reset(View view){
        homeValueEditText.setText("");
        downPaymentEditText.setText("");
        interestRateEditText.setText("");
        propertyTaxEditText.setText("");
        termsSpinner.setSelection(0);
        monthlyPaymentTextView.setText("");
        interestPaidTextView.setText("");
        propertyTaxPaidTextView.setText("");
        payOffTextView.setText("");
        errorTextView.setText("");
    }

    //Calculates the mortgage values
    public void calc(View view){
        //Checks for errors and aborts calculation if errors exist
        if(isError()){
            return;
        }

        // Inputs
        float homeValue = Float.valueOf(homeValueEditText.getText().toString());
        float downPayment = Float.valueOf(downPaymentEditText.getText().toString());
        float interestRate = Float.valueOf(interestRateEditText.getText().toString());
        float propertyTax = Float.valueOf(propertyTaxEditText.getText().toString());
        int term = Integer.parseInt(termsSpinner.getSelectedItem().toString());

        // Calculations go here
        Mortgage mortgage = new Mortgage(homeValue, downPayment, interestRate, propertyTax, term);

        // Display the calculated values
        monthlyPaymentTextView.setText(Double.toString(mortgage.getMonthlyPayment()));
        interestPaidTextView.setText(Double.toString(mortgage.getTotalInterest()));
        propertyTaxPaidTextView.setText(Double.toString(mortgage.getTotalPropertyTax()));
        payOffTextView.setText(mortgage.getPayoffDate());
    }

    //Checks all error conditions before calculations and displays error messages
    private boolean isError(){
        if(homeValueEditText.getText().toString().equals("") || Float.valueOf(homeValueEditText.getText().toString()).isNaN()){
            errorTextView.setText("Invalid home value amount");
            return true;
        }
        if(downPaymentEditText.getText().toString().equals("") || Float.valueOf(downPaymentEditText.getText().toString()).isNaN()){
            errorTextView.setText("Invalid down payment amount");
            return true;
        }
        if(interestRateEditText.getText().toString().equals("") || Float.valueOf(interestRateEditText.getText().toString()).isNaN()){
            errorTextView.setText("Invalid interest rate");
            return true;
        }
        if(propertyTaxEditText.getText().toString().equals("") || Float.valueOf(propertyTaxEditText.getText().toString()).isNaN()){
            errorTextView.setText("Invalid property tax");
            return true;
        }

        return false;
    }
}
