package com.jasti.server;

import org.restlet.resource.ClientResource;

public class KickerServerTest {

    public static void main(String[] args) throws Exception {

     //   for (int i = 0; i < 20; i++) {
            ClientResource client = new ClientResource("http://localhost:8082/");
            client.post(null).write(System.out);
            System.out.println("Success");
   //     }

    }

}
