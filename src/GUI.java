import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GraphicsConfiguration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI {
	
	static GraphicsConfiguration gc;
	
	public static void main(String[] args){
		startWindow();
		startWindow();
		
	}
	
	public static void startWindow() {
		JTextField textfield1;
		JTextField textfield2;
		JTextField textfield3;
		JTextField textfield4;
		JTextField textfield5;
		
		JFrame frame= new JFrame(gc);	
		frame.setTitle("Instant Messenging");
		frame.setSize(400, 200);
		
		frame.getContentPane().setLayout(new FlowLayout());
		
		JLabel labe = new JLabel();
		labe.setText("IP Address:");
		JLabel labe2 = new JLabel();
		labe2.setText("Port:");
		
		textfield1 = new JTextField("",4);
		textfield2 = new JTextField("",4);
		textfield3 = new JTextField("",4);
		textfield4 = new JTextField("",4);
		textfield5 = new JTextField("",4);
		
		JButton enterBtn = new JButton("Send"); 
		
		frame.getContentPane().add(labe);
		frame.getContentPane().add(textfield1);
		frame.getContentPane().add(textfield2);
		frame.getContentPane().add(textfield3);
		frame.getContentPane().add(textfield4);
		frame.getContentPane().add(labe2);
		frame.getContentPane().add(textfield5);
		frame.getContentPane().add(enterBtn);
		
		

		enterBtn.addActionListener(
				new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String ip = textfield1.getText()+"-"+textfield2.getText()+"-"+textfield3.getText()+"-"+ textfield4.getText();
						System.out.println(ip);
						handleClick(e);
					}
                }
	   );

		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
//	public void messageWindow() {
//		JFrame mw = new JFrame("My title");
//		mw.setSize(200,200);
//		mv.setVisible(true);
//		mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
	
	public static void handleClick(ActionEvent e) {
		System.out.println("It worked");
	}
}
