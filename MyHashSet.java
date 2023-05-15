public class MyHashSet<E> {
    private Bucket<E>[] buckets;
    private int size = 0;
    private int CAPACITY = 10;

    public MyHashSet() {
        this.buckets = new Bucket[CAPACITY];
    }

    private int hashCode(E element) {
        return (element.hashCode() & 0xfffffff) % CAPACITY;
    }

    private BObject<E> getBObject(E element) {
        int hash = hashCode(element);
        if (buckets[hash] == null) return null;
        for (int i = 0; i < buckets[hash].getList().size(); i++) {
            BObject<E> curBObject = buckets[hash].getList().get(i);
            if (curBObject.getElement().equals(element)) return curBObject;
        }
        return null;
    }

    public boolean containsElement(E element) {
        return getBObject(element) != null;
    }

    public E get(E element) {
        BObject<E> curBObject = getBObject(element);
        if (curBObject != null) return curBObject.getElement();
        return null;
    }

    public void put(E element) {
        if (containsElement(element)){
            BObject<E> curBObject = getBObject(element);
            curBObject.setElement(element);
        }
        int hash = hashCode(element);
        if (buckets[hash] == null) buckets[hash] = new Bucket<>();
        buckets[hash].addObject(new BObject<>(element));
        size++;
    }

    public void remove(E element) {
        if (containsElement(element)){
            int hash = hashCode(element);
            buckets[hash].remove(getBObject(element));
        }
    }

    public void printSet() {
        for (int i = 0; i < CAPACITY; i++) {
            if (buckets[i] != null) {
                System.out.println("---------Bucket #" + i);
                buckets[i].getList().forEach(e -> System.out.println(e.getElement()));
            }
        }
        System.out.println("_________________");
    }
}
