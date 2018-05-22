package com.github.marschall.transactionquerytimeouttest;

import static javax.ejb.ConcurrencyManagementType.BEAN;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.sql.DataSource;

@Singleton
@ConcurrencyManagement(BEAN)
public class QueryTimeoutBean {

  @Resource(name="myDataSource", lookup="java:comp/DefaultDataSource")
  private DataSource dataSource;

  private QueryTimeoutUtil queryTimeoutUtil;

  @PostConstruct
  void init() {
    this.queryTimeoutUtil = new QueryTimeoutUtil(this.dataSource);
  }

  public int getQueryTimeout() {
    return this.queryTimeoutUtil.getQueryTimeout();
  }

}
