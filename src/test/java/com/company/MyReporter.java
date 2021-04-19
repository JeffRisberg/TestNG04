package com.company;

import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.testng.*;
import org.testng.xml.XmlSuite;

@Slf4j
public class MyReporter implements IReporter {

  public MyReporter() {
    log.info("created");
  }

  @Override
  public void generateReport(
      List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

    // Iterate over every suite assigned for execution
    for (ISuite suite : suites) {
      String suiteName = suite.getName();

      Map<String, ISuiteResult> suiteResults = suite.getResults();
      for (ISuiteResult sr : suiteResults.values()) {
        ITestContext tc = sr.getTestContext();

        System.out.printf(
            "Passed tests for suite '%s' is %d%n",
            suiteName, tc.getPassedTests().getAllResults().size());

        System.out.printf(
            "Failed tests for suite '%s' is %d%n",
            suiteName, tc.getFailedTests().getAllResults().size());

        System.out.printf(
            "Skipped tests for suite '%s' is %d%n",
            suiteName, tc.getSkippedTests().getAllResults().size());
      }
    }
  }
}
