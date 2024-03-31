package cn.edu.hjnu.bookseat.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class reservations {
    private int reservationId;
    private int seatId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private String username;
}