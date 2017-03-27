package JobStr;
/* Singleton class to hold all session data
 * 
 */

import java.util.*;
import java.io.*;

public class SessionManager implements Serializable {
	
	private static SessionManager instance = new SessionManager();
	
	private ArrayList<? extends User> sessionList;
	private ArrayList<Like> likeTable;
	private ArrayList<Match> matchTable;
	private ArrayList<Listing> listings;
	private ArrayList<Seeker> seekers;
	private User sessionUser;
	
	public static SessionManager getInstance(){
		if(instance == null)
			return new SessionManager();
		else
			return instance;
	}
	
	private SessionManager(){
		this.sessionList 	= new ArrayList<>();
		this.likeTable 		= new ArrayList<>();
		this.listings		= new ArrayList<>();
		this.seekers		= new ArrayList<>();
		this.matchTable		= new ArrayList<>();
		this.sessionUser	= null;

		this.readListingsDb();
		this.readSeekersDb();
		this.readLikeTableDb();
		//this.readMatchTableDb();
	}
	
	public void init(){

	}
	
	public void addUser(Listing user){
		listings.add((Listing)user);
		writeListingDb();
	}
	
	public void addUser(Seeker user){
		seekers.add((Seeker) user);
		writeSeekerDb();	
	}
	
	
	public void addMatch(Match match){
		matchTable.add(match);
	}
	
	public void refreshListing(){
		listings = new ArrayList<>();
	}
	
	public void refreshSeekers(){
		seekers = new ArrayList<>();
	}
	
	public void addListing(Listing l){
		listings.add(l);
	}
	
	public void addSeeker(Seeker s){
		seekers.add(s);
	}
	
	public void writeMatchTableDb(){
		try {
			File matchDb			= new File("match.db");
			
			matchDb.createNewFile();
			
			FileOutputStream fos	= new FileOutputStream("match.db");
			ObjectOutputStream oos	= new ObjectOutputStream(fos);
			
			oos.writeObject(this.matchTable);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void readMatchTableDb(){
		try {
			File matchDb 				= new File("match.db");
			matchDb.createNewFile(); // creates new file if doesn't exist, does nothing otherwise
			
			FileInputStream fis			= new FileInputStream("match.db");
			ObjectInputStream ois 		= new ObjectInputStream(fis);
			
			ArrayList<Match> readcase	= (ArrayList<Match>) ois.readObject();
			
			this.matchTable = readcase;
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void writeLikeTableDb(){
		
		try{
			File likeDb					= new File("like.db");
			likeDb.createNewFile();
			
			FileOutputStream	fos			= new FileOutputStream("like.db");
			ObjectOutputStream oos		= new ObjectOutputStream(fos);
			
			oos.writeObject(this.likeTable);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void readLikeTableDb(){
		try {
			File likeDb					= new File("like.db");
			likeDb.createNewFile();
			
			FileInputStream	fis			= new FileInputStream("like.db");
			ObjectInputStream ois		= new ObjectInputStream(fis);
						
			ArrayList<Like> readcase	= (ArrayList<Like>) ois.readObject();
			
			this.likeTable = readcase;
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void writeSeekerDb(){
		try {
			File seekerDb 			= new File("seekers.db");
			
			seekerDb.createNewFile(); // creates new file if doesn't exist, does nothing otherwise
			
			FileOutputStream fos 	= new FileOutputStream("seekers.db");
			ObjectOutputStream oos 	= new ObjectOutputStream(fos);
			
			oos.writeObject(seekers);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void writeListingDb(){
		try {
			File listingDb 			= new File("listings.db");
			listingDb.createNewFile(); // creates new file if doesn't exist, does nothing otherwise
			
			FileOutputStream fos 	= new FileOutputStream("listings.db");
			ObjectOutputStream oos 	= new ObjectOutputStream(fos);
			
			oos.writeObject(listings);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void readSeekersDb(){

		try {
			File seekerDb 				= new File("seekers.db");
			seekerDb.createNewFile(); // creates new file if doesn't exist, does nothing otherwise
			
			FileInputStream fis			= new FileInputStream("seekers.db");
			ObjectInputStream ois 		= new ObjectInputStream(fis);
			
			ArrayList<Seeker> readcase	= (ArrayList<Seeker>) ois.readObject();
			
			this.seekers = readcase;
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void readListingsDb(){

		try {
			File listingDb 			= new File("listings.db");
			listingDb.createNewFile(); // creates new file if doesn't exist, does nothing otherwise
			
			FileInputStream fis		= new FileInputStream("listings.db");
			ObjectInputStream ois 	= new ObjectInputStream(fis);
			
			this.listings			= (ArrayList<Listing>) ois.readObject();
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}

	public ArrayList<Like> getLikeTable() {
		return likeTable;
	}

	public void setLikeTable(ArrayList<Like> likeTable) {
		this.likeTable = likeTable;
	}

	public ArrayList<Listing> getListings() {
		//System.out.println(listings.size());
		return listings;
		
		
	}

	public void setListings(ArrayList<Listing> listings) {
		this.listings = listings;
	}

	public ArrayList<Seeker> getSeekers() {
		return seekers;
	}

	public void setSeekers(ArrayList<Seeker> seekers) {
		this.seekers = seekers;
	}
	
	
	public ArrayList<? extends User> getSessionList() {
		return sessionList;
	}

	public void setSessionList(ArrayList<User> sessionList) {
		this.sessionList = sessionList;
	}

	public ArrayList<Match> getMatchTable() {
		return matchTable;
	}

	public void setMatchTable(ArrayList<Match> matchTable) {
		this.matchTable = matchTable; 
	}

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}

	public static void setInstance(SessionManager instance) {
		SessionManager.instance = instance;
	}

	public boolean checkLogin(String email, String password){
		for(Seeker s:seekers){
			if(s.getEmail().equals(email) && s.getPassword().equals(password)){
				this.sessionUser = s;
				this.sessionList = listings;
				return true;
			}				
		}
		
		for(Listing l:listings){
			if(l.getEmail().equals(email) && l.getPassword().equals(password)){
				this.sessionUser = l;
				this.sessionList = seekers;
				return true;
			}
		}
		
		return false;
	}
	
	public void addToLikeTable(Like like){
		likeTable.add(like);
		writeLikeTableDb();
	}
	
	public boolean checkMatch(User liker, User likee){
		for(Like l:likeTable){
			if(l.getLiker().equals(likee) && l.getLikee().equals(liker)){
				//System.out.println(l.getLiker().getName());
				//System.out.println(l.getLikee().getName());
				writeMatchTableDb();
				return true;
			}
		}
		return false;
	}
	
	public void clearLikeTable(){
		likeTable = new ArrayList<>();
	}
	
	public void clearMatchTable(){
		matchTable = new ArrayList<>();
	}
	
}
