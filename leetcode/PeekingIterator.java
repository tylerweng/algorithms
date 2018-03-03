// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer next = null;
    boolean atEnd;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        advanceIterator();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        if (atEnd) {
            throw new NoSuchElementException();
        }
        Integer tmp = next;
        advanceIterator();
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return !atEnd;
    }

    private void advanceIterator() {
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            atEnd = true;
        }
    }

}