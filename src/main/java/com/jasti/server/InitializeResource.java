package com.jasti.server;

import java.sql.Timestamp;
import java.util.Date;

import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class InitializeResource extends ServerResource {

    XStream xstreamJson = new XStream(new JsonHierarchicalStreamDriver());

    XStream xstream = new XStream(new DomDriver());

    @Post
    public String getCommands(Representation entity) throws CloneNotSupportedException, InterruptedException {
        System.out.println("Processed Request" + new Date());
        String dog = "Hello Dawg!";
        Thread.sleep(10000);
        return dog;

    }

}
 