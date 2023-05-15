public class BObject<E> {
    private E element;

    public BObject(E element) {
        this.element = element;
    }

    public E getElement() {
        return this.element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
