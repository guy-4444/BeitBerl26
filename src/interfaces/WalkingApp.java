package interfaces;

public class WalkingApp {

    private int stepCounter = 0;

    private SD_Listener listener = new SD_Listener() {
        @Override
        public void detect() {
            updateUI();
        }
    };

    public void openScreen() {
        System.out.println("▤ ▤ ▤ ▤ Welcome to Clalit Active ▤ ▤ ▤ ▤");
        StepDetector stepDetector = new StepDetector();
        stepDetector.start();
        stepDetector.setListener(listener);





        SD_Listener lis = new SD_Listener() {
            @Override
            public void detect() {
                updateUI();
            }
        };
        stepDetector.setListener(lis);

        stepDetector.setListener(new SD_Listener() {
            @Override
            public void detect() {
                updateUI();
            }
        });

        stepDetector.setListener(() -> updateUI());


        setListener((ms, name) -> {
            System.out.println(name + ": " + ms);
            return false;
        });













    }

    private void setListener(ClickListener clickListener) {

    }

    private void updateUI() {
        System.out.println("New Step: " + stepCounter++);
    }

}
