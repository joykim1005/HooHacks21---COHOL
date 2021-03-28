import java.util.*;  

public class Current{

   private List<Alcohol> current;

   public Current(){
      current = new ArrayList<Alcohol>();
   }

   public boolean addAlch(Alcohol a){
      return current.add(a);
   }
    
   public List<Alcohol> getList(){
      return current;
   }

   public double calculateDrink(UserData user, int hour){
      BAC yaki = new BAC(user, current.size(), hour);
      return yaki.calculateBAC();
   }
}