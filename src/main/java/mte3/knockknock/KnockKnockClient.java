// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockClient.java (inside knockknock package)

package mte3.knockknock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class KnockKnockClient {
    public static int PORT = 54322;
    public static String SERVER = "localhost";

    public static void sendAndReceive(PrintWriter writer, String message, Scanner scanner) {
        writer.println(message);
        System.out.println("Sent:" + message);
    } // sendAndReceive() method closed
    

    public static void joke(String who,String punchLine) throws IOException {
        try (Socket socket = new Socket(SERVER, PORT);
            Scanner scan = new Scanner(System.in)

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        ) {
            sendAndReceive(writer, "Knock, Knock", scan);
            receiveAndSend(scan, "Who's there?", writer, true);
        
            sendAndReceive(writer, who, scan);
            receiveAndSend(scan, who + ", Who?", writer, true);
        
            sendAndReceive(writer, punchLine, scan);
            receiveAndSend(scan, "Haha, nice one!", writer, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ss.close();
        socket.close();
        in.close();
        writer.close();
    } // joke() method closed

    public static void main(String[] args) throws IOException {
        String[][] jokes = {{"Tank","You're welcome!"},
                            {"Nobel","Nobel...that's why I knocked!"},
                            {"Says","Says me!"},
                            {"Hawaii","I'm good. Hawaii you?"},
                            {"Lettuce","Lettuce in, it's cold out here!"},
                            {"Cow says","No, a cow says moooooo!"},
                            {"Otto","Otto know. I forgot."}
                        };
        int i = new Random().nextInt(jokes.length);
        joke(jokes[i][0],jokes[i][1]);
        
    } // main() method closed

    // hint: please run KnockKnockServer first and then run KnockKnockClient

} // KnockKnockClient { } class closed