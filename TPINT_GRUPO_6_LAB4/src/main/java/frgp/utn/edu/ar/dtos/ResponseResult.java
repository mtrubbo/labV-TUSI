package frgp.utn.edu.ar.dtos;


public class ResponseResult {
    private ResultStatus status;
    private String message;



    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
