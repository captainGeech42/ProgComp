package com.zanderwork;

import com.zanderwork.google.practice.MinimumScalarProduct;

/**
 * Created by Zander Work on 1/13/2017.
 */
public class Solve {

	private static String inputFileName = "D:\\DEVELOPMENT\\ProgComp\\src\\com\\zanderwork\\google\\practice\\io\\MinimumScalarProduct\\example.in";
	private static String outputFileName = "D:\\DEVELOPMENT\\ProgComp\\src\\com\\zanderwork\\google\\practice\\io\\MinimumScalarProduct\\example.out";

	public static void main(String[] args) {
		MinimumScalarProduct minimumScalarProduct = new MinimumScalarProduct(inputFileName, outputFileName);
		minimumScalarProduct.run();
		System.out.println("Finished execution");
	}
}
