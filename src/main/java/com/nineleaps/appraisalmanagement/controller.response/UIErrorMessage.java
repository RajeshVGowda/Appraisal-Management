package com.nineleaps.appraisalmanagement.controller.response;

import java.io.Serializable;

public class UIErrorMessage<T> extends UIResponse<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4311696013200578760L;
    private String messageCode;
    private String message;
    private String status;
    private String stackTrace;

    /**
     *
     * @param t
     */
    public UIErrorMessage( T t )
    {
        super(t);
    }

    /**
     * No arg constructor
     */
    public UIErrorMessage()
    {
        super();
    }

    @Override
    public String toString()
    {
        return "UIErrorMessage [messageCode=" + messageCode + ", message=" + message + ", stackTrace=" + stackTrace
                + "]";
    }

    public String getMessageCode()
    {
        return messageCode;
    }

    public void setMessageCode( String messageCode )
    {
        this.messageCode = messageCode;
    }



    public String getStackTrace()
    {
        return stackTrace;
    }

    public void setStackTrace( String stackTrace )
    {
        this.stackTrace = stackTrace;
    }

    @Override
    public String getStatus()
    {
        return status;
    }

    @Override
    public void setStatus( String status )
    {
        this.status = status;
    }

}
