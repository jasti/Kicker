package com.jasti.server;

import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class KickerResource extends ServerResource {

    XStream xstreamJson = new XStream(new JsonHierarchicalStreamDriver());

    XStream xstream = new XStream(new DomDriver());

    @Post
    public String getCommands(Representation entity) throws CloneNotSupportedException {
        
        

        String JSON = null;

        return JSON;

    }



}
