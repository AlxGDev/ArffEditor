package arffeditor;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import arffeditor.entities.ARFFFile;

public class StatisticsTest {

	@Test
	public void testPositiveValueCountPerAttribute() {
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		int[] result = ARFFStatistics.getPositiveValuesPerAttribute(testfile);
		
		assertEquals(0, result[3]);
		assertEquals(5, result[5]);
		assertEquals(0, result[254]);
		
	}
	
	@Test
	public void testCalculateMeanPerAttribute(){
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		double[] result = ARFFStatistics.getMeanPerAttribute(testfile);
		
		
		assertEquals(0.1,result[4],0.001);
		assertEquals(0.5, result[5],0.001);
	}
	
	@Test
	public void testCalculateMedianPerAttribute(){
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		double[] result = ARFFStatistics.getMedianPerAttribute(testfile);
		
		
		assertEquals(0.0,result[4],0.001);
		assertEquals(0.5, result[5],0.001);
		assertEquals(1.0, result[7],0.001);
	}
	
	@Test
	public void testCalculateMeanPerAttributeAndClass(){
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		double[][] result = ARFFStatistics.getMeanPerAttributePerClass(testfile);
	
		
		assertEquals(0.2,result[0][4],0.001);
		assertEquals(0.6,result[1][5],0.001);
		
	}
	
	@Test
	public void testCalculateMedianPerAttributeAndClass(){
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("semeion_test.arff").getFile()); */
		File file = new File("J:/semeion_test.arff");
		ARFFFile testfile = SimpleARFFParser.parseARFFFile(file);
		double[][] result = ARFFStatistics.getMedianPerAttributePerClass(testfile);
		
		assertEquals(0.0,result[0][4],0.001);
		assertEquals(1.0,result[0][6],0.001);
		assertEquals(1.0,result[1][6],0.001);
		
	}
	
	

}
