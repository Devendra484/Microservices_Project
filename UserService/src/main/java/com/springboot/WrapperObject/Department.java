package com.springboot.WrapperObject;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Long id;

    private String name;
    private String address;
    private String code;
}
