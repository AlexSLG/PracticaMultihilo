import java.net.ServerSocket;
import java.net.Socket;
public class ServerMain {
    private int clientnumber = 1;
    public ServerMain() throws Exception {
        ServerSocket server_socket = new ServerSocket(2020);
        System.out.println("Servidor iniciado en 192.168.10.1:2020...");
        while (true) {
            Socket socket = server_socket.accept();
            ServerThread server_thread = new ServerThread(socket, this);
            Thread thread = new Thread(server_thread);
            thread.start();
        }
    }
    public synchronized int getClientNumber() { return clientnumber++; }
    public static void main(String[] args) {
        try { new ServerMain(); } catch (Exception e) { e.printStackTrace(); }
    }
}