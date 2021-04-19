package com.company;

import lombok.extern.slf4j.Slf4j;
import org.testng.*;

@Slf4j
public class MyTestListener implements ITestListener {

  public MyTestListener() {
    log.info("created");
  }

  public void onStart(ITestContext context) {
    log.info("onSuiteStart");
  }

  public void onFinish(ITestContext context) {
    log.info("onSuiteFinish");
  }

  public void onTestStart(ITestResult context) {
    log.info("onTestStart");
  }

  public void onTestSuccess(ITestResult context) {
    log.info("onTestSuccess");
  }

  public void onTestFailure(ITestResult context) {
    log.info("onTestFailure");
  }

  public void onTestSkipped(ITestResult context) {
    log.info("onTestSkipped");
  }
}
