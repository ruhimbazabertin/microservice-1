package com.mic.userservices.service;

import com.mic.userservices.VO.Department;
import com.mic.userservices.VO.ResponseTemplateVO;
import com.mic.userservices.data.User;
import com.mic.userservices.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RestTemplate restTemplate;

    public User createUser(User user) {
        log.info("INSIDE CREATEUSER OF USERCONTROLLER");
        return userRepo.save(user);

    }

    public ResponseTemplateVO getUserWithDepart(Long id) {
        log.info("INSIDE FINDUSERWITHDEPART OF USERCONTROLLER");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepo.getById(id);

        //call department Microservice here

      //  Department depart = restTemplate.getForObject("http://localhost:8080/api/v1/departments/"+ user.getDepartId(),Department.class);
        //CALL THE NAME OF SERVICE YOU WANT BY REPLACING localhost:8080
        Department depart = restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/v1/departments/"+ user.getDepartId(),Department.class);

        vo.setUser(user);
        vo.setDepartment(depart);
        return vo;
    }
}
