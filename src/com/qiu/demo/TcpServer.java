package com.qiu.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class TcpServer {
	
	public static final int PORT_SERVER = 9510;
	private ServerSocket serversocket = null;
	
	public void strat(){
		
		String data = "hello,I am Server";
		
		try {
			//建立ServerSocket
			serversocket = new ServerSocket(PORT_SERVER);
			
			System.out.println("服务端已启动,端口："+PORT_SERVER);
			/*
			 * 操作
			 */
			//建立链接
			Socket client = serversocket.accept();
			
			System.out.println("server accept client");
			
		    OutputStream os = client.getOutputStream();
		    
		    os.write(data.getBytes());
		    
		    System.out.println("server data:"+data);
		    
		    //关闭
		    client.close();
		    serversocket.close();
		    
		    System.out.println("服务端已关闭");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
