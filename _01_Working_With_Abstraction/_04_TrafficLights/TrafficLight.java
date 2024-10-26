package _04_TrafficLights;

public enum TrafficLight {
    RED,
    GREEN,
    YELLOW;

    public static void updateLight(TrafficLight[] lights) {

        for (int i = 0; i < lights.length; ++i) {
            switch (lights[i]) {
                case RED -> lights[i] = GREEN;
                case GREEN -> lights[i] = YELLOW;
                case YELLOW -> lights[i] = RED;
            }
        }
    }

    public static void print(TrafficLight[] lights) {
        for (TrafficLight light : lights) {
            System.out.printf("%s ", light);
        }
        System.out.println();
    }

}
