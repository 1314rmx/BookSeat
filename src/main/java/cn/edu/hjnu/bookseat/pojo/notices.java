package cn.edu.hjnu.bookseat.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class notices {
    private int noticeID;
    private String title;
    private String content;
    private LocalDateTime createTime;
}
