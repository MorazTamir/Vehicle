//Author1: Ninel Benush 324699826 ,Author2: Moraz Tamir 208397455

import java.io.*;

public class WechicleLogger {
	BufferedReader br;
	FileWriter fw;
	PrintWriter pw;

	public WechicleLogger(FileReader fr) {
		this.br = new BufferedReader(fr);
		pw = null;
	}

	public WechicleLogger(FileWriter fw) {
		br = null;
		this.pw = new PrintWriter(fw);
	}

	public WechicleLogger(FileReader fr, FileWriter fw) {
		this.br = new BufferedReader(fr);
		this.pw = new PrintWriter(fw);
	}

	public synchronized String readFromText() throws IOException {
		return br.readLine();
	}

	public synchronized void writeToFile(String nameOfFile, String message) throws IOException {
		fw = new FileWriter(nameOfFile, true);
		pw = new PrintWriter(fw);
		pw.println(message);
		pw.close();
		fw.close();
	}

	public void close() throws IOException {
		if (br != null)
			br.close();
		if (pw != null)
			pw.close();
	}

}
