public class ThreadAsync {
    public static void main(String[] args) {
        //Runnalbe 3가지 작업 정의
        Runnable run1 = () -> {
            try {
                System.out.println("작업1 시작 " +Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("작업1 끝 (1초)" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable run2 = () -> {
            try {
                System.out.println("작업2 시작 " +Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("작업2 끝 (5초)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable run3 = () -> {
            try {
                System.out.println("작업3 시작 " +Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("작업3 끝 (3초)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread async1 = new Thread(run1); //1초 걸리는 작업
        Thread async2 = new Thread(run2); //5초 걸리는 작업
        Thread async3 = new Thread(run3); //3초 걸리는 작업
        async1.start();
        async2.start();
        async3.start();

    }
}


