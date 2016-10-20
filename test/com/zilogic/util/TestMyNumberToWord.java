/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zilogic.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;


/**
 *
 * @author sridhar
 */
public class TestMyNumberToWord {
    MyNumberToWord mynumbertoword;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
	mynumbertoword = new MyNumberToWord();
	
    }
    
    @After
    public void tearDown() {
	mynumbertoword = null;
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    @Test
    public void hello() {
	String str = "HelloWorld";
       	Assert.assertEquals("one", mynumbertoword.getWord("1"));
	Assert.assertEquals("two", mynumbertoword.getWord("2"));
	Assert.assertEquals("zero", mynumbertoword.getWord("0"));
	Assert.assertEquals("seven hundred eighty nine", mynumbertoword.getWord("789"));
	Assert.assertEquals("VERY HIGH VALUE", mynumbertoword.getWord("10000000000"));
	//Assert.assertEquals("nine hundred ninenty nine crore ninenty nine lakh ninenty nine thousand nine hundred ninenty nin", mynumbertoword.getWord("9999999999"));
	
    }
}