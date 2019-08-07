package com.visa.prj.core;

import java.util.HashMap;

/**
 * 
 * Alpha Phrase to Phone Number Converter
 * 
 * @author banu
 * 
 */
public class PhoneNumberConverter {

	/**
	 * Converts the given alpha phrase to the corresponding phone number.
	 * 
	 * @param input
	 *            Input will be an alpha phrase which represents a phone number.
	 *            The input may contain the spaces and the hyphen (-).
	 * @return Output is the phone number and it retains any space and hyphen
	 *         symbol from the input.
	 */
	private static HashMap<Character, Integer> hs;
	static {
		hs=new HashMap<>();
		hs.put('A',2);
		hs.put('B',2);
		hs.put('C',2);
		hs.put('D',3);
		hs.put('E',3);
		hs.put('F',3);
		hs.put('G',4);
		hs.put('H',4);
		hs.put('I',4);
		hs.put('J',5);
		hs.put('K',5);
		hs.put('L',5);
		hs.put('M',6);
		hs.put('N',6);
		hs.put('O',6);
		hs.put('P',7);
		hs.put('Q',7);
		hs.put('R',7);
		hs.put('S',7);
		hs.put('T',8);
		hs.put('U',8);
		hs.put('V',8);
		hs.put('W',9);
		hs.put('X',9);
		hs.put('Y',9);
		hs.put('Z',9);
		
	}
	
	public String convertPhoneNumber(String input) {
		
		
		
		StringBuilder res=new StringBuilder();
		for(int i=0;i<input.length();i++) {
			if(Character.isDigit(input.charAt(i))){
				res.append(input.charAt(i));
			}
			else if(Character.isAlphabetic(input.charAt(i))){
				res.append(hs.get(Character.toUpperCase(input.charAt(i))));
			}
			else res.append(input.charAt(i));
		}

		return res.toString();
	}
}
