package com.nineleaps.appraisalmanagement.service;

import com.nineleaps.appraisalmanagement.exception.DataException;
import com.nineleaps.appraisalmanagement.pojo.Employee;

public interface LoginService {

    Employee login(String email,String password) throws DataException;
}
