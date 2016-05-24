import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;


public class ServerConnectionManager {
    private Socket socket;
    private String IP;
    private int port;
    private boolean connected;


    public ServerConnectionManager(){}

    public ServerConnectionManager(String ip, int port){
        this.IP = ip;
        this.port = port;
        this.connected = false;
        connect();
    }


    private void connect(){
        BufferedReader in = null;
        try{
            socket = new Socket(this.IP, this.port);
            connected = true;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            char[] connectionMsg = new char[1024];
            in.read(connectionMsg);
            String msg = new String(connectionMsg);
            System.out.println("Connection with Server Successful");
        } catch (IOException e ){
            System.out.println("Connection with server Failed");
            e.printStackTrace();
        }


    }

    public boolean getConnected(){
        return this.connected;
    }

    public void setConnected(boolean bool){
        this.connected = bool;
    }

    public String sendToServer(String msg){
        System.out.println("To be sent to Server: " + msg);
        PrintWriter out = null;
        BufferedReader in = null;
        String toSend;
        String rec = "";


        try{
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(msg);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            char[] recieved = new char[1024];
            in.read(recieved);
            rec = new String(recieved);
            System.out.println(rec);
        }catch (IOException e){
            e.printStackTrace();
        }
        toSend = msg.toString();

        return rec;
    }
}