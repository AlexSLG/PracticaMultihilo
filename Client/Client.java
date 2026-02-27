import java.io.*;
import java.net.Socket;
public class Client {
    public static void main(String[] args) {
        try {
            // Se conecta a la IP del servidor
            Socket socket = new Socket("192.168.10.1", 2020);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("RESPUESTA: " + in.readLine());
            socket.close();
        } catch (Exception e) {
            System.out.println("Error: No se pudo conectar al servidor 192.168.10.1");
        }
    }
}