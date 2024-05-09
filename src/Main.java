
public class Main {
    public static void main(String[] args) {
        CustomList<Integer> customListMy = new CustomList<>();
        customListMy.add(1);
        customListMy.add(2);
        customListMy.add(3);
        customListMy.add(4);
        customListMy.stream().forEach(System.out::println);

    }
}