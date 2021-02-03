package session_13.BaiTap;

public class SortAlgorithmSettings {
    public void insertionSort(int arr[]){
        int value ;
        int position;
        int i;

        for (i = 1 ; i < arr.length ;i++){
            value = arr[i];
            position = i;
            while (position > 0 && arr[position-1]> value){
                arr[position] =arr[position-1];
                position--;
//               System.out.println("di chuyển phần tử " + arr[position]);
            }
            if (position != i){
//               System.out.println("chèn phần tử " + value + "tại vị trí " + position);
                arr[position] = value;
            }
//           System.out.println("vòng lặp thứ " + i);
        }
    }
    public  void display(int arr[]){
        int i ;
        System.out.print("[");
        for (i = 0 ; i < arr.length ;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int array[] = {9,7,6,5,4,3,8,2,1};
        SortAlgorithmSettings sortAlgorithmSettings = new SortAlgorithmSettings();
        sortAlgorithmSettings.display(array);
        System.out.println("\n sau khi sắp xếp");
        sortAlgorithmSettings.insertionSort(array);
        sortAlgorithmSettings.display(array);
    }
}
