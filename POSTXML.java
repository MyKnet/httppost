import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public  class POSTXML { 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根	 
		try { 
			//String pathUrl = "http://192.168.1.58:1003/notify.aspx";
			//String pathUrl = "http://app.xmsetyy.com/wx/notify.aspx";
			String pathUrl = "https://pay.swiftpass.cn/pay/gateway";
			//String pathUrl = "http://app.xmsetyy.com/public/finance/WFTPayCallBack?orgCode=XMSETYY"; 
			// 建立连接 
			URL url = new URL(pathUrl); 
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection(); 
			// //设置连接属性 
			httpConn.setDoOutput(true);// 使用 URL 连接进行输出 
			httpConn.setDoInput(true);// 使用 URL 连接进行输入 
			httpConn.setUseCaches(false);// 忽略缓存 
			httpConn.setRequestMethod("POST");// 设置URL请求方法 
			//String requestString = "<xml><bank_type><![CDATA[CFT]]></bank_type><charset><![CDATA[UTF-8]]></charset><coupon_fee><![CDATA[0]]></coupon_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[N]]></is_subscribe><mch_id><![CDATA[592367000001]]></mch_id><nonce_str><![CDATA[1465708821844]]></nonce_str><openid><![CDATA[o1KtRwkzynomNLueJc0Ms0FMFFQA]]></openid><out_trade_no><![CDATA[f4673171b2094f059f8e4384620f1798]]></out_trade_no><out_transaction_id><![CDATA[4001182001201606127148424247]]></out_transaction_id><pay_result><![CDATA[0]]></pay_result><result_code><![CDATA[0]]></result_code><sign><![CDATA[9FD698A93B257C81AB36CA17421695C0]]></sign><sign_type><![CDATA[MD5]]></sign_type><status><![CDATA[0]]></status><time_end><![CDATA[20160612131909]]></time_end><total_fee><![CDATA[1]]></total_fee><trade_type><![CDATA[pay.weixin.jspay]]></trade_type><transaction_id><![CDATA[592367000001201606128460838627]]></transaction_id><version><![CDATA[2.0]]></version></xml>"; 
			//String requestString = "<xml><bank_type>CFT</bank_type><charset>UTF-8</charset><coupon_fee>0</coupon_fee><fee_type>CNY</fee_type><is_subscribe>N</is_subscribe><mch_id>592367000001</mch_id><nonce_str>1465708821844</nonce_str><openid>o1KtRwkzynomNLueJc0Ms0FMFFQA</openid><out_trade_no>f4673171b2094f059f8e4384620f1798</out_trade_no><out_transaction_id>4001182001201606127148424247</out_transaction_id><pay_result>0</pay_result><result_code>0</result_code><sign>9FD698A93B257C81AB36CA17421695C0</sign><sign_type>MD5</sign_type><status>0</status><time_end>20160612131909</time_end><total_fee>1</total_fee><trade_type>pay.weixin.jspay</trade_type><transaction_id>592367000001201606128460838627</transaction_id><version>2.0</version></xml>"; 
			String requestString = "<xml><attach><![CDATA[bank_mch_name=汇付天下&bank_mch_id=0001]]></attach><body><![CDATA[汇付天下]]></body><charset><![CDATA[UTF-8]]></charset><mch_create_ip><![CDATA[dd]]></mch_create_ip><nonce_str><![CDATA[1476927121303]]></nonce_str><mch_id><![CDATA[7551000001]]></mch_id><notify_url><![CDATA[http://test.chinapnr.com/bip/outer/bank/tdIncome/asyn/D2I4]]></notify_url><out_trade_no><![CDATA[1476927120358]]></out_trade_no><service><![CDATA[pay.weixin.jspay]]></service><sign><![CDATA[CE1B0106D0B106D86D0385704EC84432]]></sign><total_fee><![CDATA[1]]></total_fee><is_raw><![CDATA[1]]></is_raw><callback_url><![CDATA[null]]></callback_url></xml>"; 
			
			// 设置请求属性 
			// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致 
			byte[] requestStringBytes = requestString.getBytes(); 
			httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length); 
			httpConn.setRequestProperty("Content-Type", "application/octet-stream"); 
			//httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接 
			httpConn.setRequestProperty("Charset", "UTF-8"); 
			// 
			/*String name = URLEncoder.encode(requestString, "utf-8"); 
			httpConn.setRequestProperty("XMl", name); */

			 
			// 建立输出流，并写入数据 
			java.io.OutputStream outputStream = httpConn.getOutputStream(); 
			outputStream.write(requestStringBytes); 
			outputStream.close(); 
			// 获得响应状态 
			int responseCode = httpConn.getResponseCode(); 

			 
			if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功 
				InputStream inputStr=httpConn.getInputStream();
				String info=new String(StreamTool.read(inputStr),"UTF-8");
				System.out.println(info);
				try{
					Thread.sleep(5*1000);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			// 当正确响应时处理数据 
			/*StringBuffer sb = new StringBuffer(); 
			String readLine; 
			BufferedReader responseReader; 
			// 处理响应流，必须与服务器响应流输出的编码一致 
			 responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8")); 
			while ((readLine = responseReader.readLine()) != null) { 
			sb.append(readLine).append("\n"); 
			} 
			responseReader.close(); 
			//tv.setText(sb.toString()); 
			  System.out.println(sb.toString());*/
			} 
			} catch (Exception ex) { 
			ex.printStackTrace(); 
			} 
	}


  static class StreamTool {
	 
	  public static byte[] read(InputStream inputStr) throws Exception {
	    ByteArrayOutputStream outStr = new ByteArrayOutputStream();
	    // TODO Auto-generated method stub
	    byte[] buffer = new byte[1024];
	    int len = 0;
	    while ((len = inputStr.read(buffer)) != -1) {
	      outStr.write(buffer, 0, len);
	    }
	    inputStr.close();
	    return outStr.toByteArray();
	  }
}
}