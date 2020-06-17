import java.util.ArrayList;

public class Matrix {
    public ArrayList <Vector> row = new ArrayList<>();
    public Matrix () {}
    public Matrix (Vector[] rows) {
        for (Vector vector : rows) {
            add(vector);
        }
    }
    public Matrix (Matrix other) {
        row = new ArrayList<>() {{
            other.row.forEach(x -> add(new Vector(x)));
        }};
    }
    public void add(Vector x) {
        assert row.isEmpty() || row.get(0).dim() == x.dim();
        row.add(x);
    }
    public int row_dim() {
        assert !row.isEmpty();
        return row.get(0).dim();
    }
}
