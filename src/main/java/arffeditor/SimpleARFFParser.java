package arffeditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import arffeditor.entities.ARFFAttribute;
import arffeditor.entities.ARFFDataRow;
import arffeditor.entities.ARFFDataSet;
import arffeditor.entities.ARFFFile;

public class SimpleARFFParser {
	
	/**
	 * Parses an .arff file and builds an ARFFFile Object from it
	 * @param f The .arff File on disk 
	 */
	public static ARFFFile parseARFFFile(File f){
		String line="";
		String[] linesplit;
		ARFFFile resultfile = new ARFFFile();
		try {
			Scanner scan = new Scanner(f);
			  while(scan.hasNextLine()) {
		          line = scan.nextLine();
		          if(line.startsWith("@attribute")&&line.contains("Class")){
		        	  linesplit = line.split(" ");
		        	  linesplit = linesplit[2].replace('{',' ').replace('}', ' ').trim().split(",");
		        	  resultfile.setClasses(Arrays.asList(linesplit));
		          } else if(line.startsWith("@attribute")){
		        	  linesplit = line.split(" ");
		        	  resultfile.addAttribute(new ARFFAttribute(linesplit[1], linesplit[2]));
		          } else if(line.startsWith("@data")){
		        	  //parse dataset
		        	  List<String> datalist = new ArrayList<String>();
		        	  while(scan.hasNextLine()) {
				          line = scan.nextLine();
				          if(!"".equals(line.trim())){
				        	  datalist.add(line);
				          }
		        	  }
		        	  resultfile.setDataset(parseARFFData(datalist));
		          }
			  }
			  scan.close();
			  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultfile;
	}
	
	/**
	 * Parses a list of strings and turns them into an ARFFData Object, strings must have equal length
	 * @param data The list of strings from the @data tag of an .arff file
	 */
	public static ARFFDataSet parseARFFData(List<String> data){
		ARFFDataSet result = new ARFFDataSet(data.size());
		int columnCount = data.get(0).split(",").length-1;
		for(int i = 0;i<result.getRowCount();i++){
			result.setRow(i, new ARFFDataRow(columnCount));
			String[] splitline = data.get(i).split(",");
			for(int j = 0; j<splitline.length-1;j++){
				result.setAttributeValue(i, j, splitline[j]);
			}
			result.getRow(i).setClassvalue(splitline[splitline.length-1]);
		}
		
		return result;
	}

}
