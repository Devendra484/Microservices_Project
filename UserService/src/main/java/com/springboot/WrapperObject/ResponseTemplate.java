package com.springboot.WrapperObject;

import com.springboot.model.User;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {

    private User user;
    private  Department department;
}
