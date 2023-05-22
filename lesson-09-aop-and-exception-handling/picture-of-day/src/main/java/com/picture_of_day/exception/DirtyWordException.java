package com.picture_of_day.exception;

import com.picture_of_day.model.Comment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
public class DirtyWordException extends Exception{
    private Comment comment;

    @Override
    public String getMessage() {
        return String.format("Author %s used any dirty words in feedback \"%s\" at %s",
                comment.getAuthor(),
                comment.getFeedback(),
                comment.getPostTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a")));
    }
}
