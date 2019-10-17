package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class RunnableCallable {
  public static void main(String[] args) throws Exception {
    RunnableCallable runner = new RunnableCallable();
    runner.runnableExample();
    runner.callableExample();
  }


  private void callableExample() throws ExecutionException, InterruptedException {
    Callable<String> callable = () -> {
      System.out.println("Create a thread with Callable");
      TimeUnit.SECONDS.sleep(3);
      return "String from Callable";
    };

    FutureTask<String> task = new FutureTask<>(callable);
    System.out.println("Start thread with FutureTask");
    new Thread(task).start();
    System.out.println(task.get());
    System.out.println("_____________________________________");
  }

  private void runnableExample() {
    Runnable runnable = () -> {
      System.out.println("Create a thread with Runnable");
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("String from Runnable");
      System.out.println("_____________________________________");
    };
    runnable.run();
  }

}
