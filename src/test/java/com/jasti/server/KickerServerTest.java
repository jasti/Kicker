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
		client.post(null).write(System.out);
	
		// }

	}
	
		

}
