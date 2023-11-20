package br.com.davioliveira.todolist.user;


import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data; //Esse import do lombok cria os get e set.

@Data //chama o lombok
@Entity(name = "tb_users")
public class UserModel {
    
    @Id // define como chave primaria
    @GeneratedValue(generator = "UUID") // auto geração de ID usando o padrão UUID
    private UUID id;

    @Column(unique = true) //define como valor unico
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
