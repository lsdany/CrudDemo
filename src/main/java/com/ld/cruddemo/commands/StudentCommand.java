package com.ld.cruddemo.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author luisdany
 */
@Getter
@Setter
@NoArgsConstructor
public class StudentCommand {

    private Long id;
    private String name;
    private Integer age;
    private String email;

}
