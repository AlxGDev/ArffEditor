package arffeditor;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import arffeditor.entities.ARFFFile;

public class MissingValueReplaceTest {

	@Test
	public void testReplaceMissingValuesWithMeansPerAttribute() {
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		MissingValueInjector.injectMissingValues(testfile, 0.1);
		MissingValueReplacer.replaceMissingValuesWithMeanPerAttribute(testfile);
		
		
		assertEquals("0.0",testfile.getDataset().getAttributeValue(0, 0));
		assertEquals("0.5556",testfile.getDataset().getAttributeValue(0, 5));
	}
	
	@Test
	public void testReplaceMissingValuesWithMedianPerAttribute() {
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		MissingValueInjector.injectMissingValues(testfile, 0.1);
		MissingValueReplacer.replaceMissingValuesWithMedianPerAttribute(testfile);
		
		
		assertEquals("0.0",testfile.getDataset().getAttributeValue(0, 0));
		assertEquals("1.0",testfile.getDataset().getAttributeValue(0, 5));
	}
	
	@Test
	public void testReplaceMissingValuesWithMeansPerAttributePerClass() {
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		MissingValueInjector.injectMissingValues(testfile, 0.1);
	
		MissingValueReplacer.replaceMissingValuesWithMeanPerAttributePerClass(testfile);
		assertEquals("0.0",testfile.getDataset().getAttributeValue(0, 0));
		assertEquals("0.5",testfile.getDataset().getAttributeValue(0, 5));
		assertEquals("0.75",testfile.getDataset().getAttributeValue(7, 6));
	}
	
	@Test
	public void testReplaceMissingValuesWithMedianPerAttributePerClass() {
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		MissingValueInjector.injectMissingValues(testfile, 0.1);
		MissingValueReplacer.replaceMissingValuesWithMedianPerAttributePerClass(testfile);
		assertEquals("0.0",testfile.getDataset().getAttributeValue(0, 0));
		assertEquals("0.5",testfile.getDataset().getAttributeValue(0, 5));
		assertEquals("1.0",testfile.getDataset().getAttributeValue(7, 6));
	}

}
