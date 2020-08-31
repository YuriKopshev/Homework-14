package repository;

import domain.Issue;

import java.util.*;
import java.util.function.Predicate;

public class IssueRepository {
    private Collection<Issue> issues = new ArrayList<>();


    public Collection<Issue> findAll() {
        return issues;
    }

    public void save(Issue issue) {
        issues.add(issue);
    }

    public Collection<Issue> findAllOpen() {
        for (Issue i : issues) {
            if (!i.isStatus()) {
                issues.remove(i);
            }
        }
        return issues;
    }

    public Collection<Issue> findAllClosed() {
        for (Issue i : issues) {
            if (i.isStatus()) {
                issues.remove(i);
            }
        }
        return issues;

    }

    public void closed(int id) {
        for (Issue i : issues) {
            if (i.getId() == id) {
                i.setStatus(false);
            }
        }
    }

    public void open(int id) {
        for (Issue i : issues) {
            if (i.getId() == id) {
                i.setStatus(true);
            }
        }
    }

    public Predicate<Issue> getByAuthor(String author) {
        return p -> p.getAuthor().equalsIgnoreCase(author);
    }

    public Predicate<Issue> getByLabel(String labels) {
        return p -> p.getLabel().equalsIgnoreCase(labels);
    }

    public Predicate<Issue> getByAssignee(String assignee) {
        return p -> p.getAssignee().equalsIgnoreCase(assignee);
    }


}
