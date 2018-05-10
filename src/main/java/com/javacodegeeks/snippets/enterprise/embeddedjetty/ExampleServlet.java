package com.javacodegeeks.snippets.enterprise.embeddedjetty;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;

public class ExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setStatus(HttpStatus.OK_200);
        resp.getWriter().println("EmbeddedJetty");
    }
}

