package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Repository {
    private Collection<Issue> issues = new ArrayList<>();

    public void save(Issue issue) {
        issues.add(issue);
    }

    public void saveAll(Collection<Issue> issues){
        this.issues.addAll(issues);
    }

    public Collection<Issue> findAll() {
        return issues;
    }

    public void removeById(int id) {
        issues.removeIf(el -> el.getId() == id);
    }

    public void removeAll(Collection<Issue> issues){
        this.issues.removeAll(issues);
    }

    public Collection<Issue> closedIssue () {
        Issue[] result = new Issue[0];
        for (Issue issue : findAll()) {
            if (issue.isClosed() == true) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            } else {
            }
        }
        return Arrays.asList(result);
    }

    public Collection<Issue> openedIssue () {
        Issue[] result = new Issue[0];
        for (Issue issue : findAll()) {
            if (issue.isClosed() == false) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            } else {
            }
        }
        return Arrays.asList(result);
    }


}
