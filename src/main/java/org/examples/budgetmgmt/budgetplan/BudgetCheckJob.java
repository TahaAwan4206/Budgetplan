package org.examples.budgetmgmt.budgetplan;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetCheckJob implements Job {

  @Autowired
  public BudgetAnalysisService budgetAnalysisService;

  @Override
  public void execute(JobExecutionContext context) {
    budgetAnalysisService.checkBudgetPlans();
  }
}

