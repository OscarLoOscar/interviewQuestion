import java.util.LinkedList;
import java.util.List;

public class test1v2 {

    public static void main(String[] args) {
      List<Integer> strs = new LinkedList<>();
      int num = 1;
      int temp = 1;

      while (strs.size() < 3) {
        strs.add(temp);
        temp += num++;
        System.out.println(concatenateList(strs));
      }

      temp = 0;
      while (strs.size() < 11) {
        for (int i = strs.size() - 3; i < strs.size(); i++) {
          temp += strs.get(i);
        }
        strs.add(temp);
        temp = 0;
        System.out.println(concatenateList(strs));
      }
      System.out.println(concatenateList(strs));
    }

    private static String concatenateList(List<Integer> list) {
      StringBuilder sb = new StringBuilder();
      for (Integer integer : list) {
        sb.append(integer);
      }
      return sb.toString();
    }
    
  }