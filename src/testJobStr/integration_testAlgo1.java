package testJobStr;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import JobStr.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class integration_testAlgo1 {
	@Test
	public void test_EducationScore_Integration_01() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "MSC";
		int score = sug.getEducationScore(test, "PHD");
		assertEquals(0, score);
	}
	
	@Test
	public void test_EducationScore_Integration_02() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "MSC";
		int score = sug.getEducationScore(test, "BSC");
		assertEquals(5, score);
	}
	
	@Test
	public void test_EducationScore_Integration_03() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "SCD";
		try{
			int score = sug.getEducationScore(test, "MSC");
		}catch(Exception e){
			assertEquals("Invalid input", e.getMessage());
		}
	}
	
	@Test
	public void test_EducationScore_Integration_04() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "BSC";
		try{
			int score = sug.getEducationScore(test, "SCD");
		}catch(Exception e){
			assertEquals("Invalid input", e.getMessage());
		}
	}
	
	@Test
	public void test_EducationScore_Integration_5() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "HS";
		int score = sug.getEducationScore(test, "HS");
		
		assertEquals(10, score);
	}
	
	@Test
	public void test_EducationScore_Integration_06() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "HS";
		int score = sug.getEducationScore(test, "HS");
		
		assertEquals(10, score);
	}
	
	@Test
	public void test_EducationScore_Integration_07() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "HS";
		int score = sug.getEducationScore(test, "PHD");
		
		assertEquals(0, score);
	}
	
	@Test
	public void test_EducationScore_Integration_08() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "BSC";
		int score = sug.getEducationScore(test, "DIP");
		
		assertEquals(5, score);
	}
	
	@Test
	public void test_EducationScore_Integration_09() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "HS";
		int score = sug.getEducationScore(test, "DIP");
		
		assertEquals(0, score);
	}
	
	@Test
	public void test_EducationScore_Integration_010() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "NA";
		int score = sug.getEducationScore(test, "NA");
		
		assertEquals(10, score);
	}
	
	@Test
	public void test_scoreSkills_Integration_01() throws Exception{
		SuggestionsManager sug = new SuggestionsManager();
		String emp = "c++ java sql";
		String seek = "java c++ sql";
		int score = sug.scoreSkills(emp, seek);
		
		assertEquals(20,score);
	}
	
	@Test
	public void test_scoreSkills_Integration_02() throws Exception{
		SuggestionsManager sug = new SuggestionsManager();
		String emp = "java sql";
		String seek = "java c++ sql";
		int score = sug.scoreSkills(emp, seek);
		
		assertEquals(13,score);
	}
	
	@Test
	public void test_scoreSkills_Integration_03() throws Exception{
		SuggestionsManager sug = new SuggestionsManager();
		String emp = "java ";
		String seek = "java c++ sql";
		int score = sug.scoreSkills(emp, seek);
		
		assertEquals(6,score);
	}
	
	@Test
	public void test_scoreSkills_Integration_04() throws Exception{
		SuggestionsManager sug = new SuggestionsManager();
		String emp = " ";
		String seek = "java c++ sql";
		int score = sug.scoreSkills(emp, seek);
		
		assertEquals(0,score);
	}
	
	@Test
	public void test_scoreSkills_Integration_05() throws Exception{
		SuggestionsManager sug = new SuggestionsManager();
		String emp = "java c++ sql" ;
		String seek = "mysql jquery";
		int score = sug.scoreSkills(emp, seek);
		
		assertEquals(5,score);
	}
	
	@Test
	public void test_scoreSkills_Integration_06() throws Exception{
		SuggestionsManager sug = new SuggestionsManager();
		String emp = "java c++ sql jquery" ;
		String seek = "mysql turboc++ ";
		int score = sug.scoreSkills(emp, seek);
		
		assertEquals(10,score);
	}
}
