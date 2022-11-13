import com.test.stupakov.java.Phone;

import java.io.*;
import java.net.Socket;

/**
 * @author Stupakov D. L.
 **/
public class Client {
    public static void main(String[] args) {
        try (Phone phone = new Phone("127.0.0.1", 8000)) {
            System.out.println("Connected to server");
            String request = "Moscow";
            System.out.println(new StringBuilder().append("Request: ").append(request).toString());
            phone.writeLine(request);
            String response = phone.readLine();
            System.out.println("Response: " + response);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
