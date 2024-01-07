package org.examples.budgetmgmt.budgetplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, Long> {
}
