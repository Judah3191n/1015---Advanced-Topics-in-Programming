public class colours {

    public enum colour {
        Red(1), Orange(2), Yellow(3), Green(4), Blue(5), Purple(6);

        int value;

        colour(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }
    };

    public static void main(String[] args) {
        System.out.println(colour.Red);
        System.out.println(colour.valueOf("Green"));
        System.out.println(colour.values()[5]);
        System.out.println(colour.Blue.ordinal());
        for (int i = 0; i < colour.values().length; i++) {
            System.out.println(colour.values()[i]);
        }
        System.out.println(colour.values());

        for (colour i : colour.values()) {
            System.out.println(i.getValue());
        }
    }
}
