package com.cse.ds;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//17 test case
@FixMethodOrder(MethodSorters.JVM)
public class TestMailroom {

    static Mailroom mailroom;


    @Before
    public void populate(){
        mailroom = new Mailroom();
    }


    @Test
    public void testRegister() {
        Deliverable mail = new MyMail(1,
                                    "3811 Nobel Drive, La Jolla, CA, USA, 92037",
                                    "2231 Lebon Drive, La Jolla, CA, USA, 92632",
                                    "Hello World!");
        Deliverable mail2 = new MyPackage(2,
                "3811 Nobelasd Drasfive, La Jollasfa, CasdfA, USA, 92037",
                "92632, 2231 Leasdfbon Drasdive, La Jolasfla, CA, USA",
                "Hello World!",20);
        mailroom.registerItem(mail2);
        mailroom.registerItem(mail);
        
        
        Assert.assertTrue(mail2 == mailroom.checkEarliest());
    }

    @Test(expected = NullPointerException.class)
    public void testRegisterNull() {
        mailroom.registerItem(null);
    }



}
