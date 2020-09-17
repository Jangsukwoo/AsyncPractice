import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> result1 = executorService.submit(getCallable(1000,"작업1")); //callable로 만들어져서 리턴값이 있고 퓨처로 받는다.
        Future<String> result2 = executorService.submit(getCallable(4000,"작업2"));


        //executorService.shutdown();//중간에 걸어도 일단 하던작업은 마무리하기 때문에 정상적으로 나온다. 즉,뜻로운 작업을 받지 않겠다는 뜻.

        System.out.println(result2.get(500, TimeUnit.MILLISECONDS)); //blocking call
        System.out.println(result1.get());


        System.out.println(Thread.currentThread().getName());
    }
    public static Callable<String> getCallable(int second,String taskName){
        return ()->{
            try {
                System.out.println(taskName+" 시작     " +Thread.currentThread().getName());
                Thread.sleep(second);
                System.out.println(taskName+" 종료"+ (second/1000)+"초     " +Thread.currentThread().getName());
                return "결과값 : "+taskName + " "+(second/1000)+"초";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        };
    }
}
