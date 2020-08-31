package domain;


import java.util.Date;

public class Issue implements Comparable<Issue>  {
    private int id;
    private String author;
    private String label;
    private String assignee;
    private boolean status;
    private Date dateTime;

    public Issue() {
    }

    public Issue(int id, String author, String label, String assignee, boolean status, Date dateTime) {
        this.id = id;
        this.author = author;
        this.label = label;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
