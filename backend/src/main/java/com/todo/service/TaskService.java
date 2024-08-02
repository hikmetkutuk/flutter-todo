package com.todo.service;

import com.todo.dto.TaskRequest;
import com.todo.dto.TaskResponse;
import com.todo.model.TaskItem;
import com.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse createTask(TaskRequest request) {
        TaskItem taskItem = new TaskItem();
        taskItem.setTitle(request.title());
        taskItem.setDone(false);
        taskRepository.save(taskItem);
        return new TaskResponse(taskItem.getId(), taskItem.getTitle(), taskItem.isDone());
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(task -> new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.isDone()
                ))
                .collect(Collectors.toList());
    }
}
