package manager;

import domain.Issue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);
    private Issue issue1 = new Issue(1, "Yuri", new HashSet<>(Arrays.asList("component test", "type task")), "Ivan", true, new Date());
    private Issue issue2 = new Issue(2, "Yuri", new HashSet<>(Arrays.asList("component java", "type task")), "Irina", true, new Date());
    private Issue issue3 = new Issue(3, "Petr", new HashSet<>(Arrays.asList("component kotlin", "type task")), "Ivan", true, new Date());
    private Issue issue4 = new Issue(4, "Petr", new HashSet<>(Arrays.asList("theme build", "type task")), "Gary", false, new Date());

    @BeforeEach
    void setUp() {
        repository.save(issue1);
        repository.save(issue2);
        repository.save(issue3);
        repository.save(issue4);
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
    void ShouldFilterByAuthor() {
        List<Issue> actual= manager.filterByAuthor("Yuri");
        Collection<Issue> expected = List.of(issue1,issue2);
        assertEquals(actual, expected);

    }

    @Test
    void ShouldFilterByLabels() {
        Collection<Issue> actual=  manager.filterByLabel("component java");
        Collection<Issue> expected = List.of(issue2);
        assertEquals(actual, expected);

    }
    @Test
    void ShouldFilterByAssignee() {
        List<Issue> actual= manager.filterByAssignee("Irina");
        Collection<Issue> expected = List.of(issue2);
        assertEquals(actual, expected);

    }
}