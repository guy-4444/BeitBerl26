package interfaces;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StepDetector {

    private final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

    private SD_Listener listener;

    public void setListener(SD_Listener listener) {
        this.listener = listener;
    }

    public StepDetector() {}

    public void start() {
        scheduleNext(1, 4);

    }

    public void stop() {

    }

    private void stepDetected() {
        System.out.println("step detected");
        listener.detect();
    }


    private void scheduleNext(int minSeconds, int maxSeconds) {
        int delaySec = ThreadLocalRandom.current().nextInt(minSeconds, maxSeconds + 1);

        exec.schedule(() -> {
            stepDetected();
            scheduleNext(minSeconds, maxSeconds);
        }, delaySec, TimeUnit.SECONDS);
    }
}
