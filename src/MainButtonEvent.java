import java.util.EventObject;

public class MainButtonEvent extends EventObject {
	
	
	private String btnPressed;
	
  public MainButtonEvent(Object source,String btnPressed) {
		super(source);
		this.btnPressed = btnPressed;
		// TODO Auto-generated constructor stub
	}

public String getBtnPressed() {
	return btnPressed;
}

public void setBtnPressed(String btnPressed) {
	this.btnPressed = btnPressed;
}



}
