import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) throws IOException {
        int port = 5050; // случайный порт (может быть любое число от 1025 до 65535)
        ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту

        System.out.println("Server started");

        while (true) {
            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            SocketThread socketThread = new SocketThread(socket);
            new Thread(socketThread).start();
        }

    }

    static class SocketThread implements Runnable {

        private final Socket socket;

        SocketThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream sin = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sin));
                PrintWriter bufferedWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sout)), true);

                while (true) {
                    String message = bufferedReader.readLine();
                    if (message.equals("Bye")) break;
                    bufferedWriter.println(message);
                }
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
