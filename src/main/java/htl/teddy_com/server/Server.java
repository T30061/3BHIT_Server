package htl.teddy_com.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Server {
    public static int time_started_round;
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(4545)){
            while (true) {
                Socket socket = ss.accept();
                System.out.println("New client connected");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                String text = reader.readLine();

                switch (text){
                    case "e_gm":
                        break;
                    case "m_gm":
                        break;
                }
            }
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void Einzelspieler(BufferedReader reader, PrintWriter writer) throws IOException {
        time_started_round = Integer.parseInt(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        String text;
        do {
            text = reader.readLine();
            if(text == null)
                return;

            if(text.equals("newPlayer")){

            }
            if(text.equals("hit") ) {
                writer.println("Server: " + hit(new Random()));
            }
        } while (true);
    }

    public static String hit(Random rndm){
        String[] listofcards = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        return listofcards[rndm.nextInt(listofcards.length)];
    }

}
