package auxiliar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class VG
{
	public static String USER = "";	
	public static int PORT = 8080;
	public static int PORT_to_send = 8081;
	public static String HOST = "192.168.1.11";
	public static String filePath = "";
	
	public static void sendFile(int port, String filePath, String ip) throws IOException
    {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        ServerSocket servsock = null;
        Socket sock = null;
        try {
            //servsock = new ServerSocket(SOCKET_PORT);
            while (true) {
                System.out.println("Waiting...");
                try {
                    sock = new Socket(ip, port);
                    System.out.println("Accepted connection : " + sock);
                    // send file
                    File myFile = new File (filePath);
                    byte [] mybytearray  = new byte [(int)myFile.length()];
                    fis = new FileInputStream(myFile);
                    bis = new BufferedInputStream(fis);
                    bis.read(mybytearray,0,mybytearray.length);
                    os = sock.getOutputStream();
                    System.out.println("Sending " + filePath + "(" + mybytearray.length + " bytes)");
                    os.write(mybytearray,0,mybytearray.length);
                    os.flush();
                    System.out.println("Done.");
                    break;
                }
                finally {
                    if (bis != null) bis.close();
                    if (os != null) os.close();
                    if (sock!=null) sock.close();
                }
            }
        }
        finally {
            if (servsock != null) servsock.close();
        }
    }
	
	
	
	public static void recieveFile()throws IOException
	{
        InputStream os = null;
        ServerSocket servsock = null;
        Socket sock = null;
        try {
            while(true)
            {
                System.out.println("Waiting...");
                try
                {
                    servsock = new ServerSocket(8081);
                    sock = servsock.accept();
                    System.out.println("Accepted connection : " + sock);
                    
                    // send file
                    InputStream stream = sock.getInputStream();
                    byte[] data = new byte[1];
                    int count = 0;
                    FileOutputStream file = new FileOutputStream("src/recieved.xml");
                    
                    while(true)
                    {
                        count = stream.read(data);
                        file.write(data);
                        if(count == -1)
                        {
                            file.close();
                            break;
                        }
                        System.out.println(count);
                    }
                    break;
                }
                finally
                {
                    if (os != null) os.close();
                    if (sock!=null) sock.close();
                }
            }
        }
        finally
        {
            if(servsock != null) servsock.close();
        }
    }

}
