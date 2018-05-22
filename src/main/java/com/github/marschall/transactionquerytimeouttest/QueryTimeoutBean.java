package com.github.marschall.transactionquerytimeouttest;

import static javax.ejb.ConcurrencyManagementType.BEAN;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Singleton
@ConcurrencyManagement(BEAN)
public class QueryTimeoutBean {

//  @Resource(name="myDataSource", lookup="java:comp/DefaultDataSource")
//  private DataSource dataSource;
//
//  private QueryTimeoutUtil queryTimeoutUtil;
//
//  @PostConstruct
//  public void init() {
//    this.queryTimeoutUtil = new QueryTimeoutUtil(this.dataSource);
//  }

  public int getQueryTimeout() {
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
