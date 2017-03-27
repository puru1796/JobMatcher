package testJobStr;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import JobStr.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testGetSkillScore {
	private Listing job;
	private Seeker person;
	private SessionManager instance = SessionManager.getInstance();

	
	@Test
	public void testGetSkillScore_01(){
		instance.refreshListing();
		job = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		instance.addListing(job);
		person = new Seeker("Dayle","BSC",4,"SQL C++ JAVA","derp@gmail.com","pass");
		SuggestionsManager sug = new SuggestionsManager();
		int m = sug.getSkillsScore(person);
		//System.out.println(m);
		assertEquals(20,m);
	}
	
	@Test
	public void testGetSkillScore_02(){
		instance.refreshListing();
		job = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		instance.addListing(job);
		person = new Seeker("Dayle","BSC",4,"SQL C++","derp@gmail.com","pass");
		instance.addSeeker(person);
		SuggestionsManager sug = new SuggestionsManager();
		int m = sug.getSkillsScore(person);
		//System.out.println(m);
		assertEquals(13,m);
	}
	
	@Test
	public void testGetSkillScore_03(){
		instance.refreshListing();
		job = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		instance.addListing(job);
		
		person = new Seeker("Dayle","BSC",4,"","derp@gmail.com","pass");
		instance.addSeeker(person);
		SuggestionsManager sug = new SuggestionsManager();
		int m = sug.getSkillsScore(person);
		//System.out.println(m);
		assertEquals(3,m);
	}
	
	@Test
	public void testGetSkillScore_Seeker_01(){
		instance.refreshListing();
		instance.refreshSeekers();
		job = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		instance.addListing(job);
		person = new Seeker("Dayle","BSC",4,"","derp@gmail.com","pass");
		instance.addSeeker(person);
		SuggestionsManager sug = new SuggestionsManager();
		int m = sug.getSkillsScore(job);
		//System.out.println(m);
		assertEquals(0,m);
	}
	
	@Test
	public void testGetSkillScore_Seeker_02(){
		instance.refreshListing();
		instance.refreshSeekers();
		job = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		instance.addListing(job);
		person = new Seeker("Dayle","BSC",4,"MQSQL TURBOC++ JAVA","derp@gmail.com","pass");
		instance.addSeeker(person);
		SuggestionsManager sug = new SuggestionsManager();
		int m = sug.getSkillsScore(job);
		//System.out.println(m);
		assertEquals(13,m);
	}
	
	@Test
	public void testGetSkillScore_Seeker_03(){
		instance.refreshListing();
		instance.refreshSeekers();
		job = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		instance.addListing(job);
		person = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		instance.addSeeker(person);
		SuggestionsManager sug = new SuggestionsManager();
		int m = sug.getSkillsScore(job);
		//System.out.println(m);
		assertEquals(16,m);
	}
	
	@Test
	public void testGetSkillScore_Seeker_04(){
		instance.refreshListing();
		instance.refreshSeekers();
		job = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		instance.addListing(job);
		person = new Seeker("Dayle","BSC",4,"SQL C++ JAVA","derp@gmail.com","pass");
		instance.addSeeker(person);
		SuggestionsManager sug = new SuggestionsManager();
		int m = sug.getSkillsScore(job);
		//System.out.println(m);
		assertEquals(20,m);
	}
}
