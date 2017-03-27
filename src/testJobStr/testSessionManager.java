
package testJobStr;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import JobStr.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class testSessionManager {
	Like like1;
	Like like2;

	
	Listing employer1;
	Listing employer2;
	
	
	Seeker employee1;
	Seeker employee2;
	
	SessionManager instance = SessionManager.getInstance();
	
	@Test
	public void testLikeTable_01(){
		
		instance.clearLikeTable();
		instance.clearMatchTable();
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		
		like1 = new Like(employer1,employee1);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee1,employer1);
		instance.addToLikeTable(like2);
		
		boolean test = instance.checkMatch(employer1, employee1);
		assertEquals(true,test);
	}
	
	@Test
	public void testLikeTable_02(){
		
		instance.clearLikeTable();
		instance.clearMatchTable();
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employer2 = new Listing("BAML","Developing ","MYSQL C++ PYTHON","Developer",4,"fern@baml.com","dank","BSC");
		
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		employee2 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","herp@gmail.com","pass");
		
		
		like1 = new Like(employer1,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee1,employer1);
		instance.addToLikeTable(like2);
		
		boolean test = instance.checkMatch(employer2, employee1);
		assertEquals(false,test);
	}
	
	@Test
	public void testLikeTable_03(){
		
		instance.clearLikeTable();
		instance.clearMatchTable();
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employer2 = new Listing("BAML","Developing ","MYSQL C++ PYTHON","Developer",4,"fern@baml.com","dank","BSC");
		
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		employee2 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","herp@gmail.com","pass");
		
		
		like1 = new Like(employer2,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee2,employer1);
		instance.addToLikeTable(like2);
		
		boolean test = instance.checkMatch(employer2, employee2);
		assertEquals(false,test);
	}
	
	@Test
	public void testLikeTable_04(){
		
		instance.clearLikeTable();
		instance.clearMatchTable();
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employer2 = new Listing("BAML","Developing ","MYSQL C++ PYTHON","Developer",4,"fern@baml.com","dank","BSC");
		
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		employee2 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","herp@gmail.com","pass");
		
		
		like1 = new Like(employer1,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee2,employer1);
		instance.addToLikeTable(like2);
		
		boolean test = instance.checkMatch(employer2, employee1);
		assertEquals(false,test);
	}
	
	@Test
	public void testLikeTable_05(){
		
		instance.clearLikeTable();
		instance.clearMatchTable();
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employer2 = new Listing("BAML","Developing ","MYSQL C++ PYTHON","Developer",4,"fern@baml.com","dank","BSC");
		
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		employee2 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","herp@gmail.com","pass");
		
		
		like1 = new Like(employer1,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee2,employer1);
		instance.addToLikeTable(like2);
		
		boolean test = instance.checkMatch(employer1, employee2);
		assertEquals(true,test);
	}
	
	@Test
	public void testLikeTable_06(){
		
		instance.clearLikeTable();
		instance.clearMatchTable();
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employer2 = new Listing("BAML","Developing ","MYSQL C++ PYTHON","Developer",4,"fern@baml.com","dank","BSC");
		
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		employee2 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","herp@gmail.com","pass");
		
		
		like1 = new Like(employer2,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee2,employer2);
		instance.addToLikeTable(like2);
		
		boolean test = instance.checkMatch(employer2, employee2);
		assertEquals(true,test);
	}
	
	@Test
	public void testLikeTable_07(){
		
		instance.clearLikeTable();
		instance.clearMatchTable();
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employer2 = new Listing("BAML","Developing ","MYSQL C++ PYTHON","Developer",4,"fern@baml.com","dank","BSC");
		
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		employee2 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","herp@gmail.com","pass");
		
		
		like1 = new Like(employer2,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee1,employer1);
		instance.addToLikeTable(like2);
		
		boolean test = instance.checkMatch(employer2, employee2);
		assertEquals(false,test);
	}
	
	@Test
	public void testLikeTable_08(){
		
		instance.clearLikeTable();
		instance.clearMatchTable();
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employer2 = new Listing("BAML","Developing ","MYSQL C++ PYTHON","Developer",4,"fern@baml.com","dank","BSC");
		
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		employee2 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","herp@gmail.com","pass");
		
		
		like1 = new Like(employer2,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee1,employer1);
		instance.addToLikeTable(like2);
		
		boolean test = instance.checkMatch(employer1, employee2);
		assertEquals(false,test);
	}
}
