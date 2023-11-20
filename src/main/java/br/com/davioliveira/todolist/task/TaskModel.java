package br.com.davioliveira.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

    /**
     * ID
     * Tarefas
     * Usuário
     * Descrição
     * Título
     * Data de Inicio
     * Data de término
     * Prioridade
     */

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUOD")
     private UUID id;
     private String description;

     @Column(length = 50) //Limnite de caracteres
     private String title;
     private LocalDateTime startAt;
     private LocalDateTime endAt;
     private String priority;
     private UUID idUser;
     
    @CreationTimestamp
     private LocalDateTime createAt;

    public void setTitle(String title) throws Exception{
        if(title.length() >= 50){
            throw new Exception("O campo titulo só poder ter nbo maximo 50 caracteres");
        }
        this.title = title;
    }

}
