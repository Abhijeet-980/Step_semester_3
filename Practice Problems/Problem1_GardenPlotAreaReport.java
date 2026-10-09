import java.util.Scanner;

public class Problem1_GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Plot[] plots = new Plot[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String shape = parts[0];
            String owner = parts[1];
            if (shape.equals("CIRCLE")) {
                plots[i] = new CirclePlot(owner, Double.parseDouble(parts[2]));
            } else if (shape.equals("RECTANGLE")) {
                plots[i] = new RectanglePlot(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            } else {
                plots[i] = new TrianglePlot(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            }
        }
        double total = 0;
        for (Plot plot : plots) {
            double area = plot.area();
            total += area;
            System.out.printf("%s (%s): %.2f%n", plot.owner, plot.shapeName(), area);
        }
        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}

abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();

    abstract String shapeName();
}

class CirclePlot extends Plot {
    private double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    String shapeName() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    String shapeName() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }

    String shapeName() {
        return "TRIANGLE";
    }
}
