package cn.edu.hjnu.bookseat.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class area {
    private int areaID;
    private String areaName;
    private int districtID;
    private boolean isAvailable;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
}
