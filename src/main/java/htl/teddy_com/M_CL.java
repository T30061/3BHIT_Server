package htl.teddy_com;

import java.io.*;
import java.net.*;

public class M_CL {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 4545)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("m_gm");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
        } catch (IOException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        }
    }
}
