package org.examples.budgetmgmt.budgetplan;
import org.examples.budgetmgmt.expense.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BudgetAnalysisService {

  private final ExpenseRepository expenseRepository;
  private final BudgetPlanRepository budgetPlanRepository;

  @Autowired
  public BudgetAnalysisService(ExpenseRepository expenseRepository, BudgetPlanRepository budgetPlanRepository) {
    this.expenseRepository = expenseRepository;
    this.budgetPlanRepository = budgetPlanRepository;
  }

  @Transactional
  public void checkBudgetPlans() {
    List<BudgetPlan> budgetPlans = budgetPlanRepository.findAll();

    for (BudgetPlan plan : budgetPlans) {
      Integer sum = expenseRepository.sumExpenses(plan.getCategory(), plan.getStartDate(), plan.getEndDate());
      if (sum > plan.getBudgetAmount().intValue()) {
        System.out.println(plan.getCategory().getName() + " exceeded budget of  " + plan.getBudgetAmount() +
            " with " + sum + " expenses");
      }
    }
  }

}
