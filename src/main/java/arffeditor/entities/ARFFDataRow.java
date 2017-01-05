package arffeditor.entities;

public class ARFFDataRow {
	
	private String[] attributes;
	private String classvalue;
	
	public ARFFDataRow(int attributecount){
		this.attributes = new String[attributecount];
	}

	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}
	
	public String getAttributeValue(int index){
		return attributes[index];
	}
	
	public void setAttributeValue(int index, String value){
		this.attributes[index] = value;
	}
	
	public String getClassvalue() {
		return classvalue;
	}

	public void setClassvalue(String classvalue) {
		this.classvalue = classvalue;
	}
	
	public int getAttributeCount(){
		return attributes.length;
	}

	@Override
	public String toString() {
		String result = "";
		for(int i=0;i<this.getAttributeCount();i++){
			result+=attributes[i]+",";
		}
		result+=classvalue+"\n";
		return result;
	}
	
	
	

}
