package com.tweteroo.api.model;

import com.tweteroo.api.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {

    public User(UserDTO data) {
      this.username = data.username();
      this.avatar = data.avatar();
    }

    public User() {
     
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String avatar;

    public String getUsername(){
      return this.username;
    }

    public String getAvatar(){
      return this.avatar;
    }

}
