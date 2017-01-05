package arffeditor;

import java.util.ArrayList;
import java.util.Collections;

import arffeditor.entities.ARFFFile;

public class ARFFStatistics {
	
	/**
	 * counts the missing values in a dataset
	 * @param f ARFFFile to count
	 * @return count of missing values
	 */
	public static int getMissingValuesCount(ARFFFile f){
		int count = 0;
		for(int i = 0; i<f.getDataset().getRowCount();i++){
			for(int j=0; j<f.getAttributes().size(); j++){
				if(f.getDataset().getAttributeValue(i, j).equals("?")){
					count++;
				}
			}
		}
		return count;
	}
	/**
	 * counts the missing values in a dataset per attribute
	 * @param f ARFFFile to count
	 * @return count of missing values per attribute in array
	 */
	public static int[] getMissingValuesCountPerAttribute(ARFFFile f){
		int count = 0;
		int[] result = new int[f.getAttributes().size()];
		for(int j = 0; j<f.getAttributes().size();j++){
			count=0;
			for(int i=0; i<f.getDataset().getRowCount(); i++){
				if(f.getDataset().getAttributeValue(i, j).equals("?")){
					count++;
				}
			}
			result[j] = count;
		}
		return result;
	}
	
	/**
	 * counts the positive values in a dataset per attribute
	 * @param f ARFFFile to count
	 * @return result count of positive values per attribute in array
	 */
	public static int[] getPositiveValuesPerAttribute(ARFFFile f){
		int count = 0;
		int[] result = new int[f.getAttributes().size()];
		for(int j = 0; j<f.getAttributes().size();j++){
			count=0;
			for(int i=0; i<f.getDataset().getRowCount(); i++){
				if(!f.getDataset().getAttributeValue(i, j).equals("?") && Integer.valueOf(f.getDataset().getAttributeValue(i, j)) >0){
					count++;
				}
			}
			result[j] = count;
		}
		return result;
	}
	
	/**
	 * calculates the mean values in a dataset per attribute
	 * @param f ARFFFile to calculate the mean per attribute for
	 * @return result mean of attribute values per attribute in array
	 */
	public static double[] getMeanPerAttribute(ARFFFile f){
		double sum = 0;
		//count of rows that have value
		int count = 0;
		double[] result = new double[f.getAttributes().size()];
		for(int j = 0; j<f.getAttributes().size();j++){
			sum=0;
			count=0;
			for(int i=0; i<f.getDataset().getRowCount(); i++){
				if(!f.getDataset().getAttributeValue(i, j).equals("?")){
					count++;
					sum+=Integer.valueOf(f.getDataset().getAttributeValue(i, j));
				}
			}
			result[j] = (double)Math.round((sum/count) * 10000d) / 10000d;
		}
		return result;
		
		
	}
	
	/**
	 * calculates the median values in a dataset per attribute
	 * @param f ARFFFile to calculate the median per attribute for
	 * @return result median of attribute values per attribute in array
	 */
	public static double[] getMedianPerAttribute(ARFFFile f){
		ArrayList<Integer> values = new ArrayList<Integer>();
		double[] result = new double[f.getAttributes().size()];
		for(int j = 0; j<f.getAttributes().size();j++){
			
			for(int i=0; i<f.getDataset().getRowCount(); i++){
				if(!f.getDataset().getAttributeValue(i, j).equals("?")){
					
					values.add(Integer.valueOf(f.getDataset().getAttributeValue(i, j)));
				}
			}
			
			result[j] = getMedian(values);
			values.clear();
		}
		return result;
		
		
	}
	
	/**
	 * calculates the mean values in a dataset per attribute per class
	 * @param f  ARFFFile to calculate the mean per attribute per class for
	 * @return result result mean of attribute values per attribute per class in array
	 */
	public static double[][] getMeanPerAttributePerClass(ARFFFile f){
		double sum = 0;
		//count of rows that match class and have value
		int count = 0;
		double[][] result = new double[f.getClasses().size()][f.getAttributes().size()];
		
		//Iterate over classes
		for(int c=0;c<f.getClasses().size();c++){
			//Iterate over Attributes
			for(int j = 0; j<f.getAttributes().size();j++){
				sum=0;
				count=0;
				//Iterate over rows
				for(int i=0; i<f.getDataset().getRowCount(); i++){
					//check if row belongs to class and has integer
					if(f.getDataset().getRow(i).getClassvalue().equals(f.getClasses().get(c)) && !f.getDataset().getAttributeValue(i, j).equals("?")){
							count++;
							sum+=Integer.valueOf(f.getDataset().getAttributeValue(i, j));
						
					}
					
				}
				result[c][j] = (double)Math.round(sum/count * 10000d) / 10000d;
			}
		}
		
		return result;
	}
	
	/**
	 * calculates the median values in a dataset per attribute per class
	 * @param f  ARFFFile to calculate the median per attribute per class for
	 * @return result result median of attribute values per attribute per class in array
	 */
	public static double[][] getMedianPerAttributePerClass(ARFFFile f){
		ArrayList<Integer> values = new ArrayList<Integer>();
		double[][] result = new double[f.getClasses().size()][f.getAttributes().size()];
		
		//Iterate over classes
		for(int c=0;c<f.getClasses().size();c++){
			//Iterate over Attributes
			for(int j = 0; j<f.getAttributes().size();j++){
				
				//Iterate over rows
				for(int i=0; i<f.getDataset().getRowCount(); i++){
					//check if row belongs to class and has integer
					if(f.getDataset().getRow(i).getClassvalue().equals(f.getClasses().get(c)) && !f.getDataset().getAttributeValue(i, j).equals("?")){
						values.add(Integer.valueOf(f.getDataset().getAttributeValue(i, j)));
					}
					
				}
				result[c][j] = getMedian(values);
				values.clear();
			}
		}
		
		return result;
	}
	
	private static double getMedian(ArrayList<Integer> values){
		Collections.sort(values);
		int middle = values.size()/2;
	    if (values.size()%2 == 1) {
	        return values.get(middle);
	    } else {
	        return (values.get(middle-1) + values.get(middle)) / 2.0;
	    }
	}
}
