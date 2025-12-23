package com.springstartshere.example2.repositories;
import com.springstartshere.example2.Comment;

/**
 * 接口是抽象的，不能被实例化，
 * 所以不需要在接口上加@Component.
 * 只加在Spring需要用来创建实例并加入context的类上。
 * */
public interface CommentRepository {
    void storeComment(Comment comment);
}
