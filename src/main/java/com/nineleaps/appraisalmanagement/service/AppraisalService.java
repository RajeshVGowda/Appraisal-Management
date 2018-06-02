package com.nineleaps.appraisalmanagement.service;

import com.nineleaps.appraisalmanagement.exception.DataException;
import com.nineleaps.appraisalmanagement.pojo.AppraisalForm;
import com.nineleaps.appraisalmanagement.pojo.Employee;

import java.util.List;

public interface AppraisalService {

    AppraisalForm saveAppraisalData(AppraisalForm appraisalForm,int userId) throws DataException;

    AppraisalForm getAppraisalData(Integer userId) throws DataException;

    List<Employee> getRepoteeInfo(Integer userId) throws DataException;
}
