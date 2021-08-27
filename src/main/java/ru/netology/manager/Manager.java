package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.NotFoundIdException;
import ru.netology.repository.Repository;

import java.util.*;

public class Manager {
    private Collection<Issue> issues = new ArrayList<>();
    private Collection<String> tag = new HashSet<>();
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.save(issue);
    }


//    public Collection<Issue> findAll() {
//        return issues;
//    }

    public Collection<Issue> editClosedById(int id) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.findAll()) {
            if (issue.getId() == id) {
                Issue[] tmp = new Issue[result.length + 1];
                if (issue.isClosed() == false) {
                    issue.setClosed(true);
                } else {
                    issue.setClosed(false);
                }
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
//            else{
//                throw new NotFoundIdException("Element with id: " + id + " not found");
//            }
        }
        return Arrays.asList(result);
    }

    public Collection<Issue> filterByAuthor(String author) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.findAll()) {
            if (issue.getAuthor() == author) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            } else {
            }
        }
        return Arrays.asList(result);
    }

    public Collection<Issue> filterByAssignee(String assignee) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.findAll()) {
            if (issue.getLabel() == assignee) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            } else {
            }
        }
        return Arrays.asList(result);
    }

    public Collection<Issue> filterByLabel(String label) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.findAll()) {
            if (issue.getLabel() == label) {
                Issue[] tmp = new Issue[result.length + 1];
                tmp[tmp.length - 1] = issue;
                result = tmp;
            } else {
            }
        }
        return Arrays.asList(result);
    }

}

