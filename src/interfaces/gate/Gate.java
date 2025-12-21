package interfaces.gate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Gate {

    public interface GateListener {
        void opened();
        void closed();
        default void interrupted() {
            System.out.println("Call 1-800......");
        }
    }

    private final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    private boolean isOpen = false;
    private GateListener listener;

    public Gate() {}

    public void setListener(GateListener listener) {
        this.listener = listener;
    }

    public void startGate() {
        scheduleNext(2, 6);
    }

    private void toggleGate() {
        if (listener  == null) {
            return;
        }

        if (isOpen) {
            listener.closed();
        } else {
            listener.opened();
        }
        isOpen = !isOpen;
    }

    private void scheduleNext(int minSeconds, int maxSeconds) {
        int delaySec = ThreadLocalRandom.current().nextInt(minSeconds, maxSeconds + 1);

        exec.schedule(() -> {
            toggleGate();
            scheduleNext(minSeconds, maxSeconds);
        }, delaySec, TimeUnit.SECONDS);
    }
}
