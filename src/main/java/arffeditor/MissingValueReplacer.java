package arffeditor;

import arffeditor.entities.ARFFFile;

public class MissingValueReplacer {
	
	/**
	 * Replaces missing values with mean of attribute with 4 decimal precision
	 * @param f The ARFFFile which missing values will be replaced
	 */
	public static void replaceMissingValuesWithMeanPerAttribute(ARFFFile f){
		double[] means = ARFFStatistics.getMeanPerAttribute(f);
		//iterate over rows
		for(int i = 0; i<f.getDataset().getRowCount();i++){
			//iterate over columns
			for(int j=0; j<f.getAttributes().size(); j++){
				if(f.getDataset().getAttributeValue(i, j).equals("?")){
					f.getDataset().setAttributeValue(i, j, ""+means[j]);
				}
			}
		}
	}
	
	/**
	 * Replaces missing values with mean of attribute per class with 4 decimal precision
	 * @param f The ARFFFile which missing values will be replaced
	 */
	public static void replaceMissingValuesWithMeanPerAttributePerClass(ARFFFile f){
		double[][] means = ARFFStatistics.getMeanPerAttributePerClass(f);
		//classindex
		int c=0;
		//iterate over rows
		for(int i = 0; i<f.getDataset().getRowCount();i++){
			//iterate over columns
			for(int j=0; j<f.getAttributes().size(); j++){
				if(f.getDataset().getAttributeValue(i, j).equals("?")){
					c=f.getClasses().indexOf(f.getDataset().getRow(i).getClassvalue());
					f.getDataset().setAttributeValue(i, j, ""+means[c][j]);
				}
			}
		}
	}
	
	/**
	 * Replaces missing values with median of attribute
	 * @param f The ARFFFile which missing values will be replaced
	 */
	public static void replaceMissingValuesWithMedianPerAttribute(ARFFFile f){
		double[] medians = ARFFStatistics.getMedianPerAttribute(f);
		//iterate over rows
		for(int i = 0; i<f.getDataset().getRowCount();i++){
			//iterate over columns
			for(int j=0; j<f.getAttributes().size(); j++){
				if(f.getDataset().getAttributeValue(i, j).equals("?")){
					f.getDataset().setAttributeValue(i, j, ""+medians[j]);
				}
			}
		}
	}
	
	/**
	 * Replaces missing values with median of attribute per class 
	 * @param f The ARFFFile which missing values will be replaced
	 */
	public static void replaceMissingValuesWithMedianPerAttributePerClass(ARFFFile f){
		double[][] medians = ARFFStatistics.getMedianPerAttributePerClass(f);
		//classindex
		int c=0;
		//iterate over rows
		for(int i = 0; i<f.getDataset().getRowCount();i++){
			//iterate over columns
			for(int j=0; j<f.getAttributes().size(); j++){
				if(f.getDataset().getAttributeValue(i, j).equals("?")){
					c=f.getClasses().indexOf(f.getDataset().getRow(i).getClassvalue());
					f.getDataset().setAttributeValue(i, j, ""+medians[c][j]);
				}
			}
		}
	}

}
