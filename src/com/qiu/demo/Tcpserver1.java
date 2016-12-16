package com.qiu.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcpserver1 {
	
	public static final int PORT_SERVER = 10086;
	private ServerSocket serverSocket = null;
	
	public void start(){
		
		try {
			//����serversocket��
			serverSocket = new ServerSocket(PORT_SERVER);
//			serverSocket.setSoTimeout(600000);
			System.out.println("������Ѿ��������˿�"+PORT_SERVER);
			
			/*
			 * ����
			 */
			//��������
			Socket client = serverSocket.accept();
			System.out.println("�ͻ������ӷ����");
			
		    OutputStream os = client.getOutputStream();
		    
		    String path = "c:/mytxt/aaa.mp3";
		    File file = new File(path);
		    FileInputStream fis = new FileInputStream(file);
		    
		    long total = file.length();
			System.out.println("total:" + total + "Byte");
		    long per = 0;
			float percent = 0;
		   
		    byte[] b = new byte[1024];
		    int len = 0;
		    
		    while ((len = fis.read(b)) != -1) {
		    	per += len;
				os.write(b);
				
				percent = (float)per/total;
				
				percent = percent *100;
				
				System.out.println("server data:"+(int)percent+"%");	
			
		    }
		    
		    fis.close();
		    client.close();
		    serverSocket.close();
			
		    System.out.println("������ѹر�");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
