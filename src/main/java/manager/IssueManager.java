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

    public void issueAdd(Issue issue){
        repository.save(issue);
    }
    public Collection<Issue> getAllIssues(){
        return repository.findAll();
    }

    public Collection<Issue> findAllOpen() {
    return repository.findAllOpen();
    }
    public Collection<Issue> findAllClosed() {
        return repository.findAllClosed();
    }
    public void openIssue(int id){
        repository.open(id);
    }

    public void closeIssue(int id) {
        repository.closed(id);
    }



    public Predicate<Issue> getByAuthor(String author) {
        return repository.getByAuthor(author);
    }
    public Predicate<Issue> getByLabel(String labels) {
        return repository.getByLabel(labels);
    }
    public Predicate<Issue> getByAssignee(String assignee) {
        return repository.getByAssignee(assignee);
    }
    public static List<Issue> filterByAuthor(List<Issue>issues, Predicate<Issue> predicate) {
        return issues.stream()
                .filter(predicate)
                .collect(Collectors.<Issue>toList());
    }
    public static Set<Issue> filterByLabels(List<Issue>issues, Predicate<Issue> predicate) {
        Set<Issue> filteredList = new HashSet<>();
        for(Issue i:issues){
            if(predicate.test(i)){
                filteredList.add(i);
            }
        }
        return filteredList;
    }
    public static Set<Issue> filterByAssignee(List<Issue>issues, Predicate<Issue> predicate) {
        Set<Issue> filteredList = new HashSet<>();
        for(Issue i:issues){
            if(predicate.test(i)){
                filteredList.add(i);
            }
        }
        return filteredList;
    }







}
