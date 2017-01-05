package arffeditor;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import arffeditor.entities.ARFFFile;

public class MissingValueInjector {
	

	/**
	 * Inserts missing values randomly into a single attribute of an ARFF file
	 * @param f The ARFFFile that the missing values will be injected into
	 * @param attribute The index of the attribute of the ARFF data that should have its values replaced with missing values
	 * @param percentage The percentage of values that should be replaced with missing values, ranges from 0 to 1
	 */
	public static void injectMissingValues(ARFFFile f, int attribute, double percentage){
		
		int totalEntries = f.getDataset().getRowCount();
		int numberOfMissingValues = (int) Math.ceil(totalEntries * percentage);
		Set<Integer> indicesOfMissingValues = randomSample(totalEntries-1, numberOfMissingValues);
		for(Integer i: indicesOfMissingValues){
			f.getDataset().setAttributeValue(i, attribute, "?");
		}
	}
	
	/**
	 * Inserts missing values randomly across all attributes of an ARFF file
	 * @param f The ARFFFile that the missing values will be injected into
	 * @param percentage The percentage of values that should be replaced with missing values, ranges from 0 to 1
	 */
	public static void injectMissingValues(ARFFFile f, double percentage){
		int columnCount = f.getDataset().getRow(0).getAttributeCount();
		int totalEntries = f.getDataset().getRowCount()*columnCount;
		int numberOfMissingValues = (int) Math.ceil(totalEntries * percentage);
		Set<Integer> indicesOfMissingValues = randomSample(totalEntries-1, numberOfMissingValues);
		int row = 0;
		int column = 0;
		for(Integer i: indicesOfMissingValues){
			
			row = Math.floorDiv(i, columnCount);
			column = Math.floorMod(i, columnCount);
			f.getDataset().setAttributeValue(row, column, "?");
		}
	}

	/**
	 * Algorithm for selecting n random values, based on:
	 * https://eyalsch.wordpress.com/2010/04/01/random-sample/
	 * @param max The maximum value of the set
	 * @param n The amount of random values
	 * @return a set of random values in the range 0-max
	 */
	public static Set<Integer> randomSample(int max, int n) {
		Random rnd = new Random(42);
		HashSet<Integer> res = new HashSet<Integer>(n);
	    int count = max + 1;
	    for (int i = count - n; i < count; i++) {
	        Integer item = rnd.nextInt(i + 1);
	        if (res.contains(item))
	            res.add(i);
	        else
	            res.add(item);
	    }
	    return res;
	}
	
}
