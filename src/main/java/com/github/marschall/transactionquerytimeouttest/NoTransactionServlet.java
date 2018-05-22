package com.github.marschall.transactionquerytimeouttest;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class NoTransactionServlet extends QueryTimeoutServlet {

//  @Resource(name="myDataSource", lookup="java:comp/DefaultDataSource")
//  private DataSource dataSource;
//
//  private QueryTimeoutUtil queryTimeoutUtil;
//
//  public void init() throws ServletException {
//    super.init();
//    this.queryTimeoutUtil = new QueryTimeoutUtil(this.dataSource);
//  }

  @Override
  int getQueryTimeout() {
    DataSource dataSource;
    try {
      InitialContext initialContext = new InitialContext();
      dataSource = (DataSource) initialContext.lookup("java:comp/DefaultDataSource");
    } catch (NamingException e) {
      throw new RuntimeException("could not lookup ejb", e);
    }
    return new QueryTimeoutUtil(dataSource).getQueryTimeout();
  }

}
