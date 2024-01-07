package org.examples.budgetmgmt.expense;
import org.examples.budgetmgmt.budgetplan.BudgetCheckJob;
import org.quartz.*;
import org.springframework.stereotype.Service;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Service
public class JobScheduleService {
  private final Scheduler scheduler;

  public JobScheduleService(Scheduler scheduler) {
    this.scheduler = scheduler;

    this.schedule();
  }

  void schedule() {
    JobDetail job = newJob(BudgetCheckJob.class)
        .build();
    Trigger trigger = newTrigger()
        .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 * * * ?")) // Every 2 min
        .build();

    try {
      scheduler.scheduleJob(job, trigger);
    } catch (SchedulerException e) {
      System.out.println(e.getMessage());
    }
  }
}
