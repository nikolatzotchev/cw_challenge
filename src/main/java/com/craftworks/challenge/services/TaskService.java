package com.craftworks.challenge.services;

import com.craftworks.challenge.models.Task;
import com.craftworks.challenge.models.dtos.TaskDto;
import com.craftworks.challenge.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
  private final ModelMapper modelMapper;
  private final TaskRepository taskRepository;

  public TaskService(ModelMapper modelMapper, TaskRepository taskRepository) {
    this.modelMapper = modelMapper;
    this.taskRepository = taskRepository;
  }

  public TaskDto addTask(TaskDto taskDto) {
    return this.modelMapper.map(this.taskRepository.save(this.modelMapper.map(taskDto, Task.class)), TaskDto.class);
  }

  public void deleteTask(Long id) {
    this.taskRepository.deleteById(id);
  }

  public TaskDto getTask(Long id) {
    return this.modelMapper.map(this.taskRepository.getReferenceById(id), TaskDto.class);
  }

  public TaskDto updateTask(Long id, TaskDto taskDto) {
    Optional<Task> task = this.taskRepository.findById(id);
    if (task.isPresent()) {
      Task t = task.get();
      this.modelMapper.map(t, taskDto);
      return this.modelMapper.map(this.taskRepository.save(t), TaskDto.class);
    } else {
      return this.modelMapper.map(this.taskRepository.save(this.modelMapper.map(taskDto, Task.class)), TaskDto.class);
    }
  }

  public List<TaskDto> getAll() {
    return this.modelMapper.map(this.taskRepository.findByOrderByCreatedAtAsc(), new TypeToken<List<TaskDto>>() {}.getType());
  }
}
