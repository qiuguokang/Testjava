package com.qiu.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 */
public class TcpClient {
	
	public static final int PORT_SERVER = 9510;
	public Socket client = null;
	
	public void start(){
		
		
		//����socket
		try {
			InetAddress address = InetAddress.getLocalHost();
			client = new Socket(address,PORT_SERVER);
			
			System.out.println("�ͻ���������");
			
		    InputStream is = client.getInputStream();
		    byte[] b = new byte[1024];
		    
		    System.out.println("�ͻ��˽�������");
		    int len = is.read(b);
		    
		    String data = new String(b, 0, len);
		    
		    System.out.println("�յ�������:"+data);
		    
		    //�ر�
		    client.close();
		    System.out.println("�ͻ����ѹر�");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
