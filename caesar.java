/*
 *Author: Ryan Wagner
 *Email: rkwagner@ucsd.edu
 *Description: Main driver for caesar cipher challenge.
 */

import java.util.Scanner;

class caesar{
	public static void main(String[] args){
		System.out.println("Caesar text encoder.  Encodes" +
				" sentences, ignoring non-letters.");
		System.out.print("Enter text to encode: ");
		Scanner in = new Scanner(System.in);
		String sysIn=in.nextLine();
		char[] input = sysIn.toCharArray();
		System.out.print("Enter shift amount: ");
		int sAmt=in.nextInt();
		int j=0;
		char charBuffer[] = new char[160];
		for(int i=0;i<input.length;i++){
			if (!upperChar(input[i]) &&!lowerChar(input[i])){
				System.out.println("Ignore invalid char " +
						"\""+input[i]+"\"");
			}
			else{
				charBuffer[j]=convertChar(input[i],sAmt);
				j++;		
			}
		}
		System.out.println("Shifted sequence: "+new String(charBuffer));
		for(int i=0;i<input.length;i++){
			charBuffer[i]=returnChar(charBuffer[i],sAmt);
		}
		System.out.println("Original: "+new String(charBuffer));
	}

	private static char convertChar(char a,int c){
		c=c%26;
		if(upperChar(a) && !((a-c)>=65)){
			c-=(a-65);
			a=91;
		}
		else if(lowerChar(a) && !((a-c)>=97)){
			c-=(a-97);
			a=123;
		}

		return (char)(a-c);
	}

	private static char returnChar(char a,int c){
		c=c%26;
		if(upperChar(a) && !((a+c)<=90)){
			c-=(90-a);
			a=64;
		}
		else if(lowerChar(a) && !((a+c)<=122)){
			c-=(122-a);
			a=96;
		}

		return (char)(a+c);
	}

	private static boolean upperChar(char a){
		if(a>=65 && a<=90)
			return true;
		return false;
	}

	private static boolean lowerChar(char a){
		if(a>=97 && a <=122)
			return true;
		return false;
	}
}
