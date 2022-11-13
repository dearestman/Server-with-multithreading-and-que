import com.test.stupakov.java.Phone;

import java.io.*;
import java.net.ServerSocket;


/**
 * @author Stupakov D. L.
 **/
public class Server {
    public static void main(String[] args) throws IOException {



        //передаем Port, ip адрес не нужно
        try (ServerSocket serverSocket = new ServerSocket(8000);) {
            System.out.println("Server started!");
            while (true) {

                Phone phone = new Phone(serverSocket);
                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.println(new StringBuilder("Request: ").append(request));
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String response = String.valueOf((int) (Math.random() * 30 - 10));
                    phone.writeLine(response);
                    System.out.println(new StringBuilder("Response: ").append(response));
                    try {
                        phone.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
