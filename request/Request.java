package request;

public class Request {

    private Object data;
    private String methodID;

    public Request(){}

    public Object getData() {
        return data;
    }

    public void setData(Object s) {
        this.data = s;
    }

    public String getMethodID() {
        return methodID;
    }

    public void setMethodID(String methodID) {
        this.methodID = methodID;
    }
}