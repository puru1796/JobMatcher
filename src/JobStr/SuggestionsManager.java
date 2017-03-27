package JobStr;
import java.util.*;

public class SuggestionsManager {

	private User sessionUser;
	private SessionManager sessionManager;
	
	private static final int PHD = 5;
	private static final int MSC = 4;
	private static final int BSC = 3;
	private static final int DIP = 2;
	private static final int HS = 1;
	private static final int NA = 0;
	
	public SuggestionsManager(){
		sessionManager		= SessionManager.getInstance();
		sessionUser		 	= sessionManager.getSessionUser();
	}
	
	
	
	//Here user is seeker
	public ArrayList<Listing> rankSuggestions(Seeker seeker) throws Exception{
		ArrayList<Listing> listings = sessionManager.getListings();
		//System.out.println(listings.size());
		ArrayList<ScoreRelation> scoreList = new ArrayList<ScoreRelation>();
		
		try {
			for(Listing listing:listings){
				int skillScore, eduScore, workExScore;
				
				String curSkill = this.ElimnateGenericWords(seeker.getSkills());
				String curEd = this.ElimnateGenericWords(seeker.getEducation());
				
				skillScore = this.scoreSkills(curSkill, this.ElimnateGenericWords(listing.getSkillsRequired()));
				//System.out.println(skillScore);
				workExScore = this.getWorkExperienceScore(listing.getExpRequired(), seeker.getWorkExp() );
				/*System.out.println(workExScore);
				System.out.println(curEd);
				System.out.println(seeker.getEducation());*/
				
				eduScore = this.getEducationScore(curEd.toUpperCase(), listing.getEducation());
				
				int score = skillScore + workExScore + eduScore;
				scoreList.add(new ScoreRelation(seeker, listing, score));
			}
		} catch(Exception e){
			throw new Exception(e);
		}
		
		Collections.sort(scoreList);
		
		/*
		System.out.println("dbg:");
		for(ScoreRelation sr:scoreList){
			System.out.println(sr.toString());
		}
		*/
		
		ArrayList<Listing> result = new ArrayList<Listing>();
		
		result.add((Listing)scoreList.get(0).getUser2());
		result.add((Listing)scoreList.get(1).getUser2());
		result.add((Listing)scoreList.get(2).getUser2());
		
		return result;
	}
	
	//Here user is employer
	public ArrayList<Seeker> rankSuggestions(Listing listing) throws Exception{
		ArrayList<Seeker> seekers = sessionManager.getSeekers();
		//System.out.println(seekers.size());
		
		ArrayList<ScoreRelation> scoreList = new ArrayList<ScoreRelation>();
		
		try {
			for(Seeker seeker:seekers){
				int skillScore, eduScore, workExScore;
				//System.out.println(seeker.getName());
				String curSkill = this.ElimnateGenericWords(listing.getSkillsRequired());
				String curEd = this.ElimnateGenericWords(listing.getEducation());
				
				skillScore = this.scoreSkills(curSkill, this.ElimnateGenericWords(seeker.getSkills()));
				//System.out.println(skillScore);
				workExScore = this.getWorkExperienceScore(listing.getExpRequired(), seeker.getWorkExp());
				//System.out.println(workExScore);
				eduScore = this.getEducationScore(curEd.toUpperCase(), listing.getEducation());
				//System.out.println(eduScore);
				int score = skillScore + workExScore + eduScore;
				//System.out.println(score);
				
				scoreList.add(new ScoreRelation(listing, seeker,score));
				
			}
		} catch(Exception e){
			throw new Exception(e);
		}
		
		Collections.sort(scoreList);
		
		
		ArrayList<Seeker> result = new ArrayList<>();
		
		result.add((Seeker)scoreList.get(0).getUser2());
		result.add((Seeker)scoreList.get(1).getUser2());
		result.add((Seeker)scoreList.get(2).getUser2());
		
		return seekers;
		
	}
	
	public int getWorkExperienceScore(int seeker, int listing) throws Exception{
		int score = 0;
		int workExpSeeker = seeker;
		int workExpReqListing = listing;
		int difference = workExpReqListing - workExpSeeker;
		if(workExpSeeker == -1 || workExpReqListing == -1){
			throw new Exception("Invalid Input");
		}
		else if(difference < 2){
			return 20;
		}else if(difference >= 2 && difference < 4){
			return 15;
		}else if(difference >= 4 && difference < 8){
			return 5;
		}
		return 0;
	}
	
	
	public int getEducationScore(String Education, String Requirment) throws Exception{
		int score = 0;
		int edu_num = getDegreeValue(Education);
		int req_num = getDegreeValue(Requirment);
		

		
		if(edu_num - req_num == 1){
			score = 5;
		}
		else if(edu_num == req_num && edu_num != -1){
			score = 10;
		}
		else if(edu_num == -1 || req_num == -1){
			score = -1;
		}
		else{
			score = 0;
		}

		// dbg
		//System.out.println("Education: " + Education + " Requirement: " + Requirment);
		//System.out.println("Score: " + score);
		
		if(score == -1) throw new Exception("Invalid input");
		
		return score;	
	}
	
	
	public int getSkillsScore(Seeker seeker){
		String curSkill = this.ElimnateGenericWords(seeker.getSkills());
		
		ArrayList<Listing> listings = sessionManager.getListings();
		
		int score = 0;
		for(Listing listing:listings){
			score += scoreSkills(curSkill, this.ElimnateGenericWords(listing.getSkillsRequired()));
		}
		
		return score;		
	}
	
	public int getSkillsScore(Listing listing){
		String curSkill = this.ElimnateGenericWords(listing.getSkillsRequired());
		
		ArrayList<Seeker> seekers = sessionManager.getSeekers();
		
		int score = 0;
		for(Seeker seeker:seekers){
			score += scoreSkills(curSkill, this.ElimnateGenericWords(seeker.getSkills()));
		}
		
		return score;
	}
	
	 public int scoreSkills(String uoString, String utString){
         
	        String[] uoSplit = uoString.split("\\s+");
	        String[] utSplit = utString.split("\\s+");
	       
	        double inter = 0;
	        for(String s:uoSplit){
	             inter += generateSkillScore(s, utSplit);
	        }
	       
	        int score;
	        score = (int)((inter/utSplit.length) * 20);
	       
	        return score;
	    }
	   
	    public double generateSkillScore(String skill, String[] skillList){
	        int score = 0;
	       
	        for(String s:skillList){
	            if(s.contains(skill)){
	                if(s.length() == skill.length())
	                    return 1;
	                else
	                    return 0.5;
	            }
	        }
	       
	        return 0;
	    }
	    
	    public String ElimnateGenericWords(String s) {

			String[] generic_words= {"in", "on","used","use","work","worked","competent","experienced","experience","fluent",
			                          "organized","developed","elimnated","executed","enforced","merged","deployed","planned",
			                          "tested","analyzed","develop","development","deploy","planning","review","reviewed",
			                          "explored","explore","built","build","compute","computed","converted","debug","debugged",
			                          "programmed","scripted","scripting","script","modeled","model","study","studied","utilized",
			                          "the","this","that","language","tool","framework","create","created","specialized","hard-working",
			                          "level-headed", "processing","self-driven","oriented","hard","working","realistic",
			                          "passionate","level","headed","self","motivated","open","minded","launched","launch",
			                          "designed","design","distribute","engineered","at","upon","interest","interested",
			                          "proficient","intermediate","knowledge","upon","maintain","maintained","review","develop",
			                          "i","am","a","aware","inspire","inspired","driven","inside","outside","driven","drive",
			                          "an","at","use","used","work","worked","know","of","the","of","to","and","a","in","is","it","you","that","he","was","for","on","are","with","as","i"
			                          ,"and","as","well","related","languages","tasks","task","field","very","human","being",
			                          "knowledgeable"};
			
			List <String> word_list = new ArrayList<String>(Arrays.asList(generic_words));

			String m = s.toLowerCase();
			String[] mArray = m.split(" ");
			List<String> split_sentence = new ArrayList<String>(Arrays.asList(mArray));
			
			split_sentence.removeAll(word_list);
			
			String new_s = split_sentence.toString().replaceAll("(^\\[|\\]$)", "");;
			new_s = new_s.replaceAll("[,]", "");
			//new_s.replace("[", "");
			//new_s.replace("]", "");
			
			
			return new_s;
		}
	    
		public int getDegreeValue(String Education){
			String edu = Education;
			int num = 0;
			
			if(edu.equals("PHD")){
				num = PHD;
			}
			else if(edu.equals("MSC")){
				num = MSC;
			}
			else if (edu.equals("BSC")){
				num = BSC;
			}
			else if(edu.equals("HS")){
				num = HS;
			}
			else if(edu.equals("DIP")){
				num = DIP;
			}
			else if(edu.equals("NA")){
				num = NA;
			}
			else{
				num = -1;
			}
						
			return num;
		}
}
