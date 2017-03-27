package JobStr;
import java.io.*;

public class Like implements Serializable {
	private User liker;
	private User likee;
	
	public Like(User liker, User likee){
		this.liker		= liker;
		this.likee		= likee;
	}

	public User getLiker() {
		return liker;
	}

	public void setLiker(User liker) {
		this.liker = liker;
	}

	public User getLikee() {
		return likee;
	}

	public void setLikee(User likee) {
		this.likee = likee;
	}
	
	@Override
	public String toString(){
		return "[Liker: " + liker.getName() + ", Likee: " + likee.getName() + " ]";
	}
}
