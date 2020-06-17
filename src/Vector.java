import java.util.ArrayList;

public class Vector {
    public ArrayList<Integer> value;
    public Vector (ArrayList<Integer> value) {
        this.value = value;
    }
    public Vector (int[] value) {
        this.value = new ArrayList<>();
        for (int i : value) {
            this.value.add(i);
        }
    }
    public Vector (Vector other) {
        this.value = new ArrayList<>() {{addAll(other.value);}};
    }
    public int dim() {
        return value.size();
    }

    public boolean lessOrEqualTo(Vector o) {
        assert o.dim() == dim();
        for (int i = 0; i < value.size(); i++) {
            if (value.get(i) > o.value.get(i)) {
                return false;
            }
        }
        return true;
    }

    public Vector add(Vector o) {
        assert o.dim() == dim();
        Vector ret = new Vector(this);
        for (int i = 0; i < value.size(); i++) {
            ret.value.set(i, ret.value.get(i) + o.value.get(i));
        }
        return ret;
    }
    public Vector subtract(Vector o) {
        assert o.dim() == dim();
        Vector ret = new Vector(this);
        for (int i = 0; i < value.size(); i++) {
            ret.value.set(i, ret.value.get(i) - o.value.get(i));
        }
        return ret;
    }
    public void print() {
        System.out.print("(");
        boolean first = true;
        for (Integer integer : value) {
            if (first) first = false;
            else System.out.print(", ");
            System.out.print(integer);
        }
        System.out.print(")");
    }

}
