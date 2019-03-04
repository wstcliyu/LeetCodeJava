import java.util.Iterator;

public class Peeking_284<E> implements Iterator<E> {
    private E next = null;
    private Iterator<E> it;

	public Peeking_284(Iterator<E> iterator) {
        it = iterator;
        if (it.hasNext()) next = it.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public E peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public E next() {
	    E res = next;
        next = it.hasNext() ? it.next() : null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}
