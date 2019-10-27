import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class GUI {
	
	static GraphicsConfiguration gc;
	
	public static void main(String[] args){
		startWindow();
		
	}
	
	public static void startWindow() {
		
		JFrame frame= new JFrame(gc);	
		frame.setTitle("Instant Messenging");
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
