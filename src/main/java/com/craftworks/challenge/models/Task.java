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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public Date getResolvedAt() {
    return resolvedAt;
  }

  public void setResolvedAt(Date resolvedAt) {
    this.resolvedAt = resolvedAt;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Priority getPriority() {
    return priority;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
