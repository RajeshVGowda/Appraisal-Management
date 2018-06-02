package com.nineleaps.appraisalmanagement.controller;

import com.nineleaps.appraisalmanagement.exception.DataException;
import com.nineleaps.appraisalmanagement.pojo.Employee;
import com.nineleaps.appraisalmanagement.pojo.LoginBean;
import com.nineleaps.appraisalmanagement.service.LoginService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController extends AbstractRestService {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginBean loginBean) {
        try {
            if(loginBean==null){
                buildError(new DataException("error.login", "Invalid email Id and password ", HttpStatus.BAD_REQUEST));
            }
            String email=loginBean.getEmail();
            String password=loginBean.getPassword();
            if ((Strings.isEmpty(email) && Strings.isBlank(email)) || (Strings.isEmpty(password) && Strings.isBlank(password))) {
                buildError(new DataException("error.login", "Invalid email Id and password ", HttpStatus.BAD_REQUEST));
            }
            Employee employee = loginService.login(email, password);
            employee.setPassword(null);
            return buildResponse(employee);
        } catch (final DataException e) {
            return buildError(e);
        }
    }
}
