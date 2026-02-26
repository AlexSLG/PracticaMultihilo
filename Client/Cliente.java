import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String[] args) {

        String servidorIP = "172.20.10.2"; // IP del servidor
        int puerto = 5000;

        try (
            Socket socket = new Socket(servidorIP, puerto);
            BufferedReader teclado = new BufferedReader(
                new InputStreamReader(System.in)
            );
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter salida = new PrintWriter(
                socket.getOutputStream(), true
            );
        ) {

            System.out.println("Conectado al servidor.");
            String mensaje;

            while (true) {
                System.out.print("Escribe mensaje: ");
                mensaje = teclado.readLine();

                salida.println(mensaje);

                String respuesta = entrada.readLine();
                System.out.println("Servidor responde: " + respuesta);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}