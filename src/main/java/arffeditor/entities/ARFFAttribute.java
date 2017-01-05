package arffeditor.entities;

public class ARFFAttribute {
	private String type;
	private String name;
	
	public ARFFAttribute(String name, String type){
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "@attribute "+name+" "+type;
	}
	

}
