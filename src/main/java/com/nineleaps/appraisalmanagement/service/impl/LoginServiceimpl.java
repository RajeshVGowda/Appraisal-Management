package com.nineleaps.appraisalmanagement.service.impl;

import com.nineleaps.appraisalmanagement.dao.LoginRepo;
import com.nineleaps.appraisalmanagement.exception.DataException;
import com.nineleaps.appraisalmanagement.pojo.Employee;
import com.nineleaps.appraisalmanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private LoginRepo loginRepo;
    @Override
    public Employee login(String email,String password) throws DataException {

        Employee employee = loginRepo.findByEmailIdAndPassword(email, password);
        if(!(employee!=null)){
            throw new DataException("error.login","Invalid Username",HttpStatus.BAD_REQUEST);
        }
        return employee;
    }
}
