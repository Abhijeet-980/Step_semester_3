public class Problem4_TrafficLight {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("ID: " + t.getId());
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());
    }
}

class TrafficLight {
    private final String id;
    private String color;

    TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    String getColor() {
        return color;
    }

    String getId() {
        return id;
    }
}
