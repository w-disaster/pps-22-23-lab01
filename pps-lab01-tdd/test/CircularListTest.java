import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.*;

import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    private void checkNext(final int expected) {
        Optional<Integer> next = circularList.next();
        assertTrue(next.isPresent());
        assertEquals(expected, next.get());
    }

    private void checkPrevious(final int expected) {
        Optional<Integer> previous = circularList.previous();
        assertTrue(previous.isPresent());
        assertEquals(expected, previous.get());
    }

    @BeforeEach
    void beforeEach() {
        circularList = new SimpleCircularList();
    }

    @Test
    void testInitiallyEmpty() {
        assertTrue(circularList.isEmpty());
        assertEquals(Optional.empty(), circularList.next());
        assertEquals(Optional.empty(), circularList.previous());
    }

    @Test
    void testAddElementsAndSize() {
        int numElements = 10;
        for (int i = 0; i < numElements; i++) {
            circularList.add(i);
        }
        assertEquals(numElements, circularList.size());
    }

    @Test
    void testMultipleNext() {
        for (int i = 0; i < 5; i++) {
            circularList.add(i);
            checkNext(i);
        }

        for (int i = 0; i < 3; i++) {
            checkNext(i);
        }
    }

    @Test
    void testMultiplePrevious() {
        for (int i = 0; i < 5; i++) {
            circularList.add(i);
            for (int k = i; k >= 0; k--) {
                checkPrevious(k);
            }
        }
    }

    @Test
    void testNextPrevious() {
        int firstRandomValue = new Random().nextInt();
        circularList.add(firstRandomValue);

        checkNext(firstRandomValue);
        checkPrevious(firstRandomValue);

        int secondRandomValue = new Random().nextInt();
        circularList.add(secondRandomValue);

        checkNext(secondRandomValue);
        checkNext(firstRandomValue);
        checkPrevious(secondRandomValue);
    }

    @Test
    void testReset() {
        int firstRandomValue = new Random().nextInt();
        circularList.add(firstRandomValue);
        checkNext(firstRandomValue);

        int secondRandomValue = new Random().nextInt();
        circularList.add(secondRandomValue);

        circularList.reset();
        checkNext(firstRandomValue);
    }

}
