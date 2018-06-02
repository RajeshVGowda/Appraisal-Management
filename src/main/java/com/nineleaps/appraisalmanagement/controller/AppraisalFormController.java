package com.nineleaps.appraisalmanagement.controller;


import com.nineleaps.appraisalmanagement.exception.DataException;
import com.nineleaps.appraisalmanagement.pojo.AppraisalForm;
import com.nineleaps.appraisalmanagement.service.AppraisalService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppraisalFormController extends AbstractRestService{

    @Autowired
    private AppraisalService appraisalService;

    @RequestMapping(value = "/saveFormData",method = RequestMethod.POST)
    public ResponseEntity<?> submitAppriationForm(@RequestBody AppraisalForm appraisalForm, @RequestParam("userId") Integer userId){

        try{
            if(userId==null){
                buildError(new DataException("error.appraisal","UserId should not be null",HttpStatus.BAD_REQUEST));
            }
            AppraisalForm saveAppraisalData = appraisalService.saveAppraisalData(appraisalForm, userId);
            if (saveAppraisalData==null){
                buildError(new DataException("error.appraisal","Invalid data has submitted",HttpStatus.BAD_REQUEST));
            }
            return buildResponse("Successfully saved data");
        }catch (final DataException e){
            return buildError(e);
        }
    }

    @RequestMapping(value = "/getFormData",method = RequestMethod.GET)
    public ResponseEntity<?> getAppriationForm( @RequestParam("userId") Integer userId){

        try{
            if(userId==null){
                buildError(new DataException("error.appraisal","UserId should not be null",HttpStatus.BAD_REQUEST));
            }
            return buildResponse(appraisalService.getAppraisalData(userId));
        }catch (final DataException e){
            return buildError(e);
        }
    }

    @RequestMapping(value = "/getRepoteeInfo",method = RequestMethod.GET)
    public ResponseEntity<?> getRepoteeInfo( @RequestParam("userId") Integer userId){

        try{
            if(userId==null){
                buildError(new DataException("error.repotees","manager id is not present",HttpStatus.BAD_REQUEST));
            }
            return buildResponse(appraisalService.getRepoteeInfo(userId));
        }catch (final DataException e){
            return buildError(e);
        }
    }




}
