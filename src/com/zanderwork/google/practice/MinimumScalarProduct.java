//https://code.google.com/codejam/contest/dashboard?c=32016

//large doesn't work, but small does

package com.zanderwork.google.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class MinimumScalarProduct {
	private String inputFileName;
	private String outputFileName;
	
	public MinimumScalarProduct(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}

	private int solve(int numCoords, ArrayList<Integer> xCoords, ArrayList<Integer> yCoords) {
		Collections.sort(xCoords);
		Collections.sort(yCoords);
		Collections.reverse(yCoords);
		Iterator<Integer> xIterator = xCoords.iterator();
		Iterator<Integer> yIterator = yCoords.iterator();
		int msp = 0;
		while (xIterator.hasNext() && yIterator.hasNext()) {
			msp += xIterator.next() * yIterator.next();
		}
		return msp;
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
			ArrayList<Integer> xCoords = new ArrayList<Integer>(n);
			ArrayList<Integer> yCoords = new ArrayList<Integer>(n);
			for (String coord : scanner.nextLine().split(" ")) {
				xCoords.add(Integer.parseInt(coord));
			}
			for (String coord : scanner.nextLine().split(" ")) {
				yCoords.add(Integer.parseInt(coord));
			}
			writer.println(String.format("Case #%d: %d", x, solve(n, xCoords, yCoords)));
		}
		scanner.close();
		writer.close();
	}
}
