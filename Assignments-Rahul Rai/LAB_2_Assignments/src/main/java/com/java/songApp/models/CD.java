package com.java.songApp.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CD {
    private long id;
    private String title;
    private String singer;
}
