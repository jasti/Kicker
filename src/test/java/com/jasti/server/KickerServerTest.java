package com.jasti.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class KickerServerTest {

	public static void main(String[] args) throws Exception {

		// for (int i = 0; i < 20; i++) {
		ClientResource client = new ClientResource("http://localhost:8083/");
		//client.post(null).write(System.out);
		Representation representation = client.post(null);
		
		String myString = getStringFromInputStream(representation.getStream());
		
		System.out.println(myString);
		// }

	}
	
	// convert InputStream to String
		private static String getStringFromInputStream(InputStream is) {
	 
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
	 
			String line;
			try {
	 
				br = new BufferedReader(new InputStreamReader(is));
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
	 
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	 
			return sb.toString();
	 
		}
	 
		
		

}
