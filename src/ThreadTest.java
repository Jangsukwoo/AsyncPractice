import java.util.ArrayList;

public class ThreadTest {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            private int index = 0;
            @Override
            public void run() {
                addIndex();
            }

            void addIndex() {
                index++;
                System.out.println(index);
            }
        };//Runnable 정의

        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            Thread thread = new Thread(r);
            thread.start();
            threads.add(thread);
        }
        for(Thread t : threads){
            try{
                t.join();
            }
            catch(Exception e){
                System.out.println("익셉션터짐");
            }
        }
        System.out.println("메인이 죽는다");
    }
}
