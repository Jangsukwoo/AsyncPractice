import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturePractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //thenCombine을 써서 응답 시간이 다른 두개의 리턴값을 조합해서 출력해주기
        //supplyAsync (return 값 존재)
        //completable future 정의
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
                System.out.println("As111 "+ "3초");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "작업결과1 ";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(4000);
                System.out.println("As222" + "4초");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "작업결과2";
        });

        CompletableFuture<String> future = future1.thenCombine(future2,(a1,a2)->a1+" "+a2); //결과값 조합. biFunction

        System.out.println("최종 결과 : " + future.get()); //Blocking call.
        System.out.println("총 소요시간 : "+(System.currentTimeMillis()-startTime)+" millis");
        System.out.println("end");
    }
}
