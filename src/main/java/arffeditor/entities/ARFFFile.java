package arffeditor.entities;

import java.util.ArrayList;
import java.util.List;

public class ARFFFile {
	private List<ARFFAttribute> attributes;
	private List<String> classes;
	private ARFFDataSet dataset;
	
	public ARFFFile(){
		this.attributes = new ArrayList<ARFFAttribute>();
		this.classes = new ArrayList<String>();
	}

	public List<ARFFAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ARFFAttribute> attributes) {
		this.attributes = attributes;
	}
	
	public void addAttribute(ARFFAttribute attribute){
		this.attributes.add(attribute);
	}

	public List<String> getClasses() {
		return classes;
	}

	public void setClasses(List<String> classes) {
		this.classes = classes;
	}

	public ARFFDataSet getDataset() {
		return dataset;
	}

	public void setDataset(ARFFDataSet dataset) {
		this.dataset = dataset;
	}

	@Override
	public String toString() {
		String result = "@relation R_data_frame\n\n";
		for(ARFFAttribute a: attributes){
			result+=a.toString()+"\n";
		}
		result += "@attribute Class {";
		for(int i = 0; i<classes.size();i++){
			result+=classes.get(i);
			if(i!=classes.size()-1){
				result+=",";
			}
		}
		result+="}\n\n";
		result+=dataset.toString();
		return result;
	}
	

}
