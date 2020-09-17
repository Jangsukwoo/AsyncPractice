import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorTest {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);


        executorService.submit(getRunnable(3000,"작업1"));
        executorService.submit(getRunnable(4000,"작업2"));
        executorService.submit(getRunnable(2000,"작업3"));
        executorService.submit(getRunnable(5000,"작업4"));
        executorService.submit(getRunnable(1000,"작업5"));

        executorService.shutdown();//모든 스레드를 종료 시키고 프로세스를 종료시킨다.


    }
    public static Runnable getRunnable(int second,String taskName){
        return ()->{
            try {
                System.out.println(taskName+" 시작     " +Thread.currentThread().getName());
                Thread.sleep(second);
                System.out.println(taskName+" 종료"+ (second/1000)+"초     " +Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
