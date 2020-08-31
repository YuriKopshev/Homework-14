package manager;

import domain.Issue;
import repository.IssueRepository;

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
        return p -> p.getLabel().equalsIgnoreCase(labels);
    }

    public Predicate<Issue> getFilterByAssignee(String assignee) {
        return p -> p.getAssignee().equalsIgnoreCase(assignee);
    }


//    public List<Issue> filterBy(List<Issue> issues, Predicate<Issue> predicate) {
//        return issues.stream()
//                .filter(predicate)
//                .collect(Collectors.<Issue>toList());
//    }
//
//    public Set<Issue> filterByLabels(List<Issue> issues, Predicate<Issue> predicate) {
//        Set<Issue> filteredList = new HashSet<>();
//        for (Issue i : issues) {
//            if (predicate.test(i)) {
//                filteredList.add(i);
//            }
//        }
//        return filteredList;
//    }
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


}
