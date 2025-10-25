package com.codecode.jsh;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.*;

        public class JSchPrivateKeyExample {

            public static void main(String[] args) {
                String username = "root";
                String host = "139.84.145.110";
                int port = 22;  // default SSH port

                try {
                    JSch jsch = new JSch();

                    // Load the private key
                    jsch.addIdentity("/home/gaian/Documents/oriDocs/keys/key.", "");

                    // Create session
                    Session session = jsch.getSession(username, host, port);

                    // Disable strict host key checking for demo (not recommended for production)
                    java.util.Properties config = new java.util.Properties();
                    config.put("StrictHostKeyChecking", "no");
                    session.setConfig(config);

                    // Connect
                    session.connect();
                    System.out.println("Connected via SSH!");

                    // Execute command
                    ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
                    channelExec.setCommand("ls -l");  // any shell command

                    InputStream input = channelExec.getInputStream();
                    channelExec.connect();

                    // Read command output
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }

                    // Cleanup
                    channelExec.disconnect();
                    session.disconnect();
                    System.out.println("Session closed.");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

