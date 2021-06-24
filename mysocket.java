import java.net.*;
import java.io.*;
public class mysocket {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根 
		ServerSocket serverSocket =new ServerSocket(9100);
		Socket socket=serverSocket.accept();
		InputStream is=socket.getInputStream();
		InputStreamReader reader=new InputStreamReader(is);
		BufferedReader bread=new BufferedReader(reader);
	 
		OutputStream out=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(out);
		while(true){
		String str=bread.readLine();
		System.out.println(str);
		pw.println("收到客户端信息");
		pw.flush();
		if(str.equals("end")){
			break;
		}
		}  
		socket.close();
	}

}
