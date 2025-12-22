package com.springstartshere.example1;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
/**通过@Component（实体类）+ @ComponentScan（配置类）来把Bean加入Spring Context
 * 对于Spring来说，并不自动扫描带有stereotype annotations的classes，
 * 需要在配置类加入@ComponentScan，告诉Spring需要扫描哪些包
 * */
public class Puppy {

    private String name;

    @PostConstruct
    public void init() {
        this.name = "Doggy";
    }

}
