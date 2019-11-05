// Jeffrey Almanzar

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ChatWindow {
	
	static GraphicsConfiguration gc;
	static Container container;
	JFrame frame;
	JPanel bottomPanel;
	JTextPane pane;
	JScrollPane scrollablePane;
	JTextField messageBar;
	JButton send;
	
	public  ChatWindow(String ip, int port, String msg, Socket mySocket) {
		
	    frame = new JFrame("IP: " + ip + "            Port: " + port);
	    messageBar = new JTextField(20);
		bottomPanel = new JPanel(new FlowLayout());
		send = new JButton("Send"); 
	    pane = new JTextPane();
	    pane.setEditable(false);
	    pane.setPreferredSize(new Dimension(400, 400));
	    
	    messageBar.addKeyListener(
	        new KeyListener() {
	        	
	        	@Override
	        	public void keyTyped(KeyEvent e) {}
	        	@Override
				public void keyPressed(KeyEvent e) {}
	        	
	        	@Override
		        public void keyReleased(KeyEvent e) {
		        	if(e.getKeyCode() == KeyEvent.VK_ENTER) {
		        		
		        		pane.setText(pane.getText() + "Me: \n"+ messageBar.getText() + "\n\n");
		        		sendMessage(mySocket, messageBar.getText(), ip, port );
		        		messageBar.setText("");
		  		   }
		        }	
	    });
	    
	    send.addActionListener(
				new ActionListener() {
						
					public void actionPerformed(ActionEvent e) {
						pane.setText(pane.getText() + "Me: \n"+ messageBar.getText() + "\n\n");
						sendMessage(mySocket, messageBar.getText(), ip, port );
		        		messageBar.setText("");
					}
					
				}
		);
	    
	    scrollablePane = new JScrollPane(pane);
	    scrollablePane.createVerticalScrollBar();
	    scrollablePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    bottomPanel.add(messageBar); 
	    bottomPanel.add(send);
	    frame.add(scrollablePane, BorderLayout.NORTH);
	    frame.add(bottomPanel,  BorderLayout.CENTER);
	    frame.pack();
	    frame.setVisible(true);
	   
	}
	
	public void attachMessage(String message) {
		pane.setText(pane.getText() + "Them: \n" + message + "\n\n");
	}
	
	public void sendMessage(Socket mySocket, String msg, String destinationIp, int port ) {
		try {
			InetAddress destinationAddress = InetAddress.getByName(destinationIp);
			mySocket.send(msg,destinationAddress, port);	
		}catch(UnknownHostException e) {}
	}

}
