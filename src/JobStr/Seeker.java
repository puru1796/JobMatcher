package JobStr;

import java.util.*;
import java.io.*;

public class Seeker extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String education;
	private int workExp;
	private String skills;
	private String email;
	private String password;
	
	public Seeker(String name, String education, int workExp, String skills, String email, String password){
		this.name		= name;
		this.education	= education;
		this.workExp	= workExp;
		this.skills		= skills;
		this.email		= email;
		this.password	= password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getWorkExp() {
		return workExp;
	}

	public void setWorkExp(int workExp) {
		this.workExp = workExp;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
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
	
	public void outputCardListing(){
		System.out.print("\nName: ");
		System.out.println(this.name);
		
		System.out.print("Education: ");
		System.out.println(this.education);
		
		System.out.print("Work Experience: ");
		System.out.println(this.workExp);
		
		System.out.print("Skills: ");
		System.out.println(this.skills);
	}
	
	public void outputCardInViewMatches(){
		System.out.print("\nName: ");
		System.out.println(this.name);
		
		System.out.print("Education: ");
		System.out.println(this.education);
		
		System.out.print("Work Experience: ");
		System.out.println(this.workExp);
		
		System.out.print("Skills: ");
		System.out.println(this.skills);
		
		System.out.print("Email: ");
		System.out.println(this.email);
	}
	
	public void outputSuggestions(){
		System.out.print("\nName: ");
		System.out.println(this.name);
		
		System.out.print("Education: ");
		System.out.println(this.education);
		
		System.out.print("Work Experience: ");
		System.out.println(this.workExp);
		
		System.out.print("Skills: ");
		System.out.println(this.skills);
		
		System.out.print("Email: ");
		System.out.println(this.email);
	}
	
	@Override
	public String toString(){
		return "[Name: " + name + ", Education: " + education + ", WorkExp: " + workExp + ", Skills: " + skills + "Education: " + education + ", Email: " + email + ", Password: " + password +" ]"; 
	}
	
}
