import java.io.*;
import java.net.*;

public class SocketTCP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		new SocketTCP();
	}
 
		Socket socket;
		BufferedReader in;
		PrintWriter out;
		public SocketTCP(){
		try{
			socket=new Socket("127.0.0.1",9100);
			
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream(),true);
			BufferedReader line=new BufferedReader(new InputStreamReader(System.in));
			out.println(line.readLine());
			line.close();
			out.close();
			in.close();
		}catch(IOException e){
			
		}
		}
}
