package repository;

import domain.Issue;

import java.util.*;

public class IssueRepository {
    private Collection<Issue> issues = new ArrayList<>();


    public Collection<Issue> findAll() {
        return issues;
    }

    public void save(Issue issue) {
        issues.add(issue);
    }

    public Collection<Issue> findAllOpen() {
        issues.removeIf(i -> !i.isStatus());
        return issues;
    }

    public Collection<Issue> findAllClosed() {
        issues.removeIf(Issue::isStatus);
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


}
