import java.io.*;
import java.net.Socket;

public class ServerConnectionManager {
    private Socket socket;
    private String IP;
    private int PORT;
    private boolean connected;



    public ServerConnectionManager(){
        readConfigInfo();
    }


    /**********************************************************************
     * This Method will connect to the Maze Server that was written in C#
     *********************************************************************/
    public void connect(){
        BufferedReader in = null;
        try{
            socket = new Socket(this.IP, this.PORT);
            connected = true;
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            char[] connectionMsg = new char[1024];
            in.read(connectionMsg);
            String msg = new String(connectionMsg);
            System.out.println("Connection with Server Successful");
        } catch (IOException e ){
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


    /*******************************************************************
     * This method will read the IP and PORT from the cinfig.txt file
     * for connection with the server
     ******************************************************************/
    private void readConfigInfo(){
        InputStream in = getClass().getResourceAsStream("config.txt");
        Reader nr = null;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(in));
            IP = br.readLine();
            PORT = Integer.parseInt(br.readLine());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}