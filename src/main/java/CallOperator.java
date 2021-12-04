import java.util.NoSuchElementException;
import java.util.Queue;


public class CallOperator extends Thread {// Класс Оператора колл-центра
    final static int CALL_PROCESSING_TIME = 5000; // Оператор тратит на обработку звонка 5 секунд
    private Queue<Integer> callsQueue;
    private String operatorName;

    public CallOperator(Queue<Integer> callsQueue, String operatorName) {
        this.callsQueue = callsQueue;
        this.operatorName = operatorName;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                if (callsQueue.poll() == null) {
                    System.out.println(operatorName + " ожидает звонок");

                } else {
                    System.err.println(operatorName + " обрабатывает новый вызов");
                    Thread.sleep(CALL_PROCESSING_TIME);
                }

            }
        } catch (InterruptedException er) {
            System.err.println(operatorName + " завершил работу!");

        }
    }


}
