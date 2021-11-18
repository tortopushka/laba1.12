import java.util.Scanner;

/**
 * @author Анастасия
 */
public class Main {
    public static void main(String[] args){
        List myList=new List();
        System.out.println("Введите количество элементов:  ");
        Scanner in =new Scanner(System.in);
        while (!in.hasNextInt()){
            System.out.println("Введите число! ");
            in.next();
        }
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            System.out.println((i)+":  ");
            int val=in.nextInt();
            myList.add(val);
        }
        System.out.println("Список: ");
        System.out.println(myList.toString());
        int task=1;
        System.out.println("Выберите действие: ");
        while (task!=0){
            System.out.println(" -------------------------------");
            System.out.println("0-ВЫХОД ");
            System.out.println("1-добавить элемент ");
            System.out.println("2-удалить элемент по индексу");
            System.out.println("3-вывести размерность ");
            System.out.println("4-вывод ");
            System.out.println(" -------------------------------");
            while (!in.hasNextInt()){
                System.out.println("Введите число! ");
                in.next();
            }
            task=in.nextInt();
            if (task<0||task>4) System.out.println("Внимание! Выберите число от 0 до 4!");
            switch (task){
                case 0: break;
                case 1:{
                    System.out.println("Введите элемент: ");
                    while (!in.hasNextInt()){
                        System.out.println("Ошибка! Введите число! ");
                        in.next();
                    }
                    int elem=in.nextInt();
                    myList.add(elem);
                    break;
                }
                case 2: {
                    System.out.println("Введите индекс удаляемого элемента: ");
                    while (!in.hasNextInt()) {
                        System.out.println("Ошибка! Введите число! ");
                        in.next();
                    }
                    int index = in.nextInt();
                    try {
                        myList.delete(index);
                    } catch (Exception var8) {
                        System.out.println(var8.getMessage());
                        System.out.println(myList.toString());
                    }
                    break;
                }
                case 3:{
                    System.out.println("Размерность: ");
                    System.out.println(myList.getSize());
                    break;
                }
                case 4:{
                    if(myList.isEmpty()){
                        System.out.println("Список пуст.");
                    }
                    else {
                        System.out.println("Список: ");
                        System.out.println(myList.toString());
                    }
                    break;
                }
            }
        }

    }
}
