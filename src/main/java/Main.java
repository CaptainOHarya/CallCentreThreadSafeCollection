import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    final static int PERIOD_CALLS = 60000; // звонки идут ровно одну минуту

    public static void main(String[] args) throws InterruptedException {
        // Очередь из наших звонков
        Queue<Integer> callsQueue = new ConcurrentLinkedQueue<>();

        Thread ats = new AutomaticTelephoneStation(callsQueue);
        ats.start();

        // Наверное это маленький колл-центр всего пять операторов
        Thread callOperator1 = new CallOperator(callsQueue, "Марина Тундра");
        callOperator1.start();
        Thread callOperator2 = new CallOperator(callsQueue, "Даниил Счастливый");
        callOperator2.start();
        Thread callOperator3 = new CallOperator(callsQueue, "Виталий Куролесов");
        callOperator3.start();
        Thread callOperator4 = new CallOperator(callsQueue, "Екатерина Великая");
        callOperator4.start();
        Thread callOperator5 = new CallOperator(callsQueue, "Ксения Мировая");
        callOperator5.start();

        Thread.sleep(PERIOD_CALLS);
        ats.interrupt();

        while (callsQueue.peek() != null) {
        }
        callOperator1.interrupt();
        callOperator2.interrupt();
        callOperator3.interrupt();
        callOperator4.interrupt();
        callOperator5.interrupt();
        System.err.println("Все звонки были обработаны! До новых встреч!");
    }
}


