public class Main {

    public static void main(String[] args) {
        // example from 6.5.4
        Matrix allocate = new Matrix() {{
            add(new Vector(new int[]{3, 0, 1, 1}));
            add(new Vector(new int[]{0, 1, 0, 0}));
            add(new Vector(new int[]{1, 1, 1, 0}));
            add(new Vector(new int[]{1, 1, 0, 1}));
            add(new Vector(new int[]{0, 0, 0, 0}));
        }};
        Matrix request = new Matrix() {{
            add(new Vector(new int[]{1, 1, 0, 0}));
            add(new Vector(new int[]{0, 1, 1, 2}));
            add(new Vector(new int[]{3, 1, 0, 0}));
            add(new Vector(new int[]{0, 0, 1, 0}));
            add(new Vector(new int[]{2, 1, 1, 0}));
        }};
        Vector E = new Vector(new int[]{6, 3, 4, 2});
        Vector A = new Vector(new int[]{1, 0, 2, 0});
        if (Detector.detect_deadlock(allocate, request, E, A, 5, 4)) {
            System.out.println("Success");
            Detector.show(allocate, request, E, A, 5, 4);
            System.out.println();
        }
        else {
            System.out.println("Fail");
        }
    }

}
