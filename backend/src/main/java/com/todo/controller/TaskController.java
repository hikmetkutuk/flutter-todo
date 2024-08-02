package com.todo.controller;

import com.todo.dto.TaskRequest;
import com.todo.dto.TaskResponse;
import com.todo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Creates a new task using the provided TaskRequest.
     *
     * @param request the TaskRequest object containing task details
     * @return a ResponseEntity with the TaskResponse of the created task
     */
    @PostMapping("/create")
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest request) {
        return ResponseEntity.ok(taskService.createTask(request));
    }

    /**
     * Get all tasks.
     *
     * @return list of TaskResponse objects
     */
    @GetMapping("/list")
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    /**
     * Update a task by its ID.
     *
     * @param id the ID of the task to update
     * @return the updated task response
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.updateTask(id));
    }

    /**
     * Delete a task by its ID.
     *
     * @param id the ID of the task to delete
     * @return the deleted task response
     */
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }
}
