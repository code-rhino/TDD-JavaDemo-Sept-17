package com.codedifferently;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditCardTest {

    private CreditCard creditCard01;

    @BeforeEach
    public void bootStrap(){
        creditCard01 = new CreditCard("Tariq Hook", "123456", 100.00);
    }

    @Test
    public void getInfoTest01(){
        String expected = "id:1, name:Tariq Hook, zip:123456, currentBill:0.00";
        String actual = creditCard01.getInfo();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void chargeTest01() throws OverLimitException{
        Double amount = 1.00;
        creditCard01.charge(amount);
        Double expected = 1.00;
        Double actual = creditCard01.getCurrentCredit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void chargeTest02() {

        Assertions.assertThrows(OverLimitException.class, ()->{
            creditCard01.charge(99.00);
            creditCard01.charge(2.00);
        });
    }



}
