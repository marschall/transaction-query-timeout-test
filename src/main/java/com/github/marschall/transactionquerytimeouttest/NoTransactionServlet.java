package com.github.marschall.transactionquerytimeouttest;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class NoTransactionServlet extends QueryTimeoutServlet {

  @Resource(name="myDataSource", lookup="java:comp/DefaultDataSource")
  private DataSource dataSource;

  private QueryTimeoutUtil queryTimeoutUtil;

  public void init() throws ServletException {
    super.init();
    this.queryTimeoutUtil = new QueryTimeoutUtil(this.dataSource);
  }

  @Override
  int getQueryTimeout() {
    return this.queryTimeoutUtil.getQueryTimeout();
  }

}
