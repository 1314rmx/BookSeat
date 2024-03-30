package cn.edu.hjnu.bookseat.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class users {
    @NotEmpty
    private String username;
    @NotEmpty
    @JsonIgnore
    private String password;
    private String name;
    private String gender;
    private int credit;
    private int districtID;
}