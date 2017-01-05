# README #

A simple parser and editor for ARFF files to inject random missing values into a dataset
Does not do any error handling, so be exact with input!

To use it, you can either execute java -jar arffeditor.jar in the commandline, with the delivered .jar file or import the source code into your favourite IDE
and run it from the Main.java class. If you want to recreate one of the data sets we used for our analysis, you can find the instruction files that you need to give as input
to the program in the datasets folder, but you likely need to change the baseInputPath and baseOutputPath variables in the files.

The instruction file supports the following commands:


baseInputPath [path]    							- Sets the base input path from where to load files

baseOutputPath [path]								- Sets the base output path where to write files

load [path]	 									    - loads and parses an .arff file to edit from baseInputPath+path

insertMissingValues [attributeindex] [percentage] 	- replaces a percentage of random attribute values with missing values for the given attribute. Index starts at 0, percentage is between 0 and 1
													  If attributeindex equals "all" then missing values will be inserted across all attributes

replaceMissingValuesMeanAttribute					- replaces missing values in a loaded .arff file with the mean value of the attribute of the missing value

replaceMissingValuesMeanAttributeClass				- replaces missing values in a loaded .arff file with the mean values of the attribute of the missing value per class

replaceMissingValuesMedianAttribute					- replaces missing values in a loaded .arff file with the median value of the attribute of the missing value	

replaceMissingValuesMedianAttributeClass			- replaces missing values in a loaded .arff file with the median values of the attribute of the missing value per class	
						
write	[path]										- creates and writes the edited .arff file to disk at baseOutputPath+path