package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private List<Integer> list;
    private int currentPosition;

    private Optional<Integer> getElementMovePosition(final int position) {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            this.currentPosition = position;
            return Optional.of(this.list.get(this.currentPosition));
        }
    }

    public SimpleCircularList() {
        this.list = new ArrayList<>();
        this.currentPosition = -1;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return getElementMovePosition(this.currentPosition + 1 >= size() ? 0 : this.currentPosition + 1);
    }

    @Override
    public Optional<Integer> previous() {
        return getElementMovePosition(this.currentPosition - 1 >= 0 ? this.currentPosition - 1 : size() - 1);
    }

    @Override
    public void reset() {
        this.currentPosition = -1;
    }
}
