package com.nineleaps.appraisalmanagement.controller;

import com.nineleaps.appraisalmanagement.controller.response.UIErrorMessage;
import com.nineleaps.appraisalmanagement.controller.response.UIResponse;
import com.nineleaps.appraisalmanagement.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AbstractRestService {


    protected ResponseEntity<UIResponse<String>> buildSuccessMessage(final String msg )
    {
        final UIResponse<String> message = new UIResponse<>();
       // message.setEntity("success");
       // message.setData(msg);
        message.setStatus("Success");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    protected <T> ResponseEntity<UIResponse<T>> buildResponse( final T t )
    {
        final UIResponse<T> uiResponse = new UIResponse<>(t);
        uiResponse.setStatus("success");
        uiResponse.setData(t);
        return new ResponseEntity<>(uiResponse, HttpStatus.OK);
    }

    /**
     * Method to build error response for data exception
     *
     * @param e
     * @return
     */
    @SuppressWarnings( "rawtypes" )
    public ResponseEntity<UIErrorMessage> buildError(final DataException e )
    {
        final UIErrorMessage message = new UIErrorMessage();
        message.setMessageCode(e.getErrorCode());
        message.setData(e.getErrorMessage());
        if( e.getHttpStatus().equals(HttpStatus.BAD_REQUEST) )
        {
            message.setStatus("failure");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        if( e.getHttpStatus().equals(HttpStatus.FORBIDDEN) )
        {
            message.setStatus("failure");
            return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
        }
        if( e.getHttpStatus().equals(HttpStatus.NOT_FOUND) )
        {
            message.setStatus("failure");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        if( e.getHttpStatus().equals(HttpStatus.CONFLICT) )
        {
            message.setStatus("failure");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
        message.setStatus("failure");
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
