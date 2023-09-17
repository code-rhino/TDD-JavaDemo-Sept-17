package com.codedifferently;

public class CreditCard {

    // STATE
    private static int idCount = 1;
    private Integer id;
    private String name;
    private String zipcode;
    private Double limit;
    private Double currentCredit;

    // BEHAVIORS
    public CreditCard(String name, String zipcode, Double limit){
        this.id = idCount++;
        this.name = name;
        this.zipcode = zipcode;
        this.limit = limit;
        this.currentCredit = 0.0;
    }

    public void update(String name, String zipcode){

    }

    public String getInfo(){
        String response = String.format("id:%s, name:%s, zip:%s, currentBill:%.2f",id, name, zipcode, currentCredit);
        return response;
    }

    public void charge(Double amount) throws OverLimitException{
        // Is the amount  + current credit greater than limit
        Double tempChargeAmount = currentCredit + amount;
        if(tempChargeAmount > limit){
            throw new OverLimitException("Ya broke");
        }
        currentCredit += amount;

    }

    public Boolean reverseCharge(Double amount){
        return null;
    }

    public Double getCurrentCredit(){
        return currentCredit;
    }

    public Double getLimit(){
        return null;
    }
}
