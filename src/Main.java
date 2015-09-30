import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите тип данных:" +
                    "\n 1 - файл; \n 2 - строка");
            int answer = scanner.nextInt();
            if (answer == 2) {
                System.out.println("Введите строку");
                String s = scanner.next();
                System.out.println("Hash " + s + ": " + MD5.toHexString(MD5.computeMD5(s.getBytes())));
            } else if (answer == 1) {
                System.out.println("Введите полный путь к файлу");
                String s = scanner.next();
                File file = new File(s);
                byte[] bFile = new byte[(int) file.length()];
                if(!file.exists()){
                    System.out.println("Введен неверный путь к файлу");
                    continue;
                }

                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(bFile);
                fileInputStream.close();

                System.out.println("Hash " + s + ": " + MD5.toHexString(MD5.computeMD5(bFile)));
            } else System.out.println("Введено неверное значение");
        }

    }
}
