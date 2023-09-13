using System;

namespace WrittenTest{
  public class Program{
    public static void Main(){
      ClassA item1 = new ClassA();
      ClassA item2 = new ClassC();
			
      AssignA(item1, item2);
      AssignB(item2, item1);

      ClassA item3 = item1;
      item3.Property1 = item2;

      PrintResult(item1);
      PrintResult(item2);
      PrintResult(item3);
    }

    private static void AssignA(ClassA para1, ClassA para2){
      para1.Property1 = para2;
    }

    private static void AssignB(ClassA para1, ClassA para2){
      para1 = new ClassB();
      para1.Property1 = para2;
    }

    private static void PrintResult(ClassA para1){
      if (para1 != null){
        if (para1.Property1 != null)
          para1.Property1.PrintResult();
        else
          para1.PrintResult();
      }
    }
  }
}
