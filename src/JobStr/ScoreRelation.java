package JobStr;

public class ScoreRelation implements Comparable<ScoreRelation> {
	private User user1;
	private User user2;
	private int score;
	
	public ScoreRelation(User u1, User u2, int score)  {
		this.user1 = u1;
		this.user2 = u2;
		this.score = score;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public int compareTo(ScoreRelation other){
		return other.getScore() - this.score;
	}
	
	@Override
	public String toString(){
		return "User1 Name: " + user1.getName() + " User2 Name: " + " " + user2.getName() + " Score:" + score;
	}
	
}
