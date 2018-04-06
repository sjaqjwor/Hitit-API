package me.hitit.api.controllers.responses;

import lombok.NonNull;

public class DefaultResponse {
    @NonNull
    private Status status;
    private Object data;
    private String msg;

    public enum Status {
        SUCCESS, FAIL, NOT_FOUND, CONFLICT
    }

    public DefaultResponse() {
        this.status = Status.SUCCESS;
        this.data = null;
    }

    public DefaultResponse(final Status status) {
        this.status = status;
        this.data = null;
    }

    public DefaultResponse(final Status status, final String msg) {
        this.status = status;
        this.data = null;
    }

    public DefaultResponse(final Object data) {
        this.status = Status.SUCCESS;
        this.data = data;
    }

    public DefaultResponse(final Status status, final Object data, final String msg) {
        this.status = status;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(final Object data) {
        this.data = data;
    }
}