package concurrency;

import java.util.concurrent.Executor;

public class ExecutorEx {

  public static void main(String[] args) {
    Runnable task = (() -> {
      System.out.println("Runnable output");
    });

    Executor executor = (runnableTask) -> {
      new Thread(runnableTask).start();
    };
    executor.execute(task);
  }
}
