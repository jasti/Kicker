package com.jasti.server;

import java.io.IOException;
import java.io.InputStream;

import org.restlet.data.Form;
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
	public String executeCommand(Representation entity) {

		Form form = new Form(entity);

		String key = form.getFirstValue("key");

		String command = key;
		return executeCommand(command);

	}

	private String executeCommand(String command) {

		System.out.println("Printing command :" + command);
		final StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			final InputStream pOut = p.getInputStream();
			Thread outputDrainer = new Thread() {
				public void run() {
					try {
						int c;
						do {
							c = pOut.read();
							if (c >= 0)
								output.append((char) c);
						} while (c >= 0);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			outputDrainer.start();

			p.waitFor();

			// Sleep for 2 seconds,
			// so the output buffer can be populated with the output from the
			// command execution
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
}
