package com.qiu.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����
 */
public class TcpServer {
	
	public static final int PORT_SERVER = 9510;
	private ServerSocket serversocket = null;
	
	public void strat(){
		
		String data = "hello,I am Server";
		
		try {
			//����ServerSocket
			serversocket = new ServerSocket(PORT_SERVER);
			
			System.out.println("�����������,�˿ڣ�"+PORT_SERVER);
			/*
			 * ����
			 */
			//��������
			Socket client = serversocket.accept();
			
			System.out.println("server accept client");
			
		    OutputStream os = client.getOutputStream();
		    
		    os.write(data.getBytes());
		    
		    System.out.println("server data:"+data);
		    
		    //�ر�
		    client.close();
		    serversocket.close();
		    
		    System.out.println("������ѹر�");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
