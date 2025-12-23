package com.springstartshere.example2.services;

import com.springstartshere.example2.Comment;
import com.springstartshere.example2.proxies.CommentNotificationProxy;
import com.springstartshere.example2.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    /**
     * Spring通过构造器创建bean并注入。
     * 虽然CommentService是通过接口声明对其他component的依赖，
     * 但是Spring可以在context里找到实现了这两个接口的已创建的bean。
     * */
    public CommentService(CommentRepository commentRepository,
            @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}