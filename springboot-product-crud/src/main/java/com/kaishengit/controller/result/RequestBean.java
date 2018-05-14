package com.kaishengit.controller.result;

public class RequestBean {

    private String status;
    private String message;
    private Object result;

    public static RequestBean success(){

        RequestBean requestBean = new RequestBean();
        requestBean.setStatus("success");
        return requestBean;

    }

    public static RequestBean success(Object object){

        RequestBean requestBean = new RequestBean();
        requestBean.setStatus("success");
        requestBean.setResult(object);
        return requestBean;

    }

    public static RequestBean error(String message){

        RequestBean requestBean = new RequestBean();
        requestBean.setStatus("error");
        requestBean.setMessage(message);
        return requestBean;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
