package com.ceiba.controller.response;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Response<T>
{
    private StatusResponse status = StatusResponse.NOT_SUCCESSFUL;

    private List<String> messages = new ArrayList<>();

    private List<T> data;

    public void addMessage(String message)
    {
        getMessages().add(message);
    }
}