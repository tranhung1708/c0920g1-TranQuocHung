package session_14.BaiTap;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
    public IllegalTriangleException() {
        super("tổng hai cạnh nhỏ hơn cạnh còn lại");
    }
    public IllegalTriangleException(String msg,String erro) {
        super("tổng hai cạnh nhỏ hơn cạnh còn lại");
    }
}
