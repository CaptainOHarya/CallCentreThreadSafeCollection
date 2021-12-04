import java.util.Queue;


public class AutomaticTelephoneStation extends Thread {
    private Queue<Integer> callsQueue;
    //У нас звонки будут поступать каждую секунду
    final static int TIME_NEW_CALL = 1000;
    int callNumber = 0;


    public AutomaticTelephoneStation(Queue<Integer> callsQueue) {
        this.callsQueue = callsQueue;
    }

    public void run() {

        try {
            while (!isInterrupted()) {
                callNumber++;
                callsQueue.add(callNumber);
                System.out.println("Поступил звонок №" + callNumber);
                Thread.sleep(TIME_NEW_CALL);


            }
        } catch (InterruptedException er) {
            er.printStackTrace();
        } finally {
            System.err.println("Приём звонков на сегодня окончен!!!");
        }
    }
}



