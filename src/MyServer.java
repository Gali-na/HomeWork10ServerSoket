import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class MyServer implements Runnable {
    Socket socket;

    public MyServer(Socket socket) {
        this.socket = socket;
    }

    public MyServer() {
    }

    @Override
    public void run() {
        String question = "";

        try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String currentString = bufferedReader.readLine();
            if (currentString.equals("server data")) {
                printWriter.println("Available processors (cores): " + Runtime.getRuntime().availableProcessors() + "\n" +
                        "Free memory (bytes): " + Runtime.getRuntime().freeMemory() + "\n" +
                        "Maximum memory (bytes): " + Runtime.getRuntime().totalMemory());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
