import java.io.*;
import java.net.Socket;
import com.google.gson.Gson;
import event.Connect;

/**
 * Created by lance on 5/25/16.
 */
public class Client {
    public static final String IP_ADDR = "127.0.0.1";
    public static final int PORT = 8787;
    public static String id = "";

    private static DataOutputStream out;
    private static DataInputStream in;
    private static BufferedReader reader;

    public static void run() {
        System.out.println("Client start");
        try {
            Socket socket = new Socket(IP_ADDR, PORT);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String ret = reader.readLine();
            Gson gson = new Gson();
            Connect connection = gson.fromJson(ret, Connect.class);
            id = connection.id;

            out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                ret = reader.readLine();
                if (ret == null || ret.length() == 0) break;
                System.out.print(ret);
            }
        } catch (Exception e) {
            System.out.println("ERROR CLIENT: " + e.getMessage());
        } finally {
        }
    }

    public static void write(String data) {
        try {
            out.writeUTF(data);
            out.flush();
        } catch (Exception e) {
            System.out.println("write ERROR: " + e.getMessage());
        }
    }
}