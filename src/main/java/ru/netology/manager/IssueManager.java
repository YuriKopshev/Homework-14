package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class IssueManager {
    private IssueRepository repository;

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void issueAdd(Issue issue) {
        repository.save(issue);
    }

    public Collection<Issue> getAllIssues() {
        return repository.findAll();
    }

    public Collection<Issue> findAllOpen() {
        return repository.findAllOpen();
    }

    public Collection<Issue> findAllClosed() {
        return repository.findAllClosed();
    }

    public void openIssue(int id) {
        repository.open(id);
    }

    public void closeIssue(int id) {
        repository.closed(id);
    }

    public Predicate<Issue> getFilterByAuthor(String author) {
        return p -> p.getAuthor().equalsIgnoreCase(author);
    }

    public Predicate<Issue> getFilterByLabel(String labels) {
        return p -> p.getLabels().contains(labels);
    }

    public Predicate<Issue> getFilterByAssignee(String assignee) {
        return p -> p.getAssignee().contains(assignee);
    }


    public List<Issue> filterByAuthor(String author) {
        return filter(getFilterByAuthor(author));
    }
    public List<Issue> filterByLabel(String label) {
        return filter(getFilterByLabel(label));
    }
    public List<Issue> filterByAssignee(String assignee) {
        return filter(getFilterByAssignee(assignee));
    }




    public List<Issue> filter(Predicate<Issue> predicate) {
        return getAllIssues().stream()
                .filter(predicate)
                .collect(Collectors.<Issue>toList());
    }

    public Collection<Issue> sortByDate(){
        List<Issue>list = new ArrayList<>(getAllIssues());
        Collections.sort(list);
        return list;
    }


}
