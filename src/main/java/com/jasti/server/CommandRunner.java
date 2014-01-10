package com.jasti.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class CommandRunner implements Runnable {

	PrintWriter printWriter = null;

	public CommandRunner(PrintWriter out) {
		printWriter = out;
	}

	@Override
	public void run() {
		
		String command = "ping www.google.com";

		System.out.println("Printing command :" + command);

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
							if (c >= 0) {

								System.out.print((char) c);
								printWriter.write((char) c);
							}
						} while (c >= 0);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			outputDrainer.start();

			p.waitFor();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
