import java.util.ArrayList;

public class Detector {
    public static ArrayList<Integer> fulfill_order;
    public static boolean detect_deadlock(Matrix allocate, Matrix request, Vector total, Vector _available, int n, int m) {
        assert allocate.row_dim() == m && allocate.row.size() == n
            && request.row_dim() == m && request.row.size() == n
            && total.dim() == n
            && _available.dim() == m
            && n > 0 && m > 0;
        boolean[] fulfilled = new boolean[n];
        fulfill_order = new ArrayList<>();
        Vector available = new Vector(_available);
        for (boolean changed = true; changed; ) {
            changed = false;
            for (int i = 0; i < n; i++) {
                if (!fulfilled[i] && (request.row.get(i).lessOrEqualTo(available))) {
                    fulfilled[i] = true;
                    changed = true;
                    fulfill_order.add(i);
                    available = available.add(allocate.row.get(i));
                }
            }
        }
        return (fulfill_order.size() == n);
    }
    public static void show(Matrix allocate, Matrix request, Vector total, Vector _available, int n, int m) {
        assert fulfill_order.size() == n;
        Vector available = new Vector(_available);
        System.out.print("S:\t"); available.print(); System.out.println();
        for (Integer integer : fulfill_order) {
            System.out.print(integer + ":\t");
            available = available.add(allocate.row.get(integer));
            available.print();
            System.out.print("\trequested:\t");
            request.row.get(integer).print();
            System.out.print("\tfreed:\t");
            allocate.row.get(integer).print();
            System.out.println();
        }
    }
}
