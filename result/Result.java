package result;

public class Result {

    private Object data;
    private String errorMessage;
    private Boolean success;

    public Result() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object object) {
        this.data = object;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
