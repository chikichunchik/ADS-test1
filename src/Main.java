import array_variant.MyList;

public class Main {
    static public void main(String[] args){
        MyList test = new MyList();
        test.set(3, 0, 1, 0);
        test.set(1, 1, 1, 2);
        test.set(1, 1, 1, 1);
        test.set(2, 2,1,1);
        test.set(2, 1, 1, 2);
        System.out.println(test.get(1, 1, 1));
        System.out.println(test);
        test.sortNonempty();
        System.out.println(test);
    }
}
