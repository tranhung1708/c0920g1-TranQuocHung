package session_14.BaiTap;

public class Triangle {
    private int canhA;
    private int canhB;
    private int canhC;

    public Triangle() {
    }

    public Triangle(int canhA, int canhB, int canhC) throws IllegalTriangleException {
        if (canhA <= 0 || canhB <=0 || canhC <= 0 && canhA+canhB < canhC || canhB + canhC < canhA || canhA + canhC < canhC) {
            throw new IllegalTriangleException("Có cạnh nhỏ hơn không va 1111111111111");
        }else if (canhA+canhB < canhC || canhB + canhC < canhA || canhA + canhC < canhC){
            throw new IllegalTriangleException();
        }else if (canhA <= 0 || canhB <=0 || canhC <= 0){
            throw new IllegalTriangleException("Có cạnh nhỏ hơn không ");
        }else {
            this.canhA = canhA;
            this.canhB = canhB;
            this.canhC = canhC;
        }
    }

    public int getCanhA() {
        return canhA;
    }

    public void setCanhA(int canhA) {
        this.canhA = canhA;
    }

    public int getCanhB() {
        return canhB;
    }

    public void setCanhB(int canhB) {
        this.canhB = canhB;
    }

    public int getCanhC() {
        return canhC;
    }

    public void setCanhC(int canhC) {
        this.canhC = canhC;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "cạnhA=" + canhA +
                ", cạnhB=" + canhB +
                ", cạnhC=" + canhC +
                '}';
    }
}
