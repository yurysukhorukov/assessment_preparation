package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureEx {
  static int index;

  public static void main(String[] args) {
    ExecutorService service = Executors.newCachedThreadPool();
    List<Future> list = new ArrayList<>();

    Callable callable = new Callable() {
      @Override
      public String call() {
        String result = "from call() method #";
        index++;
        return result + index;
      }
    };

    for (int i = 0; i < 5; i++) {
      list.add(service.submit(callable));
    }

    for (Future<String> future : list) {
      try {
        System.out.println(future.get());
        System.out.println(future.isDone());
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      } finally {
        service.shutdown();
      }
    }
  }
}

class TaskManager {

  public int id;

  public TaskManager(int id) {
    this.id = id;
  }
}
