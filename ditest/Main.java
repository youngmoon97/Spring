public class Main {
    public static void main(String[] args) {
        Arm arm = new Arm();
        Leg leg = new Leg();
        Robot robot = new Robot(arm, leg);
    }
}
