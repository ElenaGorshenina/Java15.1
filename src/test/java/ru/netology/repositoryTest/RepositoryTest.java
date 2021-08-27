package ru.netology.repositoryTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryTest {
    private Repository repository = new Repository();
    private Issue issue1 = new Issue(1, 2020_08_12_10, "Petrov", "bag1", "Petrov", true);
    private Issue issue2 = new Issue(2, 2020_08_15_01, "Petrov", "bag2", "Petrov", false);
    private Issue issue3 = new Issue(3, 2020_08_16_12, "Petrov", "bag3", "Petrov", true);

    @BeforeEach
    public void setUp() {
        repository.save(issue1);
        repository.save(issue2);
        repository.save(issue3);

    }

    @Test
    void saveIssueTest() {
        Collection<Issue> issues = new ArrayList<>();
        issues.add(new Issue());
        issues.add(new Issue());
        repository.saveAll(issues);
    }

    @Test
    void removeByIdTest() {
        repository.removeById(2);
        Collection<Issue> actual = repository.findAll();
        Collection<Issue> expected = Arrays.asList(issue1, issue3);
        assertEquals(expected, actual);
    }

    @Test
    void closedIssueTest() {
        Collection<Issue> actual = repository.closedIssue();
        Collection<Issue> expected = Arrays.asList(issue1, issue3);
        assertEquals(expected, actual);
    }

    @Test
    void openedIssueTest() {
        Collection<Issue> actual = repository.openedIssue();
        Collection<Issue> expected = Arrays.asList(issue2);
        assertEquals(expected, actual);
    }

}
