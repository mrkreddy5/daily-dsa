import java.util.Arrays;

public class sort_2Darray {
    public static void main(String[] args) {
        int[][] nums = {{2,4},{1,6},{2,6},{6,5}};
        numArr(nums);

        String[][] strings = {{"apple","grapes"},{"guava","apple"},{"zebra","cat"},{"grapes","apple"}, {"guava","ape"}}; 
        stringsArr(strings);

        Student[] students ={ 
            new Student(2,"praveen",24),
            new Student(5,"venky",25),
            new Student(3,"ram",25),
            new Student(1,"pramod",23),
            new Student(4,"teja",21)
        };
        objectsArr(students);
    }


    public static void numArr(int[][] arr){
        Arrays.sort(arr, (a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });

        for(int[] a : arr){
            for(int n: a){
                System.out.print(n + ",");
            }
            System.out.println();
        }
    }


    public static void stringsArr(String[][] strings){
        Arrays.sort(strings, (a,b)->{
            int cmp = a[0].compareTo(b[0]);
            if(cmp!=0) return cmp;
            return a[1].compareTo(b[1]);
        });

        for(String[] a : strings){
            for(String s: a){
                System.out.print(s + ",");
            }
            System.out.println();
        }
    }

    public static void objectsArr(Student[] objArr){
        Arrays.sort(objArr, (a,b)->{
            int cmp = Integer.compare(b.marks, a.marks);
            if(cmp!=0) return cmp;
            else return Integer.compare(a.roll, b.roll);
        });

        for(Student s: objArr){
            System.out.println(s.roll + "," + s.name + "," + s.marks);
        }
    }
}

class Student {
    int roll;
    String name;
    int marks;

    Student(int roll, String name, int marks){
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }
}
