import java.io.*;
import java.net.Socket;
public class ServerThread implements Runnable {
    private Socket socket;
    private ServerMain server_main;
    public ServerThread(Socket socket, ServerMain server_main) {
        this.socket = socket;
        this.server_main = server_main;
    }
    public void run() {
        try {
            int num = server_main.getClientNumber();
            System.out.println("Cliente #" + num + " conectado.");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String saludo = "Hola, eres el cliente #" + num;
            if (num % 2 == 0) { saludo += ". ¡Tienes mucha suerte!"; }
            out.println(saludo);
            socket.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
