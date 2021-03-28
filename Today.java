public class Today {
   private int drinkingHours;
   private UserData user;
   private double numShots;
   private double BAC = 0.08;
   private double r;
   
   public Today(int drinkingHours, UserData user) {
      this.drinkingHours = drinkingHours;
      this.user = user;
   }
   
   public void numShotsCalc() {
      // a = standard drink
      if(user.getGender() == null){
         return;
      }
      if(user.getGender().equals("male")) {
         this.r = 0.68;
      }
      if(user.getGender().equals("female")) {
         this.r = 0.55;
      }
      
      double a = (((BAC+(.015*drinkingHours))/100)*(user.getWeightInLb()*454*r))/14;
      
      numShots = Math.round(a * 100.0) / 100.0;
   }
   
   public String Warning() {
      
      return "Based on the information provided, you will be \"legally drunk\" (BAC >= 0.08%) after taking "
             + numShots + " shots in " + drinkingHours + " hours.";
   }
}