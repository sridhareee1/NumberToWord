package com.zilogic.util;


import java.util.*;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * This programme can count 0 - 1000000000  zero - one hundred crore
 * Class take argument as String of a decimal number and convert it into a *
 * word and print the word standard output port
 * @author Sridhar Gopalan
 * @version 0.1
 */

class MyNumberToWord {

    /**
     * convert args[0] to word and print in
     * standard output stream
     */
    public static void main(String args[]) {
	if (args[0] != null ) {
	    System.out.println(getWord(args[0]));
	}
    }

    /**
     * @param number take string of number as argument
     * @return The word corresponding for the number.
     *
     */
    public static  String getWord(String number) {
	Double value = getNumber( number );
	Long r = getBeforedot(value);
	//Double b = getAfterdot(value);
	String word = getWord(split(r));
	//String word1 = getWord(split(getProcessed(b)));

	StringBuilder builder = new StringBuilder();
	builder.append(word+"");
	return builder.toString();
    }

    /**
     * @param value taken from argument and converted to double
     * Value is converted to long value by truncating the floating point
     */
    public static Long getBeforedot(Double value) {
	return value.longValue();
    }

    /**
     * @param value Taken from argument and converted to double
     *  to get value after the floating point
     *
     */
    public static Double getAfterdot(Double value) {
	value = value % 1;
	return value ;
    }

    /**
     * @param args Taken form the arg[0] given from terminal
     * string is converted to double value
     * @see Double.parseDouble(args)
     */
    public static Double getNumber(String args) {
	if (args != null)
	    return Double.parseDouble(args);
	return null;
    }

    /**
     *  @param value which is slipt into number according to the position
     *  @return Map which is packed with position and the corresponding value
     *  This function take value as argument and split the value accoding to the
     *  power and put it map with power as key and value as value.
     */
    public static  Map split(Long value) {
	int[] posValue = {10000000, 100000, 1000, 100, 10, 1};
	Long temp = Long.valueOf(0);
	Map<Integer, Integer> map = new HashMap();

	if (value == Long.valueOf(0)) {
	    map.put(1,0);
	    return map;

	}

	for(int x : posValue) {
	    temp = value / x;
	    if (temp != 0)
		{
		    map.put(x, temp.intValue());
		    value = value - (x*temp);
		}


	}
	//Set set = map.entrySet();
	//Iterator iterator = set.iterator();
	//while(iterator.hasNext() ) {
	//    Map.Entry mm = (Map.Entry)iterator.next();
	//    System.out.println("Key -- >"   + mm.getKey());
	//    System.out.println("Value -- >" + mm.getValue());
	//	}
	return map;
    }

    /**
     * @param value takes the floating point value less then 1
     *  and return the truncated value with 2 digit value and convert it
     *  to long value;
     *
     */
    public static Long getProcessed(Double value) {
	String str = value.toString();
	char[] chr = str.toCharArray();
	StringBuilder builder = new StringBuilder();
	if (chr.length != 0 && chr.length >= 2) {
	    for (int i = 2; i < chr.length; i++ ) {
		builder.append(chr[i]);
	    }
	}
	return Long.valueOf(builder.toString());

    }

    /**
     * @param value is key key number to get corresponding word
     * @return String is the word for corresponding given key
     *
     */

    public static String getString(int key) {
	Map<Integer, String> map = new HashMap();
	Set keys = map.keySet();
	map.put(0, "zero");
	map.put(1, "one");
	map.put(2, "two");
	map.put(3, "three");
	map.put(4, "four");
	map.put(5, "five");
	map.put(6, "six");
	map.put(7, "seven");
	map.put(8, "eight");
	map.put(9, "nine");
	map.put(10, "ten");

	map.put(11, "eleven");
	map.put(12, "twelve");
	map.put(13, "thirteen");
	map.put(14, "fourteen");
	map.put(15, "fifteen");
	map.put(16, "sixteen");
	map.put(17, "seventeen");
	map.put(18, "eighteen");
	map.put(19, "nineteen");
	map.put(20, "twenty");

	map.put(30, "thirty");
	map.put(40, "fourty");
	map.put(50, "fifty");
	map.put(60, "sixty");
	map.put(70, "seventy");
	map.put(80, "eighty");
	map.put(90, "ninenty");
	map.put(100, "hundred");
	map.put(1000, "thousand");
	map.put(100000, "lakh");
	map.put(10000000, "crore");

	if (keys.contains(key)) {
	    return map.get(key);
	}
	else {
	    return "";
	}
    }


    /**
     * @param map Map packged with positional ask key and value as argument
     * @return String is the correspoing word framed from the given map.
     * If the Crore value exceeds more then 100 then internally the split function
     * is called to get the map and the corresponding word is added with
     * using StringBuilder library.
     *
     */
    public static String getWord(Map map) {
	int[] posValue = {10000000, 100000, 1000, 100, 10, 1};
	StringBuilder builder = new StringBuilder();
	List<Integer> tempKey = new ArrayList<>();
	Set keys = map.keySet();
	for (int key : posValue) {
	    if (keys.contains(key)) {
		tempKey.add(key);
	    }
	}



	int value = 0, temp;
	for (int i :  tempKey) {
	    switch (i) {
	    case 10000000:
		if (keys.contains(i)) {
		    value =((Integer)map.get(i)).intValue();
		    if (value == 1) {
			builder.append("one"+" " + getString(value * i) + " ");
		    }

		    else {
			if ( value < 20 ) {
			    builder.append(getString(value) + " ");
			    builder.append(getString(i) + " ");
			}

			else if (value < 1000) {
			    Map map1 = split(Long.valueOf(value));
			    builder.append(getWord(map1) + " ");
			    builder.append(getString(i) + " ");
			}
			else {
			    builder.append("VERY HIGH VALUE");
			}

		    }


		}
		break;

	    case 100000:
		if (keys.contains(i)) {
		    value = ((Integer)map.get(i)).intValue();
		    if (value == 1) {
			builder.append("one"+" " + getString(value * i) + " ");
		    }
		    else {
			if ( value < 20 ) {
			    builder.append(getString(value) + " ");
			    builder.append(getString(i) + " ");
			}
			else {
			    Map map1 = split(Long.valueOf(value));
			    builder.append(getWord(map1) + " ");
			    builder.append(getString(i) + " ");
			}
		    }

		}
		break;

	    case 1000:
		if (keys.contains(i)) {
		    value = ((Integer)map.get(i)).intValue();
		    if (value == 1) {
			builder.append(getString(value * i) + " ");
		    }
		    else {
			if (value < 20 ) {
			    builder.append(getString(value) + " ");
			    builder.append(getString(i) + " ");
			}
			else {
			    Map map1 = split(Long.valueOf(value));
			    builder.append(getWord(map1) + " ");
			    builder.append(getString(i) + " ");

			}
		    }

		}
		break;
	    case 100:
		if (keys.contains(i)) {
		    value =((Integer)map.get(i)).intValue();
		    if (value == 1) {
			builder.append("one" + " "+ getString(value * i) + " ");
		    }
		    else {
			builder.append(getString(value) + " ");
			builder.append(getString(i) + " ");
		    }
		}
		break;

	    case 10:

		if (keys.contains(i)) {
		    value = ((Integer) map.get(i)).intValue();
		    if (value == 1) {
			if(keys.contains(1)) {
			    temp = value * 10 + ((Integer) map.get(1)).intValue();
			    builder.append(getString(temp) + " ");
			}
			else {
			    temp = value * 10;
			    builder.append(getString(temp) + " ");
			}
		    }
		    else {
			temp = value * 10;
			builder.append(getString(temp) + " ");
		    }

		}

		break;
	    case 1:
		if (keys.contains(10)) {
		    value = ((Integer)map.get(10)).intValue();
		    if (value > 1) {
			if (keys.contains(1)) {
			    value = ((Integer) map.get(1));
			    builder.append(getString(value));
			}
		    }

		}
		else {
		    value = ((Integer) map.get(i)).intValue();
		    builder.append(getString(value));
		}

		break;
	    }

	}
	return builder.toString();
    }
}
