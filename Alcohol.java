  

public class Alcohol{
   
   private double x;
   private String s;
   
   Alcohol(int x){
      switch (x){
         case 1:
            this.x = .05;
            s = "beer";
            break;
         case 2:
            this.x = .12;
            s = "wine";
            break;
         case 3:
            this.x = .4;
            s = "hard liquor";
            break;
      }
   }
   
   Alcohol(int x, String s){
      this.x = x;
      this.s = s;
   }
   
   public double getContent(){
      return x;
   }
   
   public String getAlch(){
      return s;
   }
}