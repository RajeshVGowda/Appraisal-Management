package com.nineleaps.appraisalmanagement.service.impl;

import com.nineleaps.appraisalmanagement.dao.AppraisalRepo;
import com.nineleaps.appraisalmanagement.dao.LoginRepo;
import com.nineleaps.appraisalmanagement.exception.DataException;
import com.nineleaps.appraisalmanagement.pojo.AppraisalForm;
import com.nineleaps.appraisalmanagement.pojo.Employee;
import com.nineleaps.appraisalmanagement.service.AppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppraisalServiceImpl implements AppraisalService {

    @Autowired
    private AppraisalRepo appraisalRepo;

    @Autowired
    private LoginRepo loginRepo;

    @Override
    public AppraisalForm saveAppraisalData(AppraisalForm appraisalForm,int userId) throws DataException {
        Employee employee = loginRepo.findByUserId(userId);
        if((employee==null)){
            throw new DataException("error.save.appraisal","Invalid UserId",HttpStatus.BAD_REQUEST);
        }
        employee.setEditable(false);
        appraisalForm.setEmployee(employee);

        return appraisalRepo.save(appraisalForm);
    }

    @Override
    public AppraisalForm getAppraisalData(Integer userId) throws DataException{

        Employee employee = loginRepo.findByUserId(userId);
        System.out.println(employee.getEmailId());
        if((employee==null)){
            throw new DataException("error.save.appraisal","Invalid UserId",HttpStatus.BAD_REQUEST);
        }
        return appraisalRepo.findByEmployee(employee);
    }

    @Override
    public List<Employee> getRepoteeInfo(Integer userId) throws DataException {
        List<Employee> employees=loginRepo.findByManagerId(userId);
        if(employees.size()==0){
            throw new DataException("error.repotee","Invalid Manager Id",HttpStatus.BAD_REQUEST);
        }
        return employees;
    }
}
