package com.picture_of_day.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    private String author;
    private String feedback;
    private long likes;
    private LocalDateTime postTime;

    @Override
    public boolean supports(Class<?> clazz) {
        return Comment.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        List<String> dirtyList = new ArrayList<>(
                Arrays.asList("buồi", "dái", "chết", "tử vong", "lồn", "đụ", "địt", "cặc", "cứt", "đéo", "thái dúi", "dmm")
        );
        Comment comment = (Comment) target;
        String feedback = comment.getFeedback();
        dirtyList.forEach(element -> {
            if (feedback.toUpperCase().contains(element.toUpperCase())) {
                errors.rejectValue("feedback", "comment.feedback.dirty");
                return;
            }
        });
    }
}
