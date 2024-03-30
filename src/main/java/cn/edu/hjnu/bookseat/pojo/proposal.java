package cn.edu.hjnu.bookseat.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class proposal {
    private int proposalID;
    private String proposalContent;
    private LocalDateTime createTime;
}
