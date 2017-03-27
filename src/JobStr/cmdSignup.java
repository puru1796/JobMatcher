package JobStr;
import java.util.*;
public class cmdSignup implements Command {

	private SessionManager sessionManager;

	
	private Scanner in;
	private ArrayList<String> jobs = new ArrayList<String>();
	
	
	@Override
	public void execute(String[] cmdParts) throws Exception { 
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		jobs.add("PHD");
		jobs.add("MSC");
		jobs.add("BSC");
		jobs.add("DIP");
		jobs.add("HS");
		jobs.add("NA"); 
		
		sessionManager = SessionManager.getInstance(); 
		
		if(cmdParts[1].equals("employer")){
			try {
				sessionManager.addUser(signupListing());
				System.out.println("user created");
			} catch (Exception e) {
				throw new Exception("Invalid Input");
			}
		} else if(cmdParts[1].equals("seeker")){
			try{
				sessionManager.addUser(signupSeeker());
				System.out.println("user created");

			}catch(Exception e){
				throw new Exception("Invalid Input");
			}
		}else{
			throw new Exception("Invalid Input");
		}
	}
	
	private Seeker signupSeeker() throws Exception{
		String name;
		String education;
		int workExp;
		String skills;
		String email;
		String password;
		
		System.out.println("Enter name: ");
		name = in.nextLine();
		
		System.out.println("Enter education (PHD, MSC, BSC, DIP, HS, NA): ");
		education = in.nextLine();
		if(!jobs.contains(education)){
			throw new Exception("Invalid Input");
		}
		
		System.out.println("Enter work experience (In years pls, thank you): ");
		workExp = in.nextInt();
		if(workExp < 0){
			throw new Exception("Invalid Input");
		}
		in.nextLine();
		
		System.out.println("Enter skills: ");
		skills = in.nextLine();
		
		System.out.println("Enter email: ");
		email = in.nextLine();
		
		System.out.println("Enter password: ");
		password = in.nextLine();
		
		return new Seeker(name, education, workExp, skills, email, password);
		
		
	}
	
	private Listing signupListing() throws Exception{
		String name;
		String jobDescription;
		String skillsRequired;
		String jobTitle;
		int expRequired = 0;
		String email;
		String password;
		String education;
		
		System.out.println("Enter name: ");
		name = in.nextLine();
		
		System.out.println("Enter job title");
		jobTitle = in.nextLine();
		
		System.out.println("Enter job description: ");
		jobDescription = in.nextLine();
		
		System.out.println("Enter skills required: ");
		skillsRequired = in.nextLine();
		
		System.out.println("Enter experience required (in years): ");
		expRequired = in.nextInt();
		if(expRequired < 0){
			throw new Exception("Invalid Input");
		}
		in.nextLine();
				
		System.out.println("Enter education required (PHD, MSC, BSC, DIP, HS, NA): ");
		education = in.nextLine();
		if(!jobs.contains(education)){
			throw new Exception("Invalid Input");
		}
		
		System.out.println("Enter email: ");
		email = in.nextLine();
		
		System.out.println("Enter password: ");
		password = in.nextLine();
		
		
		return new Listing(name, jobDescription, skillsRequired, jobTitle, expRequired, email, password, education);
	}
}
