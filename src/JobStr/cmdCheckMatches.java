package JobStr;
import java.util.ArrayList;
import java.util.Scanner;

public class cmdCheckMatches implements Command {

	private User sessionUser;
	private SessionManager sessionManager;
	private ArrayList<Match> matchTable;
	
	@Override
	public void execute(String[] cmdParts) {
		// TODO Auto-generated method stub
		
	
		Main.clearScreen();
		
		sessionManager		= SessionManager.getInstance();
		sessionUser		 	= sessionManager.getSessionUser();
		matchTable 			= sessionManager.getMatchTable(); 
		
		int matches = 0;
		
		for(Match m:matchTable){
			if(sessionUser instanceof Seeker){
				if(sessionUser.equals(m.getSeeker())){
					matches++;
				}
			} else {
				if(sessionUser.equals(m.getListing())){
					matches++;
				} 
			}
		}
		
		System.out.println("SUCCESSFUL MATCHES\n");
		System.out.println("You have " + matches + " matches.");
		
		for(Match m:matchTable){
			if(sessionUser instanceof Seeker){
				if(sessionUser.equals(m.getSeeker())){
					m.getListing().outputCardInViewMatches();
				}
			} else {
				if(sessionUser.equals(m.getListing())){
					m.getSeeker	().outputCardInViewMatches();
				}
			}
		}
		
		try{System.in.read();} catch(Exception e){}
		
	}

}
