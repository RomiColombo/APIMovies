package com.example.seriesservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chapter {

    private Integer id;
    private Integer chapterNumber;
    private String chapterName;
    private String urlStream;

}