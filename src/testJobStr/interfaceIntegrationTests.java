package testJobStr;

import static org.junit.Assert.*;

import JobStr.*;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class interfaceIntegrationTests {
	
	private SessionManager sessionManager;
	
	@Before
	public void setup(){
		sessionManager = SessionManager.getInstance();
	}
	
	@Test
	public void cmdLoginExecute_1(){
		try {
			cmdLogin loginCommand = new cmdLogin();
			
			User user = new Seeker("Dhruv Oberoi", "PHD", 42, "All", "dhruv@test.com", "password");
			sessionManager.addUser((Seeker)user);
			
			String[] cmd = {"login"};
			String input = "dhruv@test.com\npassword\n";
			String expOut = "Enter email:\nEnter password:\nLogged in!\nPress any key to continue.";

			setInput(input);
			setOutput();
			
			try {
				loginCommand.execute(cmd);
			} catch(Exception e){
				System.out.println(e.toString());
			}
			
			boolean success;
			if(getOutput().contains("Logged in!"))
				success = true;
			else
				success = false;
			
			assertEquals(true, success);
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void cmdLoginExecute_2(){
		try {
			cmdLogin loginCommand = new cmdLogin();
			
			User user = new Seeker("Dhruv Oberoi", "PHD", 42, "All", "dhruv@test.com", "password");
			sessionManager.addUser((Seeker)user);
			
			String[] cmd = {"login"};
			String input = "dhruv@test.com\teri_ma_kii\n\n";
			String expOut = "Enter email:\nEnter password:\nInvalid username or password.\nPress any key to continue.";

			setInput(input);
			setOutput();
			
			try {
				loginCommand.execute(cmd);
			} catch(Exception e){
				System.out.println(e.toString());
			}
			
			
			boolean success;
			if(getOutput().contains("Invalid username or password."))
				success = true;
			else
				success = false;
			
			assertEquals(true, success);
			
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void cmdSignup_1(){
		try {
			cmdSignup signupCommand = new cmdSignup();
			
			String[] cmd = {"signup", "invalid_inp"};
			String expOut = "java.lang.Exception: Invalid Input\n";

			setOutput();
			try {
				signupCommand.execute(cmd);
			} catch(Exception e){
				System.out.println(e.toString());
			}
			
			assertEquals(expOut,getOutput());
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void cmdSignup_2(){
		try {
			cmdSignup signupCommand = new cmdSignup();
			
			String[] cmd = {"signup", "employer"};
			
			String input = "test\n"
					+ "test\n"
					+ "test\n"
					+ "test\n"
					+ "-1\n"
					+ "PHD\n"
					+ "test@abc.ocm\n"
					+ "password\n\n";
			String expOut = "java.lang.Exception: Invalid Input\n";

			setInput(input);
			setOutput();
			try {
				signupCommand.execute(cmd);
			} catch(Exception e){
				System.out.println(e.toString());
			}
			
			boolean success;
			if(getOutput().contains("Invalid"))
				success = true;
			else 
				success = false;
			
			assertEquals(true, success);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void cmdSignup_3(){
		try {
			cmdSignup signupCommand = new cmdSignup();
			
			String[] cmd = {"signup", "employer"};
			
			String input = "test\n"
					+ "test\n"
					+ "test\n"
					+ "test\n"
					+ "2\n"
					+ "yolo\n"
					+ "test@abc.ocm\n"
					+ "password\n\n";
			String expOut = "java.lang.Exception: Invalid Input\n";

			setInput(input);
			setOutput();
			try {
				signupCommand.execute(cmd);
			} catch(Exception e){
				System.out.println(e.toString());
			}
			
			boolean success;
			if(getOutput().contains("Invalid"))
				success = true;
			else 
				success = false;
			
			assertEquals(true, success);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void cmdSignup_4(){
		try {
			cmdSignup signupCommand = new cmdSignup();
			
			String[] cmd = {"signup", "employer"};
			
			String input = "test\n"
					+ "test\n"
					+ "test\n"
					+ "test\n"
					+ "2\n"
					+ "PHD\n"
					+ "test@abc.ocm\n"
					+ "password\n\n";

			setInput(input);
			setOutput();
			try {
				signupCommand.execute(cmd);
			} catch(Exception e){
				System.out.println(e.toString());
			}
			
			boolean success;
			if(getOutput().contains("user created"))
				success = true;
			else 
				success = false;
			
			assertEquals(true, success);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void cmdSignup_5(){
		try {
			cmdSignup signupCommand = new cmdSignup();
			String[] cmd = {"signup", "seeker"};
			
			String input = "test\n" +
					"yolo\n" +
					"1\n" +
					"test\n" +
					"test@abc.ocm" +
					"test";
			
			setInput(input);
			setOutput();
			
			try {
				signupCommand.execute(cmd);
			} catch (Exception e){
				System.out.println(e.toString());
			}
			
			boolean success;
			if(getOutput().contains("Invalid"))
				success = true;
			else 
				success = false;
			
			assertEquals(true, success);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void cmdSignup_6(){
		try {
			cmdSignup signupCommand = new cmdSignup();
			String[] cmd = {"signup", "seeker"};
			
			String input = "test\n" +
					"PHD\n" +
					"-1\n" +
					"test\n" +
					"test@abc.ocm\n" +
					"test\n";
			
			setInput(input);
			setOutput();
			
			try {
				signupCommand.execute(cmd);
			} catch (Exception e){
				System.out.println(e.toString());
			}
			
			boolean success;
			if(getOutput().contains("Invalid"))
				success = true;
			else 
				success = false;
			
			assertEquals(true, success);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void cmdSignup_7(){
		try {
			cmdSignup signupCommand = new cmdSignup();
			String[] cmd = {"signup", "seeker"};
			
			String input = "test\n" +
					"HS\n" +
					"3\n" +
					"test\n" +
					"test@abc.ocm\n" +
					"test\n";
			
			setInput(input);
			setOutput();
			
			try {
				signupCommand.execute(cmd);
			} catch (Exception e){
				System.out.println(e.toString());
			}
		
			
			boolean success;
			if(getOutput().contains("user"))
				success = true;
			else 
				success = false;
			
			assertEquals(true, success);
			
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
    @Test
    public void testCmdShowListings_1(){
    	try {
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"incorrect", "fuckit"};
	    	String input = "y\n" +  "n\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success;
	    	if(getOutput().contains("Invalid"))
	    		success = true;
	    	else
	    		success = false;
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
	
    
    ByteArrayInputStream bis;
    
    private void setInput(String input){
    	bis = new ByteArrayInputStream(input.getBytes());
    	System.setIn(bis);
    	
    	System.setIn(System.in);
    }
    
	
    PrintStream oldPrintStream;
    ByteArrayOutputStream bos;
        
    private void setOutput() throws Exception
    {
        oldPrintStream = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
    }

    private String getOutput() 
    {
        System.setOut(oldPrintStream);
        return bos.toString();
    }
    
    

}
