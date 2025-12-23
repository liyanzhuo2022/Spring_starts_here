package com.springstartshere.example2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 这个对象没有任何依赖关系，只是纯粹的数据载体，
 * 不需要被Spring作为bean管理。
 * */
public class Comment {
    private String author;
    private String text;
}
