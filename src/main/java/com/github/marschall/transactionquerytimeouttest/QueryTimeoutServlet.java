package com.github.marschall.transactionquerytimeouttest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class QueryTimeoutServlet extends HttpServlet {

  abstract int getQueryTimeout();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    int queryTimeout = getQueryTimeout();
    writeQueryTimeout(queryTimeout, response);
  }

  protected void writeQueryTimeout(int queryTimeout, HttpServletResponse response)
          throws IOException {
    response.setContentType("text/plain");
    response.setCharacterEncoding("US-ASCII");
    PrintWriter writer = response.getWriter();
    writer.write("Query Timeout: ");
    writer.write(Integer.toString(queryTimeout));
  }

}