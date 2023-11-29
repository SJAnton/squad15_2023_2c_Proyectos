package com.back_end.service;

import com.back_end.model.Task;
import com.back_end.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask (Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> findByTaskId(Long id) {
        return taskRepository.findById(id);
    }

    public ArrayList<Task> findByProjectId(Long project_id) {
        List<Task> taskList = taskRepository.findAll();
        ArrayList<Task> projectTasks = new ArrayList<Task>();

        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (Objects.equals(task.getProject().getId(), project_id)) {
                projectTasks.add(task);
            }
        }
        return projectTasks;
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void deleteByTaskId(Long id) {
        taskRepository.deleteById(id);
    }
}