package com.project.se137.androidlab.mortgagecalculator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by stephenpiazza on 11/20/15.
 */
public class Mortgage {

    float homeValue;
    float downPayment;
    float interestRate;
    float propertyTax;
    int termInMonths;

    public Mortgage(float homeValue, float downPayment, float interestRate, float propertyTax, int termInYears) {
        this.homeValue = homeValue;
        this.downPayment = downPayment;
        this.interestRate = interestRate/100;
        this.propertyTax = propertyTax;
        this.termInMonths = termInYears*12;
    }

    public double getMonthlyPayment(){
        return homeValue*(interestRate * Math.pow((1+interestRate), termInMonths)/(Math.pow((1+interestRate), termInMonths))-1);
    }

    public double getTotalInterest() {
        return Math.pow((1+interestRate), termInMonths);
    }

    public double getTotalPropertyTax() {
        return Math.pow((1+propertyTax), termInMonths);
    }

    public String getPayoffDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, termInMonths);
        return cal.get(Calendar.MONTH) + " " + cal.get(Calendar.YEAR);
    }
}
