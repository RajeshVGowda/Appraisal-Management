package com.nineleaps.appraisalmanagement.dao;

import com.nineleaps.appraisalmanagement.pojo.AppraisalForm;
import com.nineleaps.appraisalmanagement.pojo.Employee;
import org.springframework.data.repository.CrudRepository;

public interface AppraisalRepo extends CrudRepository<AppraisalForm,Integer> {

    AppraisalForm save(AppraisalForm appraisalForm);

    AppraisalForm findByEmployee(Employee employee);

}
