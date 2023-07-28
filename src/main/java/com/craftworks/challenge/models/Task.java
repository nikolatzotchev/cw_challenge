package com.craftworks.challenge.models;

import com.craftworks.challenge.enums.Priority;
import com.craftworks.challenge.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Task {

  @Id
  @GeneratedValue
  private long id;
  @CreatedDate
  private Date createdAt;
  @LastModifiedDate
  private Date updatedAt;

  private Date dueDate;

  private Date resolvedAt;

  private String title;

  private String description;

  private Priority priority;

  private Status status;

  public Task(Date dueDate, String title, String description, Priority priority, Status status) {
    this.dueDate = dueDate;
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.status = status;
  }

  public Task() {

  }
}
