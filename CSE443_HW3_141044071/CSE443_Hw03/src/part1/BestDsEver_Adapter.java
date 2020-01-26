package part1;

import java.util.ArrayList;

public class BestDsEver_Adapter<E> implements BestDSEver {
    ArrayList<E> ds;

    public BestDsEver_Adapter(ArrayList<E> ds) {
        this.ds = ds;
    }

    @Override
    public synchronized void insert(Object o) {
        ds.add((E)o);
    }

    @Override
    public synchronized void remove(Object o) {
        ds.remove((E)o);
    }

    @Override
    public synchronized Object get(int index) {
       return ds.get(index);
    }

    @Override
    public synchronized String toString() {
        return ds.toString();
    }

    public int size() { return ds.size(); }
}
