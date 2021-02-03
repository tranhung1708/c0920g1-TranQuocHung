package session_16.BaiTap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FunctionManager {
    public static final String FILE_MANAGER = "src/session_16/BaiTap/manager.dat";

    public static void writeProduct(List<Product> productList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(FILE_MANAGER, true);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Product>  readProduct() {
        List<Product> productList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(FILE_MANAGER));
            ois = new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }
}
