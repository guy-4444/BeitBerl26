package test3;

public class MainTest {

    public void start() {
        Solder solder = new Solder();
        solder.off();

        ButtonListener listener = new ButtonListener() {
            @Override
            public void onClick(int x, int y) {
                System.out.println("Jump");
            }
        };

        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();

        button1.setListener(listener);

        button2.setListener(new ButtonListener() {
            @Override
            public void onClick(int x, int y) {
                System.out.println("Jump");
            }
        });

        button3.setListener((x, y) -> System.out.println("Jump"));

        CheckBox checkBox = new CheckBox();
        checkBox.setListener(() -> System.out.println("Switch between Light/Dark theme"));

        CheckBox checkBox2 = new CheckBox();
        checkBox2.setListener(() -> {
            System.out.println("A");
            System.out.println("B");
        });

        EditText editText = new EditText();
        editText.setListener(new EditText.EditListener() {
            @Override
            public void typing() {

            }

            @Override
            public void edited() {

            }
        });

    }

    class Button {

        public void setListener(ButtonListener listener) {

        }

    }

    class CheckBox {

        public interface CheckListener {
            void checked();
        }

        public void setListener(CheckListener listener) {

        }

    }

    private class EditText {

        public interface EditListener {
            void typing();
            void edited();
        }

        public void setListener(EditText.EditListener listener) {

        }
    }
}
