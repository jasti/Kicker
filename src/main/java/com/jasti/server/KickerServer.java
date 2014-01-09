package com.jasti.server;

import org.restlet.Server;
import org.restlet.data.Protocol;

public class KickerServer {

    public static void main(String[] args) throws Exception {

        Server server = new Server(Protocol.HTTP, Integer.parseInt("8082"), InitializeResource.class);
        server.start();
        System.out.println("Started TestResource");
        Server server1 = new Server(Protocol.HTTP, Integer.parseInt("8083"), KickerResource.class);
        server1.start();
        System.out.println("Started KickerResource");
    }
}
