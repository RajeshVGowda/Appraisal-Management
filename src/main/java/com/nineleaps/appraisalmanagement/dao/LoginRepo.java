package com.nineleaps.appraisalmanagement.dao;


import com.nineleaps.appraisalmanagement.pojo.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepo extends CrudRepository<Employee, Integer> {

    Employee findByEmailIdAndPassword(String emailId, String password);
    Employee findByUserId(int usedId);

    List<Employee> findByManagerId(Integer userId);
}
