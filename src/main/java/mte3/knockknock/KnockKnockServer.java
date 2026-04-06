// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockServer.java (inside knockknock package)

package mte3.knockknock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class KnockKnockServer {
    public static int PORT = 54322;

    public static void receiveAndSend(Scanner scanner, String message, PrintWriter writer, boolean concat) {
        String msg = scanner.nextLine();
        System.out.println("Recieved: " + msg); 

    } // receiveAndSend() method closed
    
    public static void main(String args[]) throws IOException {
        try (ServerSocket ss = new ServerSocket(PORT);
            Socket socket = ss.accept();
            Scanner scan = new Scanner(System.in)

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        ) {
            msg1 = sendAndReceive(writer, "Knock, Knock", scan);
            receiveAndSend(scan, "Who's there?", writer, true);
        
            msg2 = sendAndReceive(writer, who, scan);
            receiveAndSend(scan, who + ", Who?", writer, true);
        
            msg3 = sendAndReceive(writer, punchLine, scan);
            receiveAndSend(scan, "Haha, nice one!", writer, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ss.close();
        socket.close();
        in.close();
        writer.close();
    } // main() method closed
}