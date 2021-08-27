package ru.netology.managerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.manager.Manager;
import ru.netology.repository.NotFoundIdException;
import ru.netology.repository.Repository;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManagerTest {
    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);
    private Issue issue1 = new Issue(1, 2020_08_12_10, "Petrov", "bag1", "Nazarov", true);
    private Issue issue2 = new Issue(2, 2020_08_15_01, "Petrov", "bag2", "Matveev", false);
    private Issue issue3 = new Issue(3, 2020_08_16_12, "Sidorov", "bag3", "Petrov", true);

    @BeforeEach
    public void setUp() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);

    }

    @Test
    public void editClosedToOpenedTest() {
        Collection<Issue> issueTest = manager.editClosedById(3);
        boolean actual = issue3.isClosed();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void editClosedToClosedTest() {
        Collection<Issue> issueTest = manager.editClosedById(2);
        boolean actual = issue2.isClosed();
        boolean expected = true;
        assertEquals(expected, actual);
    }

//    @Test
//    public void editClosedToNotFoundIDTest() {
//        assertThrows(NotFoundIdException.class, () -> {
//            manager.editClosedById(20);
//        });
//    }

    @Test
    void filterByAuthorTest() {
        Collection<Issue> actual = manager.filterByAuthor("Petrov");
        Collection<Issue> expected = Arrays.asList(issue1, issue2);
        assertEquals(expected, actual);
    }

    @Test
    void filterByAssigneeTest() {
        Collection<Issue> actual = manager.filterByAssignee("Petrov");
        Collection<Issue> expected = Arrays.asList(issue3);
        assertEquals(expected, actual);
    }

    @Test
    void filterByLabelTest() {
        Collection<Issue> actual = manager.filterByLabel("bag2");
        Collection<Issue> expected = Arrays.asList(issue2);
        assertEquals(expected, actual);
    }
}
