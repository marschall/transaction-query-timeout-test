package com.github.marschall.transactionquerytimeouttest;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TransactionServlet extends QueryTimeoutServlet {

//  @EJB(mappedName = "QueryTimeoutBean")
//  private QueryTimeoutBean queryTimeoutBean;

  int getQueryTimeout() {
    QueryTimeoutBean queryTimeoutBean;
    try {
      InitialContext initialContext = new InitialContext();
      queryTimeoutBean = (QueryTimeoutBean) initialContext.lookup("java:module/QueryTimeoutBean");
    } catch (NamingException e) {
      throw new RuntimeException("could not lookup ejb", e);
    }
    return queryTimeoutBean.getQueryTimeout();
  }

}
