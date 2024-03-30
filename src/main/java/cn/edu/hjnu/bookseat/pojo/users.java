package cn.edu.hjnu.bookseat.pojo;

import lombok.Data;

@Data
public class user {
    private String username;
    private String password;
    private String name;
    private String gender;
    private int credit;
    private int districtID;
}
