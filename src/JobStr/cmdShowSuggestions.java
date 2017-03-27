package JobStr;

import java.util.ArrayList;
import java.util.Scanner;

public class cmdShowSuggestions implements Command{

	private User sessionUser;
	private SessionManager sessionManager;
	private Scanner in;
	
	
	@Override
	public void execute(String[] cmdParts) throws Exception {
		// TODO Auto-generated method stub
		
		in = new Scanner(System.in);
		
		Main.clearScreen();
		
		sessionManager		= SessionManager.getInstance();
		sessionUser		 	= sessionManager.getSessionUser();
		
		SuggestionsManager suggestionsmanager = new SuggestionsManager();
		
		if(sessionUser instanceof Seeker){
			ArrayList<Listing> suggestions = suggestionsmanager.rankSuggestions((Seeker)sessionUser);
			for(Listing l:suggestions){
				l.outputSuggestions();

				// wait for input
				try{System.in.read();} catch(Exception e){}
			}
		}else{
			ArrayList<Seeker> suggestions = suggestionsmanager.rankSuggestions((Listing)sessionUser);
			for(Seeker s:suggestions){
				s.outputSuggestions();

				// wait for input
				try{System.in.read();} catch(Exception e){}
			}
		}
	}
}

