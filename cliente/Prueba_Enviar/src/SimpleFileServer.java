import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileServer{

    public final static int SOCKET_PORT = 8080;  // you may change this
    String workingDir = System.getProperty("user.dir");
    public final static String FILE_TO_SEND = "/home/fmurillom/Documents/Tec/Prueba_Enviar/prueba.xml";

    public static void main (String [] args ) throws IOException {
        SimpleFileServer server = new SimpleFileServer();
        server.sendFile(8080);
    }

    public void sendFile(int port) throws IOException{
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
                    sock = new Socket("localhost", port);
                    System.out.println("Accepted connection : " + sock);
                    // send file
                    File myFile = new File (FILE_TO_SEND);
                    byte [] mybytearray  = new byte [(int)myFile.length()];
                    fis = new FileInputStream(myFile);
                    bis = new BufferedInputStream(fis);
                    bis.read(mybytearray,0,mybytearray.length);
                    os = sock.getOutputStream();
                    System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
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

    public void recieveFile()throws IOException{
        InputStream os = null;
        ServerSocket servsock = null;
        Socket sock = null;
        try {
            while (true) {
                System.out.println("Waiting...");
                try {
                    servsock = new ServerSocket(8081);
                    sock = servsock.accept();
                    System.out.println("Accepted connection : " + sock);
                    // send file
                    InputStream stream = sock.getInputStream();
                    byte[] data = new byte[1];
                    int count = 0;
                    FileOutputStream file = new FileOutputStream("/home/fmurillom/Documents/Tec/Prueba_Enviar/recieved.mp3");
                    while(true){
                        count = stream.read(data);
                        file.write(data);
                        if(count == -1){
                            file.close();
                            break;
                        }
                        System.out.println(count);
                    }
                    break;
                }
                finally {
                    if (os != null) os.close();
                    if (sock!=null) sock.close();
                }
            }
        }
        finally {
            if (servsock != null) servsock.close();
        }
    }
}