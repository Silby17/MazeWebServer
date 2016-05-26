import java.io.*;
import java.net.Socket;

public class ServerConnectionManager {
    private Socket socket;
    private String IP;
    private int port;
    private boolean connected;


    /*********************************************************************
     * This method is will set the members
     * @param ip - the IP address
     * @param port - the port to listen to
     ********************************************************************/
    public ServerConnectionManager(String ip, int port){
        this.IP = ip;
        this.port = port;
        this.connected = false;
    }


    /**********************************************************************
     * This Method will connect to the Maze Server that was written in C#
     *********************************************************************/
    public void connect(){
        BufferedReader in = null;
        try{
            socket = new Socket(this.IP, this.port);
            connected = true;
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            char[] connectionMsg = new char[1024];
            in.read(connectionMsg);
            String msg = new String(connectionMsg);
            System.out.println("Connection with Server Successful");
        } catch (IOException e ){
            System.out.println("Connection with server Failed");
            e.printStackTrace();
        }
    }


    /*********************************************************************
     * This method will be used to send requests to the C# Code
     * @param msg the command to send to the server
     * @return the response from server
     *********************************************************************/
    public String sendToServer(String msg){
        PrintWriter out = null;
        BufferedReader in = null;
        String toSend;
        String rec = "";
        try{
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(msg);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            char[] received  = new char[1024];
            in.read(received);
            rec = new String(received);
        }catch (IOException e){
            e.printStackTrace();
        }
        toSend = msg.toString();
        return rec;
    }
}