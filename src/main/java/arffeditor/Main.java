package arffeditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

import arffeditor.entities.ARFFFile;

public class Main {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Please enter the absolute path to the instruction file:");
		String path = sc1.nextLine();
		File file = new File(path);
		String input="";
		String[] commands;
		ARFFFile f = new ARFFFile();
		String baseInputPath = "";
		String baseOutputPath = "";
		try {
			Scanner sc= new Scanner(file);
			while(sc.hasNext()){
				input = sc.nextLine();
				commands = input.split(" ");
				switch(commands[0]){
					case "baseInputPath":		baseInputPath = commands[1];
												break;
					case "baseOutputPath":		baseOutputPath = commands[1];
												break;
					case "load": 				f = SimpleARFFParser.parseARFFFile(new File(baseInputPath+commands[1]));
												break;
												
					case "insertMissingValues": if(commands[1].equals("all")){
													MissingValueInjector.injectMissingValues(f, Double.valueOf(commands[2]));
												} else{
													MissingValueInjector.injectMissingValues(f, Integer.valueOf(commands[1]),Double.valueOf(commands[2]));
												}
												break;
					case "replaceMissingValuesMeanAttribute":			MissingValueReplacer.replaceMissingValuesWithMeanPerAttribute(f);	
																		break;
					case "replaceMissingValuesMeanAttributeClass":		MissingValueReplacer.replaceMissingValuesWithMeanPerAttributePerClass(f);	
																		break;
					case "replaceMissingValuesMedianAttribute":			MissingValueReplacer.replaceMissingValuesWithMedianPerAttribute(f);	
																		break;
					case "replaceMissingValuesMedianAttributeClass":	MissingValueReplacer.replaceMissingValuesWithMedianPerAttributePerClass(f);	
																		break;													
					case "write":		 		Files.write(Paths.get(baseOutputPath+commands[1]), Arrays.asList(f.toString().split("\n")), StandardCharsets.UTF_8, StandardOpenOption.CREATE);
												break;
					
				}
				
			}
			System.out.println("Done!");
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O Exception!");
			e.printStackTrace();
		} finally{
			sc1.close();
			
		}
		

	}
	


}
