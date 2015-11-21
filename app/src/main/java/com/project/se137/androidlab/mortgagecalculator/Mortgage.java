package com.project.se137.androidlab.mortgagecalculator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by stephenpiazza on 11/20/15.
 */
public class Mortgage {

    float homeValue;
    float interestRate;
    float propertyTax;
    int termInMonths;

    public Mortgage(float homeValue, float downPayment, float interestRate, float propertyTax, int termInYears) {
        this.homeValue = homeValue - downPayment;
        this.interestRate = (interestRate/100)/12;
        this.propertyTax = propertyTax/100;
        this.termInMonths = termInYears*12;
    }

    public double getMonthlyPayment(){
        return homeValue *  ((interestRate * Math.pow((1+interestRate), termInMonths))/
                            ((Math.pow((1+interestRate), termInMonths))-1));
    }

    public double getTotalInterest() {
        return homeValue *  ((((interestRate * termInMonths * Math.pow((1+interestRate), termInMonths))/
                            ((Math.pow((1+interestRate), termInMonths))-1))) - 1);
    }

    public double getTotalPropertyTax() {
        return homeValue * (propertyTax/12) * termInMonths;
    }

    public String getPayoffDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, termInMonths);
        SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy");
        return format.format(cal.getTime());
    }
}
