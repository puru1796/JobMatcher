package JobStr;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		SessionManager.getInstance().init();
		
		try {
			Scanner in = new Scanner(System.in);
						
			boolean first = true;
			while(true){
				clearScreen();
				
				if(first){first = false;}
				else { System.out.println(); } 
				
				System.out.println("Hi, there!");
				System.out.println("We'll help you look for jobs that are perfect for you.");
				System.out.println();
				
				System.out.println("Available commands: ");
				System.out.println("\t1. signup <employer|seeker>");
				System.out.println("\t2. login");
				System.out.println("\t3. exit");
				
				System.out.print("\nEnter command: ");
				
				String cmd = in.nextLine();
				String[] cmdParts = cmd.split(" ");
				
				processInput(cmdParts);
			}			
		} catch (Exception e){
			
		}
	}
	
	private static void processInput(String cmdParts[]) { //throws InvalidCommandException {
		
		if(cmdParts[0].equals("exit")){
			System.out.println("\nGoodbye, see you soon!");
			System.exit(0);
		}
		
		/****************** debug *******************************/
		if(cmdParts[0].equals("dbg")){
			System.out.println(System.getProperty("user.dir"));
			
			SessionManager sm 				= SessionManager.getInstance();
			ArrayList<Seeker> seekers 		= sm.getSeekers();
			ArrayList<Listing> listings 	= sm.getListings();
			ArrayList<Like> likeTable 		= sm.getLikeTable();
			ArrayList<Match> matchTable 	= sm.getMatchTable();
			
			System.out.println("Seekers: ");
			for(Seeker s:seekers){
				System.out.println(s.toString());
			}
			
			System.out.println("Listings: ");
			for(Listing l:listings){
				System.out.println(l.toString());
			}
			
			System.out.println("Likes: ");
			for(Like lk:likeTable){
				System.out.println(lk.toString());
			}
			
			System.out.println("Matches: ");
			for(Match m:matchTable){
				System.out.println(m.toString());
			}
			
			// wait for input
			try{System.in.read();} catch(Exception e){}
		}
		
		/*********************************************************/
		
		int argCount = cmdParts.length;
		
		if(argCount < 1 || argCount > 3); // throw new InvalidCommandException();
			
		if(cmdParts[0].equals("signup")){
			try {
				(new cmdSignup()).execute(cmdParts);
				System.out.println("User added sucessfully");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			
		}
		
		else if(cmdParts[0].equals("login")){
			try {
				(new cmdLogin()).execute(cmdParts);
			}
			catch (Exception e){
				System.out.println(e.toString());
				System.out.println("Press any key to continue.");
            }
		}
		
		else {
			// throw new InvalidCommandException();
		}
	}
	
	public static void clearScreen() {  
	    for(int i=0; i<100; i++)
	    	System.out.println();  
	}  

}
