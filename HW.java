import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//Пусть дан произвольный список целых чисел.
//1) Нужно удалить из него чётные числа
//2) Найти минимальное значение
//3) Найти максимальное значение
//4) Найти среднее значение

public class HW {
    static Random random = new Random();

    public static void main(String[] args) {

        int len = Numbers(1, 20);
        int min = Numbers(-10, -1);
        int max = Numbers(0, 20);

        ArrayList<Integer> myList = MyArrayList(len, min, max);
        System.out.println("Начальное значение списка " + myList);

        for (int i = 0; i < len; i++) {
            if (Right(myList.get(i))) {
                myList.remove(i);
                i--;
                len--;
            }
        }
        System.out.println("После удаления четных " + myList);
        System.out.println("Максимальное значение " + Collections.max(myList));
        System.out.println("Минимальное значение " + Collections.min(myList));
        double aver = listAverage(myList);
        System.out.println("Среднее значение" + aver);
    }

    public static int Numbers(int min, int max) {
        max -= min;
        max += 1;
        return (int) (random.nextDouble() * max) + min;
    }

    public static ArrayList<Integer> MyArrayList(int len, int min, int max) {

        ArrayList<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            list.add(Numbers(min, max));
        }
        return list;
    }

    public static boolean Right(int num) {
        if (num % 2 != 0) {
            return false;
        }
        return true;
    }

    public static double listAverage(ArrayList<Integer> myList) {
        int size = myList.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += myList.get(i);
        }
        return (double) sum / (double) size;
    }
}