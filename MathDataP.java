import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

interface MathProcessing {
    public void processData(String type, Integer[] data);
}

class BasicMathProcessing implements MathProcessing {
    public void processData(String type, Integer[] data) {
        switch (type) {
            case "add":
                Integer sum = 0;
                for (Integer i : data) {
                    sum += i;
                }
                System.out.println("Addition: " + sum);
                break;
            case "multiply":
                Integer mul = 1;
                for (Integer i : data) {
                    mul *= i;
                }
                System.out.println("Multiply: " + mul);
                break;
            default:
                MathProcessing mpa = new MathAdapter();
                mpa.processData(type, data);
        }
    }
}

class AdvancedMathProcessing {
    //Defines multiple methods which are accessed using the adapter
    public void calclulateAverage(List<Integer> ls) {
        Integer sum = 0;
        for (Integer i : ls) {
            sum += i;
        }
        float avg = sum / ls.size();
        System.out.println("Average: " + avg);
    }

    public void sortData(List<Integer> ls) {
        Collections.sort(ls);
        System.out.print("Sorted: [ ");
        for (Integer i : ls) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    public int searchData(List<Integer> ls, Integer element) {
        int idx = -1;
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i) == element) {
                return i;
            }
        }
        return idx;
    }

    public void replace(List<Integer> ls, Integer oldInteger, Integer newInteger) {
        Integer idx = searchData(ls, oldInteger);
        ls.set(idx, newInteger);
    }
}

class MathAdapter implements MathProcessing {
    AdvancedMathProcessing adv = new AdvancedMathProcessing();

    public void processData(String type, Integer[] data) {
        switch (type) {//Switch case which enables performing variety of operations
            case "average":
                adv.calclulateAverage(Arrays.asList(data));
                break;
            case "sort":
                adv.sortData(Arrays.asList(data));
                break;
            case "search":
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter element to be searched: ");
                Integer elem = sc.nextInt();
                int idx = adv.searchData(Arrays.asList(data), elem);
                System.out.println("Element " + elem + " found at index: " + idx);
                break;
            case "replace":
                Scanner sc1 = new Scanner(System.in);
                System.out.print("Enter element to be replaced: ");
                Integer oldElem = sc1.nextInt();
                System.out.print("replace with: ");
                Integer newElem = sc1.nextInt();
                adv.replace(Arrays.asList(data), oldElem, newElem);
                System.out.print("Replaced: [ ");
                for (Integer i : data) {
                    System.out.print(i + " ");
                }
                System.out.println("]");
                break;
            default:
                System.out.println("ERR: invalid input [ " + type + " ]");
        }
    }
}

class MathAdapterDemo {
    public static void main(String[] args) {
        MathProcessing m = new BasicMathProcessing();
        Integer[] data = new Integer[] { 4, 6, 3, 1 };
        m.processData("add", data);
        m.processData("multiply", data);
        m.processData("average", data);
        m.processData("sort", data);
        m.processData("search", data);
        m.processData("replace", data);
    }
}