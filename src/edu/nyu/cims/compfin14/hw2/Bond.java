package edu.nyu.cims.compfin14.hw2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anirudhan on 3/11/2015.
 */
public class Bond {

    private double price;
    private double copon;
    private double maturity;
    private double faceValue;
    private double frequency;
    Map<Double, Double> cashFlow = new HashMap<Double, Double>();

    Bond(double faceValue, double maturity, double price){
        this.faceValue = faceValue;
        this.maturity = maturity;
        this.copon = 0;
        this.price = price;
    }

    Bond(double faceValue, double maturity, double price, double coponPercentage, double frequency){
        this.faceValue = faceValue;
        this.maturity = maturity;
        this.copon = coponPercentage*faceValue/100;

        this.frequency = frequency;
        this.price = 0.0d;
        calculateCashFlow();
    }

    private void calculateCashFlow() {
//        cashFlow.put(0.0d, 0d);
        for(double pf = frequency; pf < maturity; pf+=frequency){
            cashFlow.put(pf, copon);
        }
        cashFlow.put(maturity,faceValue+copon);
    }

    public double getPrice(){
        return price;
    }

    public double getCopon() {
        return copon;
    }

    public Map<Double, Double> getCashFlow(){
        return cashFlow;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public double getMaturity() {
        return maturity;
    }
}
