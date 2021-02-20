package com.tata.musicCD.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CD {
    private String title;
    private String singer;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public String getTitle() {
        return title;
    }


}
