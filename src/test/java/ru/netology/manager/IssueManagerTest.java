package ru.netology.manager;

import ru.netology.domain.Issue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);
    private Issue issue1 = new Issue(1, "Yuri", new HashSet<>(Arrays.asList("component test", "type task")), new HashSet<>(Arrays.asList("Ivan", "Sergey")), true, new Date());
    private Issue issue2 = new Issue(2, "Yuri", new HashSet<>(Arrays.asList("component java", "type task")), new HashSet<>(Arrays.asList("Irina")), true, new Date());
    private Issue issue3 = new Issue(3, "Petr", new HashSet<>(Arrays.asList("component kotlin", "type task")), new HashSet<>(Arrays.asList("Ivan", "Sergey")), true, new Date());
    private Issue issue4 = new Issue(4, "Petr", new HashSet<>(Arrays.asList("theme build", "type task")), new HashSet<>(Arrays.asList("Gary", "Irina")), false, new Date());

    @BeforeEach
    void setUp() {
        manager.issueAdd(issue1);
        manager.issueAdd(issue2);
        manager.issueAdd(issue3);
        manager.issueAdd(issue4);

    }


    @Test
    void shouldGetAllIssues() {
        Collection<Issue> actual = manager.getAllIssues();
        Collection<Issue> expected = List.of(issue1, issue2, issue3, issue4);
        assertEquals(actual, expected);
    }

    @Test
    void shouldFindAllOpen() {
        Collection<Issue> actual = manager.findAllOpen();
        Collection<Issue> expected = List.of(issue1, issue2, issue3);
        assertEquals(actual, expected);

    }

    @Test
    void shouldFindAllClosed() {
        Collection<Issue> actual = manager.findAllClosed();
        Collection<Issue> expected = List.of(issue4);
        assertEquals(actual, expected);
    }

    @Test
    void openIssue() {
        manager.openIssue(4);
        boolean condition = issue4.isStatus();
        assertTrue(condition);

    }

    @Test
    void closeIssue() {
        manager.closeIssue(1);
        boolean condition = issue1.isStatus();
        assertFalse(condition);
    }

    @Test
    void shouldFilterByAuthor() {
        List<Issue> actual= manager.filterByAuthor("Yuri");
        Collection<Issue> expected = List.of(issue1,issue2);
        assertEquals(actual, expected);

    }

    @Test
    void shouldFilterByLabels() {
        Collection<Issue> actual=  manager.filterByLabel("component java");
        Collection<Issue> expected = List.of(issue2);
        assertEquals(actual, expected);

    }
    @Test
    void shouldFilterByAssignee() {
        List<Issue> actual= manager.filterByAssignee("Irina");
        Collection<Issue> expected = List.of(issue2,issue4);
        assertEquals(actual, expected);
    }
    @Test
    void shouldSort() {
        Collection<Issue> actual = manager.sortByDate();
        Collection<Issue> expected = List.of(issue1, issue2, issue3, issue4);
        assertEquals(actual, expected);
    }
}