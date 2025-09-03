package Nami.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    void addAndGet_increasesSizeAndStoresTask() {
        TaskList tl = new TaskList();
        toDo t1 = new toDo("read book");
        tl.add(t1);

        assertEquals(1, tl.size(), "Size should be 1 after adding");
        assertSame(t1, tl.get(0), "Stored task should be retrievable");
        assertEquals("read book", tl.get(0).getDescription());
    }

    @Test
    void remove_returnsRemovedAndShrinks() {
        TaskList tl = new TaskList();
        toDo t1 = new toDo("A");
        toDo t2 = new toDo("B");
        tl.add(t1);
        tl.add(t2);

        Tasks removed = tl.remove(0);
        assertSame(t1, removed, "remove should return the removed task");
        assertEquals(1, tl.size(), "Size should shrink after remove");
        assertEquals("B", tl.get(0).getDescription(), "Remaining task should be B");
    }
}
