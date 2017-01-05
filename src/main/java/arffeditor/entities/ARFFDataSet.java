package arffeditor.entities;


public class ARFFDataSet {
	
	
	private ARFFDataRow[] dataset;
	
	public ARFFDataSet(int rows){
		
		dataset = new ARFFDataRow[rows];
	}
	
	public ARFFDataRow getRow(int row){
		return dataset[row];
	}
	
	public void setRow(int row, ARFFDataRow value){
		this.dataset[row]= value;
	}
	
	public String getAttributeValue(int row, int column){
		
		return dataset[row].getAttributeValue(column);
	}
	
	public void setAttributeValue(int row, int column, String value){
		
		this.dataset[row].setAttributeValue(column, value);
	}

	public int getRowCount() {
		return dataset.length;
	}

	@Override
	public String toString() {
		String result = "@data\n";
		for(int i=0;i<dataset.length;i++){
			result+=dataset[i].toString();
		}
		return result;
	}
	
	

	
	
}
