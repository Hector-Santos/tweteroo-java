package com.tweteroo.api.model;



import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {
    
    public Tweet(String username, String avatar, TweetDTO data) {
        this.username = username;
        this.avatar = avatar;
        this.text = data.text();
      }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String avatar;

    @Column(length = 500, nullable = false)
    private String text;
}
