import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) {
        int puerto = 5000;

        try (ServerSocket servidor = new ServerSocket(puerto)) {

            System.out.println("Servidor iniciado...");
            System.out.println("Esperando clientes...");

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());

                // Crear hilo para cada cliente
                new HiloCliente(cliente).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HiloCliente extends Thread {

    private Socket socket;

    public HiloCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter salida = new PrintWriter(
                socket.getOutputStream(), true
            );
        ) {

            String mensaje;

            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Cliente dice: " + mensaje);
                salida.println("Servidor recibió: " + mensaje);
            }

        } catch (IOException e) {
            System.out.println("Cliente desconectado.");
        }
    }
}