import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
public class GUI {
	
	static GraphicsConfiguration gc;
	static Container container;
	
	public static void main(String[] args){
		//startWindow();
		messageWindow();
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
						String port = textfield5.getText();
						messageWindow();
						
					}
                }
	   );

		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void messageWindow() {
		JFrame frame = new JFrame("My title");
	   JTextField messageBar = new JTextField(20);
		JPanel buttonPanel = new JPanel(new GridLayout(1, 0)); 
	    JTextPane pane = new JTextPane();
	    pane.setPreferredSize(new Dimension(350, 425));
	  
	    messageBar.addKeyListener(
	        new KeyListener() {
	        	
	        	public void keyTyped(KeyEvent e) {
	        	        
	        	}
	        	
		        /** Handle the key released event from the text field. */
		        public void keyReleased(KeyEvent e) {
		        	if(e.getKeyCode() == KeyEvent.VK_ENTER) {
		  		      // Enter was pressed. Your code goes here.
		  			  System.out.println("Enter");
		  		   }
		        }

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
	    });

	    buttonPanel.add( messageBar); 
	    frame.add(pane, BorderLayout.NORTH);
	    frame.add(buttonPanel,  BorderLayout.CENTER);
	    
	    frame.pack();
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	 

}
