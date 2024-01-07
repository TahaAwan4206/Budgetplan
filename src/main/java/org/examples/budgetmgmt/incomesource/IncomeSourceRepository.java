package org.examples.budgetmgmt.incomesource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeSourceRepository extends JpaRepository<IncomeSource, Long> {
  // Additional custom query methods, if needed
}
