// Jeffrey Almanzar

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

public class Main {

	private static Socket mySocket;
	
	public static void main(String[] args) {

		mySocket = new Socket(64000);
		DatagramPacket inPacket = null;
		HashMap<String, ChatWindow> mapIpAddressToChatWindow = new HashMap<>();
		
		StartChat connect = new StartChat();
		connect.startWindow(mySocket, mapIpAddressToChatWindow);
		
		while (true){
		
			inPacket = mySocket.receive();
			
			if(inPacket != null) {
				
				byte[] inBuffer = inPacket.getData();
				String inMessage = new String(inBuffer);
				
				InetAddress senderAddress = inPacket.getAddress();
				int senderPort = inPacket.getPort();
				
				if(mapIpAddressToChatWindow.containsKey(senderAddress.getHostAddress())) {
					ChatWindow win = mapIpAddressToChatWindow.get(senderAddress.getHostAddress());
					win.attachMessage(inMessage);
					
				}else {
					ChatWindow newW = new ChatWindow(senderAddress.getHostAddress(),senderPort, inMessage, mySocket);
					newW.attachMessage(inMessage);
					mapIpAddressToChatWindow.put(senderAddress.getHostAddress(), newW); 
				}			
			}
		}	
	}

}