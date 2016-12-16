package com.qiu.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 */
public class TcpClient {
	
	public static final int PORT_SERVER = 9510;
	public Socket client = null;
	
	public void start(){
		
		
		//建立socket
		try {
			InetAddress address = InetAddress.getLocalHost();
			client = new Socket(address,PORT_SERVER);
			
			System.out.println("客户端已启动");
			
		    InputStream is = client.getInputStream();
		    byte[] b = new byte[1024];
		    
		    System.out.println("客户端接收数据");
		    int len = is.read(b);
		    
		    String data = new String(b, 0, len);
		    
		    System.out.println("收到的数据:"+data);
		    
		    //关闭
		    client.close();
		    System.out.println("客户端已关闭");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
