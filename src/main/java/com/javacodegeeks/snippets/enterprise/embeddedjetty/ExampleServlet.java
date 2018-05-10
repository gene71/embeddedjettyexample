package com.javacodegeeks.snippets.enterprise.embeddedjetty;

import java.io.*;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;

public class ExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setStatus(HttpStatus.OK_200);
        try {
            Class clazz = EmbeddedJettyMain.class;
            InputStream inputStream = clazz.getResourceAsStream("/resources/example.html");
            String data = readFromInputStream(inputStream);
            resp.getWriter().println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readFile(String file) throws IOException {
        //File file = new File(getClass().getResource("example.html").toURI());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        String line;
        StringBuilder resultStringBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }

        return resultStringBuilder.toString();
    }


}

