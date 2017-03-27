package testJobStr;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import JobStr.*;


public class unit_testSuggestions {
	
	@Test
		public void test_ElimnateGenericWords_01() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "I know C++ and Java as well as MYSQL and JUNIT";
		String m = sug.ElimnateGenericWords(test);
		assertEquals("c++ java mysql junit", m);
	}
	
	@Test
	public void test_ElimnateGenericWords_02() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "I am competent in C# related tasks";
		String m = sug.ElimnateGenericWords(test);
		assertEquals("c#", m);
	}
	
	@Test
	public void test_ElimnateGenericWords_03() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "Intermediate knowledge of JQuery";
		String m = sug.ElimnateGenericWords(test);

		assertEquals("jquery", m);
	}
	
	@Test
	public void test_ElimnateGenericWords_04() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "I am very knowledgeable human being";
		String m = sug.ElimnateGenericWords(test);
		assertEquals("", m);
	}
	
	@Test
	public void test_EducationScore_Unit_01() throws Exception {
		class stub_SuggestionsManager extends SuggestionsManager{
			@Override 
			public int getDegreeValue(String edu){
				int score = 0;
				if(edu.equals("PHD")){
					score = 5;
				}
				else if(edu.equals("MSC")){
					score = 4;
				}
				else if(edu.equals("BSC")){
					score = 3;
				}
				else{
					score = -1;
				}
				return score;
			}
		}
		stub_SuggestionsManager pur = new stub_SuggestionsManager();
		String test = "PHD";
		int score = pur.getEducationScore(test, "PHD");
		assertEquals(10, score);
	}
	
	@Test
	public void test_EducationScore_Unit_02() throws Exception {
		class stub_SuggestionsManager extends SuggestionsManager{
			@Override 
			public int getDegreeValue(String edu){
				int score = 0;
				if(edu.equals("PHD")){
					score = 5;
				}
				else if(edu.equals("MSC")){
					score = 4;
				}
				else if(edu.equals("BSC")){
					score = 3;
				}
				else{
					score = -1;
				}
				return score;
			}
		}
		
		stub_SuggestionsManager pur = new stub_SuggestionsManager();
		String test = "PHD";
		int score = pur.getEducationScore(test, "MSC");
		assertEquals(5, score);
	}
	
	@Test
	public void test_EducationScore_Unit_03() throws Exception {
		class stub_SuggestionsManager extends SuggestionsManager{
			@Override 
			public int getDegreeValue(String edu){
				int score = 0;
				if(edu.equals("PHD")){
					score = 5;
				}
				else if(edu.equals("MSC")){
					score = 4;
				}
				else if(edu.equals("BSC")){
					score = 3;
				}
				else{
					score = -1;
				}
				return score;
			}
		}
		
		stub_SuggestionsManager pur = new stub_SuggestionsManager();
		String test = "BSC";
		int score = pur.getEducationScore(test, "PHD");
		assertEquals(0, score);
	}
	
	@Test
	public void test_EducationScore_Unit_04() throws Exception {
		class stub_SuggestionsManager extends SuggestionsManager{
			@Override 
			public int getDegreeValue(String edu){
				int score = 0;
				if(edu.equals("PHD")){
					score = 5;
				}
				else if(edu.equals("MSC")){
					score = 4;
				}
				else if(edu.equals("BSC")){
					score = 3;
				}
				else{
					score = -1;
				}
				return score;
			}
		}
		
		stub_SuggestionsManager pur = new stub_SuggestionsManager();
		try{
			String test = "SCD";
			int score = pur.getEducationScore(test, "PHD");
		}catch(Exception e){
			assertEquals("Invalid input", e.getMessage());
		}
	}
	
	@Test
	public void test_EducationScore_Unit_05() throws Exception {
		class stub_SuggestionsManager extends SuggestionsManager{
			@Override 
			public int getDegreeValue(String edu){
				int score = 0;
				if(edu.equals("PHD")){
					score = 5;
				}
				else if(edu.equals("MSC")){
					score = 4;
				}
				else if(edu.equals("BSC")){
					score = 3;
				}
				else{
					score = -1;
				}
				return score;
			}
		}
		
		stub_SuggestionsManager pur = new stub_SuggestionsManager();
		try{
			String test = "BSC";
			int score = pur.getEducationScore(test, "SCD");
		}catch(Exception e){
			assertEquals("Invalid input", e.getMessage());
		}
	}
	
	
	@Test
	public void test_getDegreeValue_01() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "PHD";
		int score = sug.getDegreeValue(test);
		
		assertEquals(5, score);
	}
	
	@Test
	public void test_getDegreeValue_02() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "MSC";
		int score = sug.getDegreeValue(test);
		
		assertEquals(4, score);
	}
	
	@Test
	public void test_getDegreeValue_03() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "BSC";
		int score = sug.getDegreeValue(test);
		
		assertEquals(3, score);
	}
	
	@Test
	public void test_getDegreeValue_04() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "DIP";
		int score = sug.getDegreeValue(test);
		
		assertEquals(2, score);
	}
	
	@Test
	public void test_getDegreeValue_05() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "HS";
		int score = sug.getDegreeValue(test);
		
		assertEquals(1, score);
	}	
	@Test
	public void test_getDegreeValue_06() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "NA";
		int score = sug.getDegreeValue(test);
		
		assertEquals(0, score);
	}
	
	@Test
	public void test_getDegreeValue_07() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		String test = "SCD";
		int score = sug.getDegreeValue(test);
		
		assertEquals(-1, score);
	}
	
	@Test
	public void test_scoreSkills_01() throws Exception{
		SuggestionsManager sug = new SuggestionsManager();
		class stub_sesh extends SuggestionsManager{
			@Override
			public double generateSkillScore(String skill, String[] skillList){
				for(String s:skillList){
					return 1;
				}
				return 0;
			}
		}
		String emp = "java c++ sql" ;
		String seek = "java c++ sql";
		int score = sug.scoreSkills(emp, seek);
		
		assertEquals(20,score);
	}
	
	@Test
	public void test_scoreSkills_02() throws Exception{
		SuggestionsManager sug = new SuggestionsManager();
		class stub_sesh extends SuggestionsManager{
			@Override
			public double generateSkillScore(String skill, String[] skillList){
				for(String s:skillList){
					return 1;
				}
				return 0;
			}
		}
		String emp = "java c++ sql" ;
		String seek = " ";
		int score = sug.scoreSkills(emp, seek);
		
		assertEquals(0,score);
	}
	
	@Test
	public void test_scoreSkills_03() throws Exception{
		SuggestionsManager sug = new SuggestionsManager();
		class stub_sesh extends SuggestionsManager{
			@Override
			public double generateSkillScore(String skill, String[] skillList){
				for(String s:skillList){
					return 0.5;
				}
				return 0;
			}
		}
		String emp = "java c++ sql" ;
		String seek = "msql turboc++ javac";
		int score = sug.scoreSkills(emp, seek);
		//System.out.println(score);
		assertEquals(10,score);
	}
	
	@Test
	public void test_getWorkExperience_01() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		int need = 10;
		int have = 8;
		int score = sug.getWorkExperienceScore(have, need);
		
		assertEquals(15, score);
	}
	
	@Test
	public void test_getWorkExperience_02() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		int need = 10;
		int have = 8;
		int score = sug.getWorkExperienceScore(have, need);
		
		assertEquals(15, score);
	}
	
	@Test
	public void test_getWorkExperience_03() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		int need = 10;
		int have = 9;
		int score = sug.getWorkExperienceScore(have, need);
		
		assertEquals(20, score);
	}
	
	@Test
	public void test_getWorkExperience_04() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		int need = 10;
		int have = 2;
		int score = sug.getWorkExperienceScore(have, need);
		
		assertEquals(0, score);
	}
	
	@Test
	public void test_getWorkExperience_05() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		int need = 10;
		int have = 6;
		int score = sug.getWorkExperienceScore(have, need);
		
		assertEquals(5, score);
	}
	
	@Test
	public void test_getWorkExperience_06() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		int need = 10;
		int have = 12;
		int score = sug.getWorkExperienceScore(have, need);
		
		assertEquals(20, score);
	}
	
	@Test
	public void test_getWorkExperience_07() throws Exception {
		SuggestionsManager sug = new SuggestionsManager();
		int need = 10;
		int have = 20;
		int score = sug.getWorkExperienceScore(have, need);
		
		assertEquals(20, score);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
