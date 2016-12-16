package com.qiu.demo;

import java.net.InetAddress;
import java.net.Socket;

public class TcpClient1 {
	
	 Socket client = null;
	
	public static void main(String[] args) {
		final int PORT_SERVER =Integer.valueOf(args[2]);
		System.out.println("µÚÒ»¾ä");
		for (String string : args) {
			System.out.println(string);
		}
	}
	
	public void end(){
		
	}

}
