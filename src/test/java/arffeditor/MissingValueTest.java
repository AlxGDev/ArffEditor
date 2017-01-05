package arffeditor;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import arffeditor.entities.ARFFFile;

public class MissingValueTest {

	@Test
	public void testMissingValueInsertionForSingleAttribute() {
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		MissingValueInjector.injectMissingValues(testfile, 0, 0.3);
		
		assertEquals("?",testfile.getDataset().getAttributeValue(3, 0));
		assertEquals("?",testfile.getDataset().getAttributeValue(5, 0));
		assertEquals("?",testfile.getDataset().getAttributeValue(8, 0));
		
	}
	
	@Test
	public void testMissingValueInsertionForAllAttributes() {
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		MissingValueInjector.injectMissingValues(testfile, 0.5);
		assertEquals(1280, ARFFStatistics.getMissingValuesCount(testfile));
		
	}
	
	

}
