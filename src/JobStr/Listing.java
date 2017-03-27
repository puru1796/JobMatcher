package JobStr;

import java.util.*;
import java.io.*;

public class Listing extends User implements Serializable{
	private String name;
	private String jobDescription;
	private String skillsRequired;
	private String jobTitle;
	private int expRequired;
	private String email;
	private String password;
	private String education;
	
	public Listing(String name, String jobDescription, String skillsRequired, String jobTitle, int expRequired, String email, String password, String education){
		this.name 			= name;
		this.jobDescription = jobDescription;
		this.skillsRequired = skillsRequired;
		this.jobTitle		= jobTitle;
		this.expRequired	= expRequired;
		this.email			= email;
		this.password		= password;
		this.education		= education;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getExpRequired() {
		return expRequired;
	}

	public void setExpRequired(int expRequired) {
		this.expRequired = expRequired;
	}
	

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void outputCardListing(){
		System.out.print("\nName: ");
		System.out.println(this.name);
		
		System.out.print("Job Title: ");
		System.out.println(this.jobTitle);
		
		System.out.print("Job Description: ");
		System.out.println(this.jobDescription);
		
		System.out.print("Experience required: ");
		System.out.println(this.expRequired);
		
		System.out.print("Skills required: ");
		System.out.println(this.skillsRequired);
	}
	
	public void outputCardInViewMatches(){
		System.out.print("\nName: ");
		System.out.println(this.name);
		
		System.out.print("Job Title: ");
		System.out.println(this.jobTitle);
		
		System.out.print("Job Description: ");
		System.out.println(this.jobDescription);
		
		System.out.print("Experience required: ");
		System.out.println(this.expRequired);
		
		System.out.print("Skills required: ");
		System.out.println(this.skillsRequired);
		
		System.out.print("Email: ");
		System.out.println(this.email);
	}
	
	public void outputSuggestions(){
		System.out.print("\nName: ");
		System.out.println(this.name);
		
		System.out.print("Job Title: ");
		System.out.println(this.jobTitle);
		
		System.out.print("Job Description: ");
		System.out.println(this.jobDescription);
		
		System.out.print("Experience required: ");
		System.out.println(this.expRequired);
		
		System.out.print("Skills required: ");
		System.out.println(this.skillsRequired);
		
		System.out.print("Email: ");
		System.out.println(this.email);
	}

	@Override
	public String toString(){
		return "[Name: " + name + ", Job description: " + jobDescription + ", Job title: " + jobTitle + ", Experience required: " + expRequired + ", Skills required: " + skillsRequired + "Education: " + this.education +", Email: " + email + ", Password: " + password +" ]";
	}
}
