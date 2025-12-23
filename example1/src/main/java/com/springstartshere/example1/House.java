package com.springstartshere.example1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class House {

    private String name = "Coffee Shop";

    /**
     * 在字段的Autowire:
     * 通过@Autowired，我们要求Spring从context中提供这个bean，
     * 并且把它设置为这个字段的值
     * Note:
     * 这种字段自动注入在生产环境中是不被推崇的，
     * 因为这样不能使字段final，不容易管理值
     * */
    // @Autowired
    private final Puppy puppy;

    /**
     * 在constructor的Autowire:
     * 最被推荐的注入方法
     * 方便unit test
     * Note:
     * Java 保证：
     * 构造器结束前，对象对外不可见
     * final 字段在构造器中赋值一次
     * 构造完成后，对象是不可变一致状态
     * */
    @Autowired
    public House(Puppy puppy) {
        this.puppy = puppy;
    }

    /**
     * 通过setter进行Autowire：
     * 最不推荐的方式：不能使字段final，也不能方便测试
     * */
//    public void setPuppy(Puppy puppy) {
//        this.puppy = puppy;
//    }
}
