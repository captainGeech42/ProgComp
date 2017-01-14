//https://code.google.com/codejam/contest/351101/dashboard

//large and small both work

package com.zanderwork.google.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class StoreCredit {
	private String inputFileName;
	private String outputFileName;
	
	public StoreCredit(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}
	
	private String solve(int c, int i, ArrayList<Integer> items) {
		Iterator<Integer> iterator = items.iterator();
		Iterator<Integer> iterator2 = items.iterator();
		int index1 = 0;
		int index2 = 0;
		int item1 = 0;
		int item2 = 0;
		for (int x = 1; x <= i; x++) {
			index1 = x;
			item1 = iterator.next();
			index2 = 0;
			for (int y = 0; y < x; y++) {
				iterator2.next(); //move 2nd iterator to the element after item1
				index2++;
			}
			do {
				item2 = iterator2.next();
				index2++;
			} while (item1 + item2 != c && iterator2.hasNext());
			if (item1 + item2 == c) {
				break;
			}
			iterator2 = items.iterator();
		}
		return String.format("%d %d", index1, index2);
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
		int n = Integer.parseInt(scanner.nextLine());
		for (int x = 1; x <= n; x++) {
			int c = Integer.parseInt(scanner.nextLine()); //total credit
			int i = Integer.parseInt(scanner.nextLine()); //number of items
			ArrayList<Integer> items = new ArrayList<Integer>();
			String[] itemStrings = scanner.nextLine().split(" ");
			for (String item : itemStrings) {
				items.add(Integer.parseInt(item));
			}
			writer.println(String.format("Case #%d: %s", x, solve(c, i, items)));
		}
		scanner.close();
		writer.close();
	}
}
