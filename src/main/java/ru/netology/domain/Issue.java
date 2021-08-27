package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issue {
    private int id;
    private long data;
    private String author;
    private String label;
    private String assignee;
    private boolean closed;

    public String getAuthor() {
        return author;
    }

//    public Set getLabel() {
//        return label;
//    }

    public String getLabel() {
        return label;
    }

    public String getAssignee() {
        return assignee;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getId() {
        return id;
    }

}
