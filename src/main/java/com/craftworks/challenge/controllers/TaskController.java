package com.craftworks.challenge.controllers;

import com.craftworks.challenge.models.dtos.TaskDto;
import com.craftworks.challenge.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {
  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("/{id}")
  public TaskDto getTask(@PathVariable Long id) {
    return this.taskService.getTask(id);
  }

  @PostMapping(consumes = "application/json")
  public TaskDto addTask(@RequestBody TaskDto taskDto) {
    return this.taskService.addTask(taskDto);
  }

  @PutMapping(value = "/{id}", consumes = "application/json")
  public TaskDto updateTask(@RequestBody TaskDto taskDto, @PathVariable Long id) {
    return this.taskService.updateTask(id, taskDto);
  }

  @DeleteMapping("/{id}")
  public void deleteTask(@PathVariable Long id) {
    this.taskService.deleteTask(id);
  }

  @GetMapping
  public List<TaskDto> getAll() {
    return this.taskService.getAll();
  }

}
