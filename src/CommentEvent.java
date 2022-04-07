import java.util.EventObject;

public class CommentEvent extends EventObject {
	
	private String Comment;
	
	public CommentEvent(Object Event,String Comment){
		super(Event);
		
		this.Comment = Comment;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

}
