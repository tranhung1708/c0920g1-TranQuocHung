package session_3;

public class TimGiaTriNhoNhatTrongMangPhuongThuc {
    public static void main(String[] args) {
        int[] arr = {2, 16, 14, 9, 1, 6, 9};
        int min = minValue(arr);

        System.out.println("So nho nhat trong mang la " + min );
    }

    public static int minValue(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}