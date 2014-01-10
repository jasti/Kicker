package com.jasti.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;

import org.restlet.data.MediaType;
import org.restlet.representation.OutputRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class KickerResource extends ServerResource {

	XStream xstreamJson = new XStream(new JsonHierarchicalStreamDriver());

	XStream xstream = new XStream(new DomDriver());
	
	@Post
	public Representation represent(Variant variant) throws IOException {
		{

			final PipedInputStream pi = new PipedInputStream();
			PipedOutputStream po = new PipedOutputStream(pi);
			Representation ir = new OutputRepresentation(MediaType.TEXT_PLAIN) {

				@Override
				public void write(OutputStream realOutput) throws IOException {
					byte[] b = new byte[8];
					int read;
					while ((read = pi.read(b)) != -1) {
						realOutput.write(b, 0, read);
						realOutput.flush();
					}
				}
			};
			OutputStreamWriter ow = new OutputStreamWriter(po);
			PrintWriter out = new PrintWriter(ow, true);

			// ...

			try {
				new Thread(new CommandRunner(out)).start();
				return ir;
			} catch (Exception e) {
				// return some error representation
			}
			return null;
		}

	}
}
