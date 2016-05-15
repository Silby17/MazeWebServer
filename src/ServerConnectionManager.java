import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


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
        try{
            socket = new Socket(this.IP, this.port);
            connected = true;
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
}