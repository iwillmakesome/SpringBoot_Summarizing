package com.java.spirngboot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServerStorage {
    private List<ContentClass> contents;

    public ServerStorage() {
        contents = new ArrayList<>();
    }

    public void addContent(ContentClass content){
        contents.add(content);
    }

    public List<ContentClass> getContents(){
        return contents;
    }
}
