package com.mason.ATD.chapter06.priority;

import java.sql.Date;

/**
 * 安排日期处理类
 *
 * @author ShiYong
 * @create 2022-04-12 9:50
 **/
public class AssignmentLog {
    private PriorityQueueInterface<Assignment> log;

    public AssignmentLog() {
        log = new PriorityQueue<>();
    }

    public void addProject(Assignment assignment) {
        log.add(assignment);
    }

    public void addProject(String courseCode, String task, Date dueDate) {
        Assignment newAssignment = new Assignment(courseCode, task, dueDate);
        addProject(newAssignment);

    }

    public Assignment getNextProject() {
        return log.peek();
    }

    public Assignment removeNextProject() {
        return log.remove();
    }

}
