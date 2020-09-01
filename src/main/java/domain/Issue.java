package domain;


import java.util.Date;
import java.util.Set;

public class Issue implements Comparable<Issue> {
    private int id;
    private String author;
    private Set<String> labels;
    private String assignee;
    private boolean status;
    private Date dateTime;


    public Issue() {
    }

    public Issue(int id, String author, Set<String> labels, String assignee, boolean status, Date dateTime) {
        this.id = id;
        this.author = author;
        this.labels = labels;
        this.assignee = assignee;
        this.status = status;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public int compareTo(Issue issue) {
        return getDateTime().compareTo(issue.getDateTime());
    }
//    Collections.sort(myList);
}
