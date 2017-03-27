package testJobStr;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import JobStr.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class testSuggestions_integration {
	private Listing job1;
	private Listing job2;
	private Listing job3;
	private Listing job4;
	
	private Seeker seeker1;
	private Seeker seeker2;
	private Seeker seeker3;
	private Seeker seeker4;
	
	private SessionManager instance = SessionManager.getInstance();
	
	private ArrayList<Listing> joblist;
	private ArrayList<Seeker> jobsearch;
	
	
	@Test
	public void testSuggestions_Integration_01(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","PHD");
		job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","MSC");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		seeker1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		joblist = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			joblist = sug.rankSuggestions(seeker1);
			String aname = joblist.get(0).getName();
			String aname2 = joblist.get(1).getName();
			String aname3 = joblist.get(2).getName();
			
			assertEquals("HSBC",aname);
			assertEquals("DB",aname2);
			assertEquals("BAML",aname3);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testSuggestions_Integration_02(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","HS");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","PHD");
		job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","MSC");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		seeker1 = new Seeker("Dayle","MSC",4,"MQSQL C++ JSS","derp@gmail.com","pass");
		joblist = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			joblist = sug.rankSuggestions(seeker1);
			String aname = joblist.get(0).getName();
			String aname2 = joblist.get(1).getName();
			String aname3 = joblist.get(2).getName();
			
			assertEquals("SC",aname);
			assertEquals("HSBC",aname2);
			assertEquals("DB",aname3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@Test
	public void testSuggestions_Integration_03(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","HS");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","MSC");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		seeker1 = new Seeker("Dayle","HS",4,"MQSQL PHP JSS","derp@gmail.com","pass");
		joblist = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			joblist = sug.rankSuggestions(seeker1);
			String aname = joblist.get(0).getName();
			String aname2 = joblist.get(1).getName();
			String aname3 = joblist.get(2).getName();
			
			assertEquals("BAML",aname);
			assertEquals("HSBC",aname2);
			assertEquals("SC",aname3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testSuggestions_Integration_04(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		seeker1 = new Seeker("Dayle","DIP",4,"MQSQL C++ JSS","derp@gmail.com","pass");
		joblist = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			joblist = sug.rankSuggestions(seeker1);
			String aname = joblist.get(0).getName();
			String aname2 = joblist.get(1).getName();
			String aname3 = joblist.get(2).getName();
			
			assertEquals("HSBC",aname);
			assertEquals("BAML",aname2);
			assertEquals("SC",aname3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
		
		
	}
	
	@Test
	public void testSuggestions_Integration_05(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","DIP");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		job3 = new Listing("DB","Analyst","JSS HTML CSS","Analyst",4,"fern@db.com","dank","DIP");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		seeker1 = new Seeker("Dayle","HS",4,"PHP MYSQL JSS","derp@gmail.com","pass");
		joblist = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			joblist = sug.rankSuggestions(seeker1);
			String aname = joblist.get(0).getName();
			String aname2 = joblist.get(1).getName();
			String aname3 = joblist.get(2).getName();
			
			assertEquals("BAML",aname);
			assertEquals("DB",aname2);
			assertEquals("SC",aname3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testSuggestions_Integration_0(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","DIP");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		job3 = new Listing("DB","Analyst","JSS HTML CSS","Analyst",4,"fern@db.com","dank","DIP");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		seeker1 = new Seeker("Dayle","HS",4,"PHP MYSQL JSS","derp@gmail.com","pass");
		joblist = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			joblist = sug.rankSuggestions(seeker1);
			String aname = joblist.get(0).getName();
			String aname2 = joblist.get(1).getName();
			String aname3 = joblist.get(2).getName();
			
			assertEquals("BAML",aname);
			assertEquals("DB",aname2);
			assertEquals("SC",aname3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testSuggestions_Integration_010(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","DIP");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		job3 = new Listing("DB","Analyst","JSS HTML CSS","Analyst",4,"fern@db.com","dank","DIP");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		seeker1 = new Seeker("Dayle","HS",4,"PHP MYSQL JSS","derp@gmail.com","pass");
		joblist = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			joblist = sug.rankSuggestions(seeker1);
			String aname = joblist.get(0).getName();
			String aname2 = joblist.get(1).getName();
			String aname3 = joblist.get(2).getName();
			
			assertEquals("BAML",aname);
			assertEquals("DB",aname2);
			assertEquals("SC",aname3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testSuggestions_Integration_012(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","DIP");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		job3 = new Listing("DB","Analyst","JSS HTML CSS","Analyst",4,"fern@db.com","dank","DIP");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		seeker1 = new Seeker("Dayle","HS",4,"PHP MYSQL JSS","derp@gmail.com","pass");
		joblist = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			joblist = sug.rankSuggestions(seeker1);
			String aname = joblist.get(0).getName();
			String aname2 = joblist.get(1).getName();
			String aname3 = joblist.get(2).getName();
			
			assertEquals("BAML",aname);
			assertEquals("DB",aname2);
			assertEquals("SC",aname3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testSuggestions_Integration_06(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","DIP");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		job3 = new Listing("DB","Analyst","JSS HTML CSS","Analyst",4,"fern@db.com","dank","DIP");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		seeker1 = new Seeker("Dayle","SCD",4,"PHP MYSQL JSS","derp@gmail.com","pass");
		joblist = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		
		try{
			joblist = sug.rankSuggestions(seeker1);
			
			String aname = joblist.get(0).getName();
			String aname2 = joblist.get(1).getName();
			String aname3 = joblist.get(2).getName();
			
			assertEquals("BAML",aname);
			assertEquals("DB",aname2);
			assertEquals("SC",aname3);
		}catch(Exception e){
			assertEquals("java.lang.Exception: Invalid input",e.getMessage());
		}
		
	}
	
	@Test
	public void testSuggestions_Integration_07(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","DIP");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		job3 = new Listing("DB","Analyst","JSS HTML CSS","Analyst",4,"fern@db.com","dank","DIP");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		seeker1 = new Seeker("Dayle","SCD",-1,"PHP MYSQL JSS","derp@gmail.com","pass");
		joblist = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		
		try{
			joblist = sug.rankSuggestions(seeker1);
			
			String aname = joblist.get(0).getName();
			String aname2 = joblist.get(1).getName();
			String aname3 = joblist.get(2).getName();
			
			assertEquals("BAML",aname);
			assertEquals("DB",aname2);
			assertEquals("SC",aname3);
		}catch(Exception e){
			assertEquals("java.lang.Exception: Invalid Input",e.getMessage());
		}
		
	}
	@Test
	public void testSuggestions_Integration_Listing_01(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA JS HTML CSS","Developer",4,"fern@hsbc.com","dank","BSC");
		//job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		//job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		//job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		/*instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);*/
		
		seeker1 = new Seeker("Dayle","MSC",6,"MQSQL C++ JSS","derp@gmail.com","pass");
		seeker2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		seeker3 = new Seeker("Kaids","PHD",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
		seeker4 = new Seeker("Dhruv","BSC",1,"MQSQL HTML JS","lerp@gmail.com","pass");
		
		instance.addSeeker(seeker1);
		instance.addSeeker(seeker2);
		instance.addSeeker(seeker3);
		instance.addSeeker(seeker4);
		
		
		
		jobsearch = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			jobsearch = sug.rankSuggestions(job1);
			String aname = jobsearch.get(0).getName();
			String aname2 = jobsearch.get(1).getName();
			String aname3 = jobsearch.get(2).getName();
			
			assertEquals("Dayle",aname);
			assertEquals("Puru",aname2);
			assertEquals("Kaids",aname3);
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
		
		
	}
	
	@Test
	public void testSuggestions_Integration_Listing_001(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA JS HTML CSS","Developer",4,"fern@hsbc.com","dank","BSC");
		//job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		//job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		//job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		/*instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);*/
		
		seeker1 = new Seeker("Dayle","NA",6,"MQSQL C++ JSS","derp@gmail.com","pass");
		seeker2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		seeker3 = new Seeker("Kaids","PHD",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
		seeker4 = new Seeker("Dhruv","BSC",1,"MQSQL HTML JS","lerp@gmail.com","pass");
		
		instance.addSeeker(seeker1);
		instance.addSeeker(seeker2);
		instance.addSeeker(seeker3);
		instance.addSeeker(seeker4);
		
		
		
		jobsearch = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			jobsearch = sug.rankSuggestions(job1);
			String aname = jobsearch.get(0).getName();
			String aname2 = jobsearch.get(1).getName();
			String aname3 = jobsearch.get(2).getName();
			
			assertEquals("Dayle",aname);
			assertEquals("Puru",aname2);
			assertEquals("Kaids",aname3);
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
		
		
	}
	
	
	
	@Test
	public void testSuggestions_Integration_Listing_02(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA JS HTML CSS Mongo","Developer",4,"fern@hsbc.com","dank","HS");
		//job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		//job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		//job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		/*instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);*/
		
		seeker1 = new Seeker("Dayle","PHD",6,"JSS","derp@gmail.com","pass");
		seeker2 = new Seeker("Puru","DIP",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		seeker3 = new Seeker("Kaids","DIP",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
		seeker4 = new Seeker("Dhruv","HS",1,"MQSQL HTML JS Mongo","lerp@gmail.com","pass");
		
		instance.addSeeker(seeker1);
		instance.addSeeker(seeker2);
		instance.addSeeker(seeker3);
		instance.addSeeker(seeker4);
		
		
		
		jobsearch = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			jobsearch = sug.rankSuggestions(job1);
			String aname = jobsearch.get(0).getName();
			String aname2 = jobsearch.get(1).getName();
			String aname3 = jobsearch.get(2).getName();
			
			assertEquals("Dayle",aname);
			assertEquals("Puru",aname2);
			assertEquals("Kaids",aname3);
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
	}
		
		@Test
		public void testSuggestions_Integration_Listing_03(){
			instance.refreshListing();
			instance.refreshSeekers();
			job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA JS HTML CSS Mongo","Developer",4,"fern@hsbc.com","dank","HS");
			//job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
			//job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
			//job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
			
			/*instance.addListing(job1);
			instance.addListing(job2);
			instance.addListing(job3);
			instance.addListing(job4);*/
			
			seeker1 = new Seeker("Dayle","PHD",6,"JSS","derp@gmail.com","pass");
			seeker2 = new Seeker("Puru","DIP",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
			seeker3 = new Seeker("Kaids","DIP",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
			seeker4 = new Seeker("Dhruv","HS",1,"MQSQL HTML JS Mongo","lerp@gmail.com","pass");
			
			instance.addSeeker(seeker1);
			instance.addSeeker(seeker2);
			instance.addSeeker(seeker3);
			instance.addSeeker(seeker4);
			
			
			
			jobsearch = new ArrayList<>();
			SuggestionsManager sug = new SuggestionsManager();
			try {
				jobsearch = sug.rankSuggestions(job1);
				String aname = jobsearch.get(0).getName();
				String aname2 = jobsearch.get(1).getName();
				String aname3 = jobsearch.get(2).getName();
				
				assertEquals("Dayle",aname);
				assertEquals("Puru",aname2);
				assertEquals("Kaids",aname3);
			} catch (Exception e) {
				System.out.println(e.toString());
				
			}
		
		
		
	}
	
	@Test
	public void testSuggestions_Integration_Listing_04(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA JS HTML CSS Mongo","Developer",4,"fern@hsbc.com","dank","PHD");
		//job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		//job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		//job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		/*instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);*/
		
		seeker1 = new Seeker("Dayle","SCD",6,"JSS","derp@gmail.com","pass");
		seeker2 = new Seeker("Puru","DIP",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		seeker3 = new Seeker("Kaids","DIP",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
		seeker4 = new Seeker("Dhruv","HS",1,"MQSQL HTML JS Mongo","lerp@gmail.com","pass");
		
		instance.addSeeker(seeker1);
		instance.addSeeker(seeker2);
		instance.addSeeker(seeker3);
		instance.addSeeker(seeker4);
		
		
		
		jobsearch = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			jobsearch = sug.rankSuggestions(job1);
			String aname = jobsearch.get(0).getName();
			String aname2 = jobsearch.get(1).getName();
			String aname3 = jobsearch.get(2).getName();
			
			assertEquals("Dayle",aname);
			assertEquals("Puru",aname2);
			assertEquals("Kaids",aname3);
		} catch (Exception e) {
			assertEquals("java.lang.Exception: Invalid input",e.getMessage());
			
		}
	}
	
	@Test
	public void testSuggestions_Integration_Listing_10(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA JS HTML CSS Mongo","Developer",4,"fern@hsbc.com","dank","PHD");
		//job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		//job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		//job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		/*instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);*/
		
		seeker1 = new Seeker("Dayle","SCD",6,"JSS","derp@gmail.com","pass");
		seeker2 = new Seeker("Puru","DIP",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		seeker3 = new Seeker("Kaids","DIP",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
		seeker4 = new Seeker("Dhruv","HS",1,"MQSQL HTML JS Mongo","lerp@gmail.com","pass");
		
		instance.addSeeker(seeker1);
		instance.addSeeker(seeker2);
		instance.addSeeker(seeker3);
		instance.addSeeker(seeker4);
		
		
		
		jobsearch = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			jobsearch = sug.rankSuggestions(job1);
			String aname = jobsearch.get(0).getName();
			String aname2 = jobsearch.get(1).getName();
			String aname3 = jobsearch.get(2).getName();
			
			assertEquals("Dayle",aname);
			assertEquals("Puru",aname2);
			assertEquals("Kaids",aname3);
		} catch (Exception e) {
			assertEquals("java.lang.Exception: Invalid input",e.getMessage());
			
		}
	}
	
	@Test
	public void testSuggestions_Integration_Listing_11(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA JS HTML CSS Mongo","Developer",4,"fern@hsbc.com","dank","MSC");
		//job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
		//job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		//job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		/*instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);*/
		
		seeker1 = new Seeker("Dayle","NA",6,"JSS","derp@gmail.com","pass");
		seeker2 = new Seeker("Puru","SCD",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		seeker3 = new Seeker("Kaids","DIP",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
		seeker4 = new Seeker("Dhruv","HS",1,"MQSQL HTML JS Mongo","lerp@gmail.com","pass");
		
		instance.addSeeker(seeker1);
		instance.addSeeker(seeker2);
		instance.addSeeker(seeker3);
		instance.addSeeker(seeker4);
		
		
		
		jobsearch = new ArrayList<>();
		SuggestionsManager sug = new SuggestionsManager();
		try {
			jobsearch = sug.rankSuggestions(job1);
			String aname = jobsearch.get(0).getName();
			String aname2 = jobsearch.get(1).getName();
			String aname3 = jobsearch.get(2).getName();
			
			assertEquals("Dayle",aname);
			assertEquals("Puru",aname2);
			assertEquals("Kaids",aname3);
		} catch (Exception e) {
			assertEquals("java.lang.Exception: Invalid input",e.getMessage());
			
		}
	}
		
		@Test
		public void testSuggestions_Integration_Listing_05(){
			instance.refreshListing();
			instance.refreshSeekers();
			job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA JS HTML CSS Mongo","Developer",4,"fern@hsbc.com","dank","SCD");
			//job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
			//job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
			//job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
			
			/*instance.addListing(job1);
			instance.addListing(job2);
			instance.addListing(job3);
			instance.addListing(job4);*/
			
			seeker1 = new Seeker("Dayle","PHD",6,"JSS","derp@gmail.com","pass");
			seeker2 = new Seeker("Puru","DIP",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
			seeker3 = new Seeker("Kaids","DIP",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
			seeker4 = new Seeker("Dhruv","HS",1,"MQSQL HTML JS Mongo","lerp@gmail.com","pass");
			
			instance.addSeeker(seeker1);
			instance.addSeeker(seeker2);
			instance.addSeeker(seeker3);
			instance.addSeeker(seeker4);
			
			
			
			jobsearch = new ArrayList<>();
			SuggestionsManager sug = new SuggestionsManager();
			try {
				jobsearch = sug.rankSuggestions(job1);
				String aname = jobsearch.get(0).getName();
				String aname2 = jobsearch.get(1).getName();
				String aname3 = jobsearch.get(2).getName();
				
				assertEquals("Dayle",aname);
				assertEquals("Puru",aname2);
				assertEquals("Kaids",aname3);
			} catch (Exception e) {
				assertEquals("java.lang.Exception: Invalid input",e.getMessage());
				
			}
		
		
		
	}
		
		@Test
		public void testSuggestions_Integration_Listing_005(){
			instance.refreshListing();
			instance.refreshSeekers();
			job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA JS HTML CSS Mongo","Developer",-4,"fern@hsbc.com","dank","BSC");
			//job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","HS");
			//job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
			//job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
			
			/*instance.addListing(job1);
			instance.addListing(job2);
			instance.addListing(job3);
			instance.addListing(job4);*/
			
			seeker1 = new Seeker("Dayle","PHD",6,"JSS","derp@gmail.com","pass");
			seeker2 = new Seeker("Puru","DIP",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
			seeker3 = new Seeker("Kaids","DIP",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
			seeker4 = new Seeker("Dhruv","SCD",1,"MQSQL HTML JS Mongo","lerp@gmail.com","pass");
			
			instance.addSeeker(seeker1);
			instance.addSeeker(seeker2);
			instance.addSeeker(seeker3);
			instance.addSeeker(seeker4);
			
			
			
			jobsearch = new ArrayList<>();
			SuggestionsManager sug = new SuggestionsManager();
			try {
				jobsearch = sug.rankSuggestions(job1);
				String aname = jobsearch.get(0).getName();
				String aname2 = jobsearch.get(1).getName();
				String aname3 = jobsearch.get(2).getName();
				
				assertEquals("Dayle",aname);
				assertEquals("Puru",aname2);
				assertEquals("Kaids",aname3);
			} catch (Exception e) {
				assertEquals("java.lang.Exception: Invalid input",e.getMessage());
				
			}
		
		
		
	}
	
	
	
	
}
