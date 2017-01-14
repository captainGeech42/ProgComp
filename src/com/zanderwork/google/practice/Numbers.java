//https://code.google.com/codejam/contest/dashboard?c=32016

//TODO calculation is larger than a long can hold, BigInteger implementation is required

package com.zanderwork.google.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Numbers {
	private String inputFileName;
	private String outputFileName;
	
	public Numbers(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}
	
	private String solve(int n) {
		long num = (long) Math.floor(Math.pow(3 + Math.sqrt(5), n));
		String numString = String.valueOf(num);
		String newString = null;
		if (numString.length() == 3) {
			newString = numString;
		} else if (numString.length() < 3) {
			newString = numString;
			do {
				newString = "0" + newString;
			} while (newString.length() < 3);
		} else {
			newString = numString.substring(numString.length() - 3, numString.length());
		}
		System.out.println(String.format("%s --> %s", numString, newString));
		return newString;
	}
	
	public void run() {
		Scanner scanner = null;
		PrintWriter writer = null;
		try {
			scanner = new Scanner(new File(inputFileName));
			writer = new PrintWriter(outputFileName, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int t = Integer.parseInt(scanner.nextLine());
		for (int x = 1; x <= t; x++) {
			int n = Integer.parseInt(scanner.nextLine());
			writer.println(String.format("Case #%d: %s", x, solve(n)));
		}
		scanner.close();
		writer.close();
	}
}
