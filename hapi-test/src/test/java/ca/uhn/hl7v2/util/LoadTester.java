package ca.uhn.hl7v2.util;

import ca.uhn.hl7v2.app.*;
import ca.uhn.hl7v2.llp.*;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.GenericParser;
import java.net.Socket;

/**
 * Load tests SimpleServer by sending a set of messages repeatedly.
 * @author Bryan Tripp
 */
public class LoadTester extends Thread {
    
    Connection conn;
    Message[] messages;
    long interval;
    long duration;
    
    /** Creates a new instance of LoadTester */
    public LoadTester(Message[] messages, long intervalMilliseconds, long durationSeconds, String host, int port) throws Exception {
        this.messages = messages;
        this.interval = intervalMilliseconds;
        this.duration = durationSeconds;
        conn = new ActiveConnection(new GenericParser(), new MinLowerLayerProtocol(), new Socket(host, port));
        conn.activate();
    }
    
    public void run() {
        int c = 0;
        
        while (c < 1000) { //System.currentTimeMillis() < end) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {}
                        
            System.out.println("Sending message " + c++);
            try {
                conn.getInitiator().sendAndReceive(messages[0]);            
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String args[]) {
        try {
            GenericParser parser = new GenericParser();            
            String[] strings = {"MSH|^~\\&|Fake Sending App|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01^ACK|20|P|2.4|\rMSA|AA\r"};
            
            Message[] messages = new Message[strings.length];
            for (int i = 0; i < strings.length; i++) {
                messages[i] = parser.parse(strings[i]);
            }
            
            LoadTester tester = new LoadTester(messages, 20, 60, "localhost", 5678);
            tester.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
