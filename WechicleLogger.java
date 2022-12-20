//Author1: Ninel Benush 324699826 ,Author2: Moraz Tamir 208397455

import java.io.*;

public class WechicleLogger {
	static BufferedReader br;
	static FileWriter fw;
	static PrintWriter pw;
	static Object lock = new Object(); 
    public synchronized  static void init() throws IOException {
    	fw = new FileWriter("log.txt"); //Create a file
    }
    
    public static void writeToLog(String msg) throws IOException {
        synchronized (lock) {
        	fw.write(msg+'\n');
        }
    }
    
    public static void close() throws IOException {
    	fw.close();
    }

}
