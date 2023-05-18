package com.springboot.service;

import com.springboot.Repository.UserRepository;
import com.springboot.WrapperObject.Department;
import com.springboot.WrapperObject.ResponseTemplate;
import com.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    private final RestTemplate restTemplate;


    public UserService(@Value("${department-service.base.url}") String baseUrl, RestTemplateBuilder builder) {
        this.restTemplate =builder
                .rootUri(baseUrl)
                .build();
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public ResponseTemplate getUser(Long id) {
        ResponseTemplate responseTemplate=new ResponseTemplate();
        User user=userRepository.findById(id).get();
        Department department=restTemplate.getForObject("/dep/{id}", Department.class,user.getDepId());

       /* responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);
        return responseTemplate;
*/
        return  responseTemplate=ResponseTemplate.builder()
                .user(user)
                .department(department)
                .build();
    }
    public  Department saveDep(){
        Department department1=new Department(2L,"frontENd","Banglore","F100");
        return restTemplate.postForObject("/dep/savedep",department1,Department.class);
    }

    public  ResponseTemplate saveBoth( ResponseTemplate responseTemplate){
        Long depId=responseTemplate.getUser().getDepId();
        Department department1=responseTemplate.getDepartment();
        department1.setId(depId);
         Department department=restTemplate.postForObject("/dep/savedep",department1,Department.class);
         User user=userRepository.save(responseTemplate.getUser());
         return ResponseTemplate.builder()
                 .user(user)
                 .department(department)
                 .build();

    }
}
