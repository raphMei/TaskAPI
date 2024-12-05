package com.raphmei.taskapi.service;

import com.raphmei.taskapi.model.Task;
import com.raphmei.taskapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Créer une tâche
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Obtenir toutes les tâches
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Obtenir une tâche par ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Supprimer une tâche
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Mettre à jour une tâche
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        return taskRepository.save(task);
    }
}
