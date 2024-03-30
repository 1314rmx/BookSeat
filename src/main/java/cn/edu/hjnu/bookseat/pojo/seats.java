package cn.edu.hjnu.bookseat.pojo;

import lombok.Data;

@Data
public class seats {
    private int seatID;
    private String satNumber;
    private int areaID;
    private boolean isAvailable;
}
