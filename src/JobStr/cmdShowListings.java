package JobStr;
import java.util.ArrayList;
import java.util.Scanner;

public class cmdShowListings implements Command {

	private ArrayList<? extends User> sessionList;
	private User sessionUser;
	private SessionManager sessionManager;
	private Scanner in;
	
	@Override
	public void execute(String[] cmdParts) throws Exception{ 
		// TODO Auto-generated method stub
		
		if(cmdParts[0] != "show" && cmdParts[1] != "listings"){
			throw new Exception("Invalid input");
		}
		
		Main.clearScreen();
		
		Scanner in = new Scanner(System.in);
		
		sessionManager		= SessionManager.getInstance();
		sessionUser		 	= sessionManager.getSessionUser();
		sessionList 		= sessionManager.getSessionList();
		
		System.out.println("LISTINGS MENU\n");
		System.out.println("There are " + sessionList.size() + " listings to display.");
		System.out.println("Enter y, n or exit depending on your preference.");
		
		
		for(User u:sessionList){
			// display function
						
			u.outputCardListing();
			
			System.out.println("\nEnter preference (y/n/exit):");
			String pref = in.nextLine();
			
			if(pref.equals("y")){
				// add to like table
				sessionManager.addToLikeTable(new Like(sessionUser, u));
				boolean isMatch = sessionManager.checkMatch(sessionUser, u); 
				if(isMatch==true){
					if(sessionUser instanceof Seeker){
						Seeker skrSessionUser = (Seeker) sessionUser;
						Listing lstU = (Listing) u;
						sessionManager.addMatch(new Match(skrSessionUser, lstU));
					} else {	
						Listing lstSessionUser = (Listing) sessionUser;
						Seeker skrU = (Seeker) u;
						sessionManager.addMatch(new Match(skrU, lstSessionUser));
					}
					System.out.print("\nYou've been matched with ");
					System.out.print(u.getName());
					System.out.println("!");
				}
			}
			if(pref.equals("exit")){
				return;
			}
		}
		System.out.println("\nEnd of listings!");
		try{System.in.read();} catch(Exception e){}
	}
}
