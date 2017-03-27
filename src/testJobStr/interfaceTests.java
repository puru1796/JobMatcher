package testJobStr;

import static org.junit.Assert.*;

import JobStr.*;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class interfaceTests {

//	private SessionManager sessionManager;
	
	@Before
	public void setup(){
		//sessionManager = SessionManager.getInstance();
	}
	
	@Test
	public void testCmdLogin_1() {
		try {
			
			class loginStub extends cmdLogin{
				@Override
				public void execute(String[] cmdParts) throws Exception{
					boolean result = true;
					
					if(result){
						System.out.println("Logged In!");
						System.out.println("Press any key to continue.");
					} else {
						throw new Exception("Invalid username or password."); 
					}		
				}
			}
			
			
			cmdLogin loginCommand = new loginStub();
			
			String cmd[] = {"login"};
			String expOut = "Logged In!\nPress any key to continue.\n";
			setOutput();

			try {
				loginCommand.execute(cmd);
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testCmdLogin_2() {
		try {
			
			class loginStub extends cmdLogin{
				@Override
				public void execute(String[] cmdParts) throws Exception{
					boolean result = false;
					
					if(result){
						System.out.println("Logged In!");
						System.out.println("Press any key to continue.");
					} else {
						throw new Exception("Invalid username or password.");
					}		
				}
			}
			
			
			cmdLogin loginCommand = new loginStub();
			
			String cmd[] = {"login"};
			String expOut = "java.lang.Exception: Invalid username or password.\n";
			setOutput();

			try {
				loginCommand.execute(cmd);
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testCmdSignup_1(){
		try {

			class SignupStub extends cmdSignup {
				private ArrayList<String> jobs = new ArrayList<String>();
				
				@Override
				public void execute(String[] cmdParts) throws Exception{
					jobs.add("PHD");
					jobs.add("MSC");
					jobs.add("BSC");
					jobs.add("DIP");
					jobs.add("HS");
					jobs.add("NA");
					
					if(cmdParts[1].equals("employer")){
						try {
							System.out.println("Added user.");
						} catch (Exception e) {
							throw new Exception("Invalid Input");
						}
					} else if(cmdParts[1].equals("seeker")){
						try{
							System.out.println("Added user.");
						}catch(Exception e){
							throw new Exception("Invalid Input");
						}
					}else{
						throw new Exception("Invalid Input");
					}
				}
			}
			
			SignupStub signupCommand = new SignupStub();
			String[] cmd = {"signup", "not_a_user"};
			String expOut = "java.lang.Exception: Invalid Input\n";
			
			setOutput();			
			try {
				signupCommand.execute(cmd);
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testCmdSignup_2(){
		try {

			class SignupStub extends cmdSignup {
				private ArrayList<String> jobs = new ArrayList<String>();
				
				@Override
				public void execute(String[] cmdParts) throws Exception{
					jobs.add("PHD");
					jobs.add("MSC");
					jobs.add("BSC");
					jobs.add("DIP");
					jobs.add("HS");
					jobs.add("NA");
					
					if(cmdParts[1].equals("employer")){
						try {
							System.out.println("Added user.");
						} catch (Exception e) {
							throw new Exception("Invalid Input");
						}
					} else if(cmdParts[1].equals("seeker")){
						try{
							System.out.println("Added user.");
						}catch(Exception e){
							throw new Exception("Invalid Input");
						}
					}else{
						throw new Exception("Invalid Input");
					}
				}
			}
			
			SignupStub signupCommand = new SignupStub();
			String[] cmd = {"signup", "employer"};
			String expOut = "Added user.\n";
			
			setOutput();			
			try {
				signupCommand.execute(cmd);
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testCmdSignup_3(){
		try {

			class SignupStub extends cmdSignup {
				private ArrayList<String> jobs = new ArrayList<String>();
				
				@Override
				public void execute(String[] cmdParts) throws Exception{
					jobs.add("PHD");
					jobs.add("MSC");
					jobs.add("BSC");
					jobs.add("DIP");
					jobs.add("HS");
					jobs.add("NA");
					
					if(cmdParts[1].equals("employer")){
						try {
							System.out.println("Added user.");
						} catch (Exception e) {
							throw new Exception("Invalid Input");
						}
					} else if(cmdParts[1].equals("seeker")){
						try{
							System.out.println("Added user.");
						}catch(Exception e){
							throw new Exception("Invalid Input");
						}
					}else{
						throw new Exception("Invalid Input");
					}
				}
			}
			
			SignupStub signupCommand = new SignupStub();
			String[] cmd = {"signup", "seeker"};
			String expOut = "Added user.\n";
			
			setOutput();			
			try {
				signupCommand.execute(cmd);
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testCmdSignup_4(){
		try {

			class SignupStub extends cmdSignup {
				private ArrayList<String> jobs = new ArrayList<String>();
				
				@Override
				public void execute(String[] cmdParts) throws Exception{
					jobs.add("PHD");
					jobs.add("MSC");
					jobs.add("BSC");
					jobs.add("DIP");
					jobs.add("HS");
					jobs.add("NA");
					
					if(cmdParts[1].equals("employer")){
						try {
							signupListing();
							System.out.println("Added user.");
						} catch (Exception e) {
							throw new Exception("Invalid Input");
						}
					} else if(cmdParts[1].equals("seeker")){
						try{
							System.out.println("Added user.");
						}catch(Exception e){
							throw new Exception("Invalid Input");
						}
					}else{
						throw new Exception("Invalid Input");
					}
				}
				
				private Listing signupListing() throws Exception{
					String name = "test";
					String jobDescription = "test";
					String skillsRequired = "test";
					String jobTitle = "test";
					int expRequired = -1;
					String email = "test@abc.com";
					String password = "test";
					String education = "PHD";

					if(expRequired < 0){
						throw new Exception("Invalid Input");
					}
					
					if(!jobs.contains(education)){
						throw new Exception("Invalid Input");
					}			
					
					return new Listing(name, jobDescription, skillsRequired, jobTitle, expRequired, email, password, education);
				}
			}
			
			SignupStub signupCommand = new SignupStub();
			String[] cmd = {"signup", "employer"};
			String expOut = "java.lang.Exception: Invalid Input\n";
			
			setOutput();			
			try {
				signupCommand.execute(cmd);
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testCmdSignup_6(){
		try {

			class SignupStub extends cmdSignup {
				private ArrayList<String> jobs = new ArrayList<String>();
				
				@Override
				public void execute(String[] cmdParts) throws Exception{
					jobs.add("PHD");
					jobs.add("MSC");
					jobs.add("BSC");
					jobs.add("DIP");
					jobs.add("HS");
					jobs.add("NA");
					
					if(cmdParts[1].equals("employer")){
						try {
							signupListing();
							System.out.println("Added user.");
						} catch (Exception e) {
							throw new Exception("Invalid Input");
						}
					} else if(cmdParts[1].equals("seeker")){
						try{
							System.out.println("Added user.");
						}catch(Exception e){
							throw new Exception("Invalid Input");
						}
					}else{
						throw new Exception("Invalid Input");
					}
				}
				
				private Listing signupListing() throws Exception{
					String name = "test";
					String jobDescription = "test";
					String skillsRequired = "test";
					String jobTitle = "test";
					int expRequired = 1;
					String email = "test@abc.com";
					String password = "test";
					String education = "invalid_education";

					if(expRequired < 0){
						throw new Exception("Invalid Input");
					}
					
					if(!jobs.contains(education)){
						throw new Exception("Invalid Input");
					}			
					
					return new Listing(name, jobDescription, skillsRequired, jobTitle, expRequired, email, password, education);
				}
			}
			
			SignupStub signupCommand = new SignupStub();
			String[] cmd = {"signup", "employer"};
			String expOut = "java.lang.Exception: Invalid Input\n";
			
			setOutput();			
			try {
				signupCommand.execute(cmd);
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testCmdSignup_7(){
		try {

			class SignupStub extends cmdSignup {
				private ArrayList<String> jobs = new ArrayList<String>();
				
				@Override
				public void execute(String[] cmdParts) throws Exception{
					jobs.add("PHD");
					jobs.add("MSC");
					jobs.add("BSC");
					jobs.add("DIP");
					jobs.add("HS");
					jobs.add("NA");
					
					if(cmdParts[1].equals("employer")){
						try {
							signupListing();
							System.out.println("Added user.");
						} catch (Exception e) {
							throw new Exception("Invalid Input");
						}
					} else if(cmdParts[1].equals("seeker")){
						try{
							System.out.println("Added user.");
						}catch(Exception e){
							throw new Exception("Invalid Input");
						}
					}else{
						throw new Exception("Invalid Input");
					}
				}
				
				private Listing signupListing() throws Exception{
					String name = "test";
					String jobDescription = "test";
					String skillsRequired = "test";
					String jobTitle = "test";
					int expRequired = 1;
					String email = "test@abc.com";
					String password = "test";
					String education = "PHD";

					if(expRequired < 0){
						throw new Exception("Invalid Input");
					}
					
					if(!jobs.contains(education)){
						throw new Exception("Invalid Input");
					}			
					
					return new Listing(name, jobDescription, skillsRequired, jobTitle, expRequired, email, password, education);
				}
			}
			
			SignupStub signupCommand = new SignupStub();
			String[] cmd = {"signup", "employer"};
			String expOut = "Added user.\n";
			
			setOutput();			
			try {
				signupCommand.execute(cmd);
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testCmdSignup_8(){
		try {

			class SignupStub extends cmdSignup {
				private ArrayList<String> jobs = new ArrayList<String>();
				
				@Override
				public void execute(String[] cmdParts) throws Exception{
					jobs.add("PHD");
					jobs.add("MSC");
					jobs.add("BSC");
					jobs.add("DIP");
					jobs.add("HS");
					jobs.add("NA");
					
					if(cmdParts[1].equals("employer")){
						try {
							System.out.println("Added user.");
						} catch (Exception e) {
							throw new Exception("Invalid Input");
						}
					} else if(cmdParts[1].equals("seeker")){
						try{
							signupSeeker();
							System.out.println("Added user.");
						}catch(Exception e){
							throw new Exception("Invalid Input");
						}
					}else{
						throw new Exception("Invalid Input");
					}
				}
				
				private Seeker signupSeeker() throws Exception{
					String name = "test";
					String education = "invalid_education";
					int workExp = 1;
					String skills = "test";
					String email = "test@abc.com";
					String password = "password";

					if(!jobs.contains(education)){
						throw new Exception("Invalid Input");
					}

					if(workExp < 0){
						throw new Exception("Invalid Input");
					}
					return new Seeker(name, education, workExp, skills, email, password);					
				}
				
			}
			
			SignupStub signupCommand = new SignupStub();
			String[] cmd = {"signup", "seeker"};
			String expOut = "java.lang.Exception: Invalid Input\n";
			
			setOutput();			
			try {
				signupCommand.execute(cmd);
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testCmdSignup_9(){
		try {

			class SignupStub extends cmdSignup {
				private ArrayList<String> jobs = new ArrayList<String>();
				
				@Override
				public void execute(String[] cmdParts) throws Exception{
					jobs.add("PHD");
					jobs.add("MSC");
					jobs.add("BSC");
					jobs.add("DIP");
					jobs.add("HS");
					jobs.add("NA");
					
					if(cmdParts[1].equals("employer")){
						try {
							System.out.println("Added user.");
						} catch (Exception e) {
							throw new Exception("Invalid Input");
						}
					} else if(cmdParts[1].equals("seeker")){
						try{
							signupSeeker();
							System.out.println("Added user.");
						}catch(Exception e){
							throw new Exception("Invalid Input");
						}
					}else{
						throw new Exception("Invalid Input");
					}
				}
				
				private Seeker signupSeeker() throws Exception{
					String name = "test";
					String education = "PHD";
					int workExp = -1;
					String skills = "test";
					String email = "test@abc.com";
					String password = "password";

					if(!jobs.contains(education)){
						throw new Exception("Invalid Input");
					}

					if(workExp < 0){
						throw new Exception("Invalid Input");
					}
					return new Seeker(name, education, workExp, skills, email, password);					
				}
				
			}
			
			SignupStub signupCommand = new SignupStub();
			String[] cmd = {"signup", "seeker"};
			String expOut = "java.lang.Exception: Invalid Input\n";
			
			setOutput();			
			try {
				signupCommand.execute(cmd);
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testCmdSignup_10(){
		try {

			class SignupStub extends cmdSignup {
				private ArrayList<String> jobs = new ArrayList<String>();
				
				@Override
				public void execute(String[] cmdParts) throws Exception{
					jobs.add("PHD");
					jobs.add("MSC");
					jobs.add("BSC");
					jobs.add("DIP");
					jobs.add("HS");
					jobs.add("NA");
					
					if(cmdParts[1].equals("employer")){
						try {
							System.out.println("Added user.");
						} catch (Exception e) {
							throw new Exception("Invalid Input");
						}
					} else if(cmdParts[1].equals("seeker")){
						try{
							signupSeeker();
							System.out.println("Added user.");
						}catch(Exception e){
							throw new Exception("Invalid Input");
						}
					}else{
						throw new Exception("Invalid Input");
					}
				}
				
				private Seeker signupSeeker() throws Exception{
					String name = "test";
					String education = "PHD";
					int workExp = 2;
					String skills = "test";
					String email = "test@abc.com";
					String password = "password";

					if(!jobs.contains(education)){
						throw new Exception("Invalid Input");
					}

					if(workExp < 0){
						throw new Exception("Invalid Input");
					}
					return new Seeker(name, education, workExp, skills, email, password);					
				}
				
			}
			
			SignupStub signupCommand = new SignupStub();
			String[] cmd = {"signup", "seeker"};
			String expOut = "Added user.\n";
			
			setOutput();			
			try {
				signupCommand.execute(cmd);
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			assertEquals(expOut, getOutput());
			
		} catch(Exception e){
			System.out.println(e.toString());
		}
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
