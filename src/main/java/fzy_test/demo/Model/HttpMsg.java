package fzy_test.demo.Model;

import lombok.Data;

@Data
public class HttpMsg<T> {
    private int code;
    private String msg;
    private T data;

    public HttpMsg successmsg(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
        return this;
    }

    public HttpMsg Error() {
        this.code = 500;
        this.msg = "Error";
        this.data = null;
        return this;
    }

}
