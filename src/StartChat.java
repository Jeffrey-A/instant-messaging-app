import java.awt.BorderLayout;
import java.lang.*;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class StartChat {
	
	static GraphicsConfiguration gc;
	static Container container;
	
	public void startWindow(Socket mySocket, HashMap mapIpAddressToChatWindow) {
	JTextField textfield1;
	JTextField textfield2;
	JTextField textfield3;
	JTextField textfield4;
	JTextField textfield5;
	JFrame frame;
	
	
	frame= new JFrame(gc);	
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
	
	JButton enterBtn = new JButton("Open Chat"); 
	JButton close = new JButton("Close all Chat"); 
	
	close.addActionListener(
			new ActionListener() {
					
				public void actionPerformed(ActionEvent e) {
					System.exit(-1);
				}
				
			}
	);
	
	frame.getContentPane().add(labe);
	frame.getContentPane().add(textfield1);
	frame.getContentPane().add(textfield2);
	frame.getContentPane().add(textfield3);
	frame.getContentPane().add(textfield4);
	frame.getContentPane().add(labe2);
	frame.getContentPane().add(textfield5);
	frame.getContentPane().add(enterBtn);
	frame.getContentPane().add(close);

	enterBtn.addActionListener(
			new ActionListener() {
					
				public void actionPerformed(ActionEvent e) {
					
					ChatWindow chatW;
					String destinationIp = textfield1.getText()+"."
					                       +textfield2.getText()+"."+textfield3.getText()+"."
					                       + textfield4.getText();
					
					int port = Integer.parseInt( textfield5.getText());
					
					if(!mapIpAddressToChatWindow.containsKey(destinationIp)) {
						
						chatW = new ChatWindow(destinationIp, port, "", mySocket);
						mapIpAddressToChatWindow.put(destinationIp, chatW);
						
					}	
				}
            }
   );

	frame.pack();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}

}
