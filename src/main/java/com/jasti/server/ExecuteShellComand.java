package com.jasti.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecuteShellComand {

    public static void main(String[] args) {

        ExecuteShellComand obj = new ExecuteShellComand();

        String domainName = "google.com";
        //
        // // in mac oxs
    //     String command = "ping -c 3 " + domainName;
        //
        // // in windows
       // String command = "ping -n 3 " + domainName;

        // C:\\CharlesRiver\\91455\\serverapps\\bin\\DoOutput.bat
        //
        
       
        
        String output = obj.executeCommand("/Users/zudec/Code/fetch_test/doFeeds.sh");

        System.out.println(output);

    }

    private String executeCommand(String command) {

        System.out.println("Printing command :" + command);
        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            final InputStream pOut = p.getInputStream();
            Thread outputDrainer = new Thread()
            {
                public void run()
                {
                    try
                    {
                        int c;
                        do
                        {
                            c = pOut.read();
                            if (c >= 0)
                                System.out.print((char)c);
                        }
                        while (c >= 0);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            outputDrainer.start();

            p.waitFor();
         

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

}