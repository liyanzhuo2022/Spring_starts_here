package com.springstartshere.example2;

import com.springstartshere.example2.proxies.EmailCommentNotificationProxy;
import com.springstartshere.example2.repositories.DBCommentRepository;
import com.springstartshere.example2.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // naivePublish();

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        SpringPublish(context);
    }

    private static void naivePublish() {
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();

        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        var comment = new Comment();
        comment.setAuthor("Laurentiu");
        comment.setText("Demo comment");

        commentService.publishComment(comment);
    }

    private static void SpringPublish(AnnotationConfigApplicationContext context) {
        var comment = new Comment();
        comment.setAuthor("Laurentiu");
        comment.setText("Demo comment");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
