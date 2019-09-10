package advancedJava;
import java.util.*;
import java.math.*;
import java.lang.*;
public class homework1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		int initialBase = 0;
		int finalBase = 0;
		int total = 0;
		int exponent = 0;
		char[] letterValue = new char[36];
		char[] inputComparison;
		boolean isValid = true;
		ArrayList<Integer> endResult = new ArrayList<Integer>();
		fillArray(letterValue);
	
		System.out.println("Hello User! Welcome to your base conversion calculator.");
		System.out.println("Please enter the String you would like to convert.");
		input = keyboard.next().toUpperCase();
		
		System.out.println("Please enter the initial base value.");
		initialBase = Integer.parseInt(keyboard.next());
		System.out.println("Please enter your desired final base value.");
		finalBase = Integer.parseInt(keyboard.next());
		
		inputComparison = input.toCharArray();
		
		
		for (int i = 0; i < inputComparison.length; ++i) {
			if((int)inputComparison[i] > (int)letterValue[initialBase])
				isValid = false;
		}
		if(isValid == false) {
			System.out.println("Your base is not big enough for your String, try again.");
		}
		else {
			for (int i = inputComparison.length - 1; i >= 0; --i) {
				for (int j = 0; j < letterValue.length; ++j) {
					if(((int)inputComparison[i] == (int)letterValue[j])) {
						total += j*Math.pow(initialBase, exponent);
					}
				}
				++exponent;
			}
			while(total > 0) {
				int digitValue = total % finalBase;
				endResult.add(0, digitValue);
				total = total / finalBase;
			}
			for(int i = 0; i < endResult.size(); ++i) {
				System.out.print(letterValue[endResult.get(i)]);
			}
		}
	}
	public static void fillArray(char[] letterValue) {
		for(int i = 0; i < 10; ++i) {
			letterValue[i] = (char)(i + 48);
			
		}
		for(int i = 10; i < 36; ++i) {
			letterValue[i] = (char)(i + 55);
			
		}
	}
}
