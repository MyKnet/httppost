import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class XMLpost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//String url="http://app.xmsetyy.com/wx/notify.aspx";
		String url = "https://pay.swiftpass.cn/pay/gateway";
		//String url = "http://192.168.1.58:1003/notify.aspx";
		//String xml = "<xml><bank_type><![CDATA[CFT]]></bank_type><charset><![CDATA[UTF-8]]></charset><coupon_fee><![CDATA[0]]></coupon_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[N]]></is_subscribe><mch_id><![CDATA[592367000001]]></mch_id><nonce_str><![CDATA[1465708821844]]></nonce_str><openid><![CDATA[o1KtRwkzynomNLueJc0Ms0FMFFQA]]></openid><out_trade_no><![CDATA[f4673171b2094f059f8e4384620f1798]]></out_trade_no><out_transaction_id><![CDATA[4001182001201606127148424247]]></out_transaction_id><pay_result><![CDATA[0]]></pay_result><result_code><![CDATA[0]]></result_code><sign><![CDATA[9FD698A93B257C81AB36CA17421695C0]]></sign><sign_type><![CDATA[MD5]]></sign_type><status><![CDATA[0]]></status><time_end><![CDATA[20160612131909]]></time_end><total_fee><![CDATA[1]]></total_fee><trade_type><![CDATA[pay.weixin.jspay]]></trade_type><transaction_id><![CDATA[592367000001201606128460838627]]></transaction_id><version><![CDATA[2.0]]></version></xml>"; 
		//String xml = "<xml><bank_type>CFT</bank_type><charset>UTF-8</charset><coupon_fee>0</coupon_fee><fee_type>CNY</fee_type><is_subscribe>N</is_subscribe><mch_id>592367000001</mch_id><nonce_str>1465708821844</nonce_str><openid>o1KtRwkzynomNLueJc0Ms0FMFFQA</openid><out_trade_no>f4673171b2094f059f8e4384620f1798</out_trade_no><out_transaction_id>4001182001201606127148424247</out_transaction_id><pay_result>0</pay_result><result_code>0</result_code><sign>9FD698A93B257C81AB36CA17421695C0</sign><sign_type>MD5</sign_type><status>0</status><time_end>20160612131909</time_end><total_fee>1</total_fee><trade_type>pay.weixin.jspay</trade_type><transaction_id>592367000001201606128460838627</transaction_id><version>2.0</version></xml>"; 
		String xml = "<xml><attach><![CDATA[bank_mch_name=汇付天下&bank_mch_id=0001]]></attach><body><![CDATA[汇付天下]]></body><callback_url><![CDATA[null]]>/callback_url><charset><![CDATA[UTF-8]]></charset><is_raw><![CDATA[null]]></is_raw><mch_create_ip><![CDATA[dd]]></mch_create_ip><nonce_str><![CDATA[1476927121303]]></nonce_str><notify_url><![CDATA[http://test.chinapnr.com/bip/outer/bank/tdIncome/asyn/D2I4]]></notify_url><out_trade_no><![CDATA[1476927120358]]></out_trade_no><service><![CDATA[pay.weixin.jspay]]></service><sign><![CDATA[66d81fa788281640af714d46c868356d]]></sign><total_fee><![CDATA[1]]></total_fee></xml>"; 
		
		//new XMLpost().testPost(url, xml);
		new XMLpost().paypost(url, xml);

	}

	void testPost(String qurl,String xl){
		try{
			URL url=new URL(qurl);
			URLConnection con=url.openConnection();
			con.setDoOutput(true);
			con.setRequestProperty("pragma", "no-cache");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setRequestProperty("Content-Type", "text/xml");
			
			OutputStreamWriter out=new OutputStreamWriter(con.getOutputStream());
			String xmlinfo=xl;
			System.out.println("qurl="+qurl);
			System.out.println("xmlinfo="+xmlinfo);
			out.write(new String (xmlinfo.getBytes("ISO-8859-1")));
			out.flush();
			out.close();
			BufferedReader br=new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String line="";
			for(line=br.readLine();line!=null; line=br.readLine()){
				System.out.println(line);
				
			}
			
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	void paypost(String qurl,String xml){
		DataInputStream input=null;
		byte[] xmldata=xml.getBytes();
		java.io.ByteArrayOutputStream out = null;  
		try{
			URL url = new URL(qurl);    
			URLConnection urlCon = url.openConnection();   
			urlCon.setDoOutput(true);    
			urlCon.setDoInput(true);    
			urlCon.setUseCaches(false);   
			urlCon.setRequestProperty("Content-Type", "text/xml");    
			 urlCon.setRequestProperty("Content-length",String.valueOf(xmldata.length)); 
			 DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());   
			 printout.write(xmldata);
			 printout.flush();
			 printout.close(); 
			 BufferedReader br=new BufferedReader(new InputStreamReader(
					 urlCon.getInputStream()));
				String line="";
				for(line=br.readLine();line!=null; line=br.readLine()){
					System.out.println(line);
					
				}
			 
		}catch(Exception e){    
			 e.printStackTrace();   
		}
		finally { 
			try {   
				 out.close();   
				 input.close();   
			}
			catch (Exception ex) {  
				
			}
		}
	}
		
}
