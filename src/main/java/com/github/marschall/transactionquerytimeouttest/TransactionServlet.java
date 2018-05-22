package com.github.marschall.transactionquerytimeouttest;

import javax.ejb.EJB;

public class TransactionServlet extends QueryTimeoutServlet {

  @EJB
  private QueryTimeoutBean queryTimeoutBean;

  int getQueryTimeout() {
    return this.queryTimeoutBean.getQueryTimeout();
  }

}
