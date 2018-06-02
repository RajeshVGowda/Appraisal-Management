package com.nineleaps.appraisalmanagement.controller.response;

import java.io.Serializable;

public class UIResponse<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private transient T data;
    private String status;
    //private String data;

    /**
     *
     * @param entity
     */
    public UIResponse( T entity )
    {
        this.data = entity;
    }

    /**
     * No arg constructor
     */
   public UIResponse(){
   }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public T getData() {
        return data;
    }

    public void setData(T entity) {
        this.data = entity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
