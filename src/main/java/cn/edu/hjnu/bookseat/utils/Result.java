package cn.edu.hjnu.bookseat.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;
    public static <E> Result<E> success(E data) {
        return new Result<>(200, "success", data);
    }
    public static Result success() {
        return new Result<>(200, "success", null);
    }
    public static Result error( String msg) {
        return new Result<>(400, msg, null);
    }
}
