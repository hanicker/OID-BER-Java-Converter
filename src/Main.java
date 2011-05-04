import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.snmp4j.asn1.*;
public class Main {
	static BER ber;
	static final String CONVERSION_ERROR="Error converting";
	public Main(){
		ber=new BER();
		//System.out.println(encodeNormalOID("1.3.6.1.2.1.4.21.1.3.9.1.2.3"));
		new Window();
	}
	public static String decodeNormalOID(String oid){
		BERInputStream bis;
		try{
			bis=new BERInputStream(ByteBuffer.wrap(hexStringToByteArray(oid)));
		}catch(StringIndexOutOfBoundsException sio){
			return CONVERSION_ERROR;
		}
		BER.MutableByte type = new BER.MutableByte();
		int[] v;
		try {
			v =BER.decodeOID(bis, type);
		} catch (IOException e) {
			return CONVERSION_ERROR;
		}
	    if (type.getValue() != BER.OID) {
	    	return CONVERSION_ERROR;
	    }
	    return intArrayToString(v);
	}	
	public static String intArrayToString(int[] v){
		String s="";
		for(int i=0;i<v.length;i++){
			if(i==v.length-1)
				s+=v[i];
			else
				s+=v[i]+".";
		}
		return s;
	}
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}	
	public static String encodeNormalOID(String oid){
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try {
			BER.encodeOID(baos, BER.OID, normalizeOID(oid));
		} catch (IOException e) {
			return CONVERSION_ERROR;
		} catch (Exception e) {
			return CONVERSION_ERROR;
		}
		byte[] bytes= baos.toByteArray();
		try {
			return getHexString(bytes);
		} catch (Exception e) {
			return CONVERSION_ERROR;
		}
	}
	public static int[] normalizeOID(String oid) throws Exception{
		String[] split=oid.split("\\.");
		int[] ret=new int[split.length];
		for (int i=0;i<split.length;i++){
			try{
				ret[i]=Integer.parseInt(split[i]);
			}catch(NumberFormatException e){
				throw new Exception();
			}
		}
		return ret;
	}
	public static String getHexString(byte[] b) throws Exception {
		  String result = "";
		  for (int i=0; i < b.length; i++) {
			  try{
		    result +=
		          Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
			  }catch(Exception e){
				  return CONVERSION_ERROR;
			  }
		  }
		  return result;
		}
	public static void main(String[] args){
		new Main();
	}
}
