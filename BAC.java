

public class BAC{

   private UserData user;
   private int num_drinks;
   private int drinkingHour;
  
   BAC(UserData user, int size, int drinkingHour){
      this.user = user;
      this.num_drinks = size;
      this.drinkingHour = drinkingHour;
   }
  
   public double calculateBAC(){
      double r = 0.0;
      if(user.getGender().equals("male")){
         r = .68;
      }
      else{
         r = .55;
      }
     
      return (num_drinks*14)/(user.getWeightInLb()*454*r)*100 - (0.015*drinkingHour);
   }
}