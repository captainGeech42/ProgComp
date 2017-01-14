package com.zanderwork.facebook.yr2017.qualification;

import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;

public class LazyLoading {
	private String inputFileName;
	private String outputFileName;
	
	public LazyLoading(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}
	
	private int solve(ArrayList<Integer> itemList) {
		Collections.sort(itemList, Collections.<Integer>reverseOrder());
		Iterator<Integer> iterator = itemList.iterator();
		ArrayDeque<Integer> itemDeque = new ArrayDeque<Integer>();
		while (iterator.hasNext()) {
			itemDeque.addLast(iterator.next());
		}
		int trips = 0;
		int largestItem = 0;
		int itemsInBag = 0;
		while (!itemDeque.isEmpty()) {
			if (largestItem == 0) {
				largestItem = itemDeque.pop();
			} else {
				itemDeque.removeLast();
			}
			itemsInBag++;
			if (largestItem * itemsInBag >= 50)
			{
				trips++;
				largestItem = 0;
				itemsInBag = 0;
			}
		}
		return trips;
	}
	
	public void run() {
		Scanner scanner = null;
		PrintWriter writer = null;
		try {
			scanner = new Scanner(new File(inputFileName));
			writer = new PrintWriter(outputFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int days = Integer.parseInt(scanner.nextLine());
		for (int x = 1; x <= days; x++) {
			int numItems = Integer.parseInt(scanner.nextLine());
			ArrayList<Integer> items = new ArrayList<Integer>();
			for (int y = 0; y < numItems; y++) {
				items.add(Integer.parseInt(scanner.nextLine()));
			}
			writer.println("Case #" + x + ": " + solve(items));
		}
		scanner.close();
		writer.close();
	}
}
