package session_13.BaiTap;

public class InsertionSort {
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
        int arr[] = {-1,4,5,6,3,2,1,10};
        InsertionSort insertionSort = new InsertionSort();
        System.out.print("mảng ban đầu");
        insertionSort.display(arr);
        System.out.println("sau khi sắp xếp");
        insertionSort.insertionSort(arr);
        insertionSort.display(arr);
    }
}
