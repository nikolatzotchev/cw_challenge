package com.craftworks.challenge.scheduling;

import com.craftworks.challenge.enums.Priority;
import com.craftworks.challenge.enums.Status;
import com.craftworks.challenge.models.Task;
import com.craftworks.challenge.repository.TaskRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class ScheduledTasks {

	@Autowired
	private TaskRepository taskRepository;

	private final Faker faker = new Faker();

	@Scheduled(fixedRate = 15000)
	public void scheduleTask() {
		taskRepository.save(new Task(faker.date().future(10000, TimeUnit.MINUTES), faker.medical().diseaseName(), faker.medical().symptoms(), Priority.HIGH, Status.OPEN));
	}
}