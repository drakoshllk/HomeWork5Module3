import java.util.LinkedList;
import java.util.List;

public class Bucket<E> {
    private List<BObject<E>> list;

    public Bucket() {
        this.list = new LinkedList<>();
    }

    public List<BObject<E>> getList() {
        return this.list;
    }

    public void addObject(BObject<E> object) {
        this.list.add(object);
    }

    public void remove(BObject<E> object){
        this.list.remove(object);
    }
}
