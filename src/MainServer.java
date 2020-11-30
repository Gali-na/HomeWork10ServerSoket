import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainServer {
    public static void main(String[] args) {
        try (ServerSocket socketServer = new ServerSocket(8080)) {
            while (true) {
                Socket socket = socketServer.accept();
                Thread thread = new Thread(new MyServer(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
