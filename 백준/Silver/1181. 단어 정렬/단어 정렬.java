import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num;
        int prt = 0;
        num = sc.nextInt();
        String[] words = new String[num];

        for(int i = 0; i < num; i++){
            words[i] = sc.next();
        }

        Arrays.sort(words, new Comparator<String>(){
           @Override
           public int compare(String o1, String o2){
               if(o1.length() - o2.length() == 0){
                   return o1.compareTo(o2);
               }
               return o1.length() - o2.length();
           }
        });

        System.out.println(words[0]);

        for(int i = 1; i < num; i++){
            if(!words[i].equals(words[i - 1])){
                System.out.println(words[i]);
            }
        }
    }
}