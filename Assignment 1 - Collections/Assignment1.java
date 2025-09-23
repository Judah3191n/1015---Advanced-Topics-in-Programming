import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

class Car {
    String model;
    int year;
    String colour;
    float price;

    public Car(String model, int year, String colour, float price) {
        this.colour = colour;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public String getModel() {
        return model;
    }

    public float getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayCar() {
        String temp = "";
        for (int i = 0; i < getModel().length(); i++) {
            temp += "-";
        }
        System.out.println("\n------------" + getModel() + "------------");
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Colour: " + getColour());
        System.out.println("Price: " + getPrice());
        System.out.println("------------------------" + temp);

    }
}

class Shape {
    public enum shapes {
        circle, square, triangle
    };

    public enum colours {
        red, orange, yellow, green, blue, purple, black, white
    };

    String shape;
    String colour;
    double[] size;
    double[] position;

    public Shape() {
        this.shape = randomShape();
        this.colour = randomColour();
        this.size = new double[3];
        this.position = new double[3];
        initialPosition();
        initialSize();
    }

    private String randomShape() {
        return shapes.values()[(int) (Math.random() * (shapes.values().length + 1))].toString();
    }

    private String randomColour() {
        return colours.values()[(int) (Math.random() * (colours.values().length + 1))].toString();
    }

    private void initialPosition() {
        for (int i = 0; i < this.position.length; i++) {
            this.position[i] = randomDouble();
        }
    }

    private void initialSize() {
        for (int i = 0; i < this.size.length; i++) {
            this.size[i] = randomDouble();
        }
    }

    private double randomDouble() {
        return Math.floor((Math.random() * 101) * 100) / 100;
    }

    public String getColour() {
        return colour;
    }

    public double[] getPosition() {
        return position;
    }

    public String getShape() {
        return shape;
    }

    public double[] getSize() {
        return size;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setSize(double[] size) {
        this.size = size;
    }

    public void displayShape() {
        String temp = "";
        for (int i = 0; i < getShape().length(); i++) {
            temp += "-";
        }
        System.out.println("\n------------" + getShape() + "------------");
        System.out.println("Shape: " + getShape());
        System.out.println("Position: ");
        System.out.println("\tx = " + this.position[0] + "\n\ty = " + this.position[1] + "\n\tz = " + this.position[2]);
        System.out.println("Size: ");
        System.out
                .println("\tLength = " + this.size[0] + "\n\tHeight = " + this.size[1] + "\n\tWidth = " + this.size[2]);
        System.out.println("Colour: " + getColour());
        System.out.println("------------------------" + temp);
    }
}

public class Assignment1 {

    public static void main(String[] args) {
        // Part 1, sort java array using sorted set
        String Names[] = { "Bob", "Bob", "Josh", "Dawson", "Nadia", "Sam", "Kathren", "David", "Mike", "Judah" };
        System.out.println("Names not in order: ");
        for (String i : Names) {
            if (i == Names[Names.length - 1]) {
                System.out.println(i);
            } else {
                System.out.print(i + ", ");
            }
        }

        TreeSet<String> mySort = new TreeSet<String>(Arrays.asList(Names));
        System.out.println("\nNames in order:");
        System.out.println(mySort);

        // Part 2
        System.out.println("\n\n---------Part 3 Cars---------");
        HashMap<String, Car> Cars = new HashMap<String, Car>();
        Cars.put("c1", new Car("Mustang", 1969, "Red", 50000.00f));
        Cars.put("c2", new Car("Honda", 2004, "Grey", 30000.00f));
        Cars.put("c3", new Car("Toyota", 2017, "Blue", 20000.00f));
        Cars.put("c4", new Car("Ford", 1980, "White", 2500.00f));
        Cars.put("c5", new Car("Volkswagon", 2025, "Black", 25000.00f));

        for (Car i : Cars.values()) {
            i.displayCar();
        }

        // Part 3
        System.out.println("\n\n--------Part 3 Shapes--------");
        HashMap<String, Shape> things = new HashMap<String, Shape>();
        things.put("s1", new Shape());
        things.put("s2", new Shape());
        things.put("s3", new Shape());
        things.put("s4", new Shape());

        for (String j : things.keySet()) {
            things.get(j).displayShape();
        }

    }
}
