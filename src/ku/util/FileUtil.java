package ku.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;

public class FileUtil {

	static void copy(InputStream in, OutputStream out) {
		try {
			int b;
			b = in.read();
			while (b != -1) { // read() returns -1 at end of file
				out.write((byte) b);
				b = in.read();
			}
			in.close();
			out.close();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static void copy(InputStream in, OutputStream out, int blocksize) {
		try {
			byte[] buffer = new byte[blocksize];
			int lenght ;
			while ((lenght = in.read(buffer)) > 0) { 
				out.write(buffer, 0, lenght);
			}
			in.close();
			out.close();

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static void bcopy(InputStream in, OutputStream out) {
		Reader reader = new InputStreamReader( in );
		BufferedReader br = new BufferedReader( reader );
		String line = null;
		PrintWriter printWritter = new PrintWriter(out);
		try {
			while( (line = br.readLine()) != null ) {
				printWritter.println(line);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			throw new RuntimeException();
		}

	}
}
