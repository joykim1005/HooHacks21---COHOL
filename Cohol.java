import java.util.Scanner;

public class Cohol{
   static Scanner in = new Scanner(System.in); 

   public static void main(String[] args)throws Exception{     
      System.out.println("Do you have an account with us? yes or no?");
      String account = in.nextLine().toLowerCase();
      GetInfo info;
      
      if(account.equals("yes")){
         System.out.println("What is your name?");
         String n = in.next().toLowerCase();
         info = new GetInfo(true, n);
         while(true){
            System.out.println("Is there anything you want to change? yes or no");
            String d = in.next();
            d = d.toLowerCase();
            if(d.equals("yes")){
               System.out.println("1) Name\n2) Weight\n3) Gender\n4) Location \n5) Name of trusted person\n6) Trusted person's phone number");
               System.out.println("Enter which number you want to change:");
               int x = in.nextInt();
               
               String nn;
               double w;
               switch(x){
                  case 1: 
                     System.out.println("What do you want your new name to be?");
                     nn = in.next();
                     info.setName(nn);
                     break;
                  case 2:
                     System.out.println("What do you want your new weight to be?");
                     w = in.nextDouble();
                     info.setWeightInLb(w);
                     break;
                  case 3:
                     System.out.println("What do you want your new gender to be?");
                     nn = in.next();
                     info.setGender(nn);
                     break;
                  case 4: 
                     System.out.println("What do you want your new location to be?");
                     nn = in.next();
                     info.setLocation(nn);
                     break;
                  case 5:
                     System.out.println("What do you want your new trusted person's name to be?");
                     nn = in.next();
                     info.setTrustedName(nn);
                     break;
                  case 6:
                     System.out.println("What do you want your new trusted person's phone number to be?");
                     nn = in.next();
                     info.setPhoneNumber(nn);
                     break;
               }
            }
            else{
               info.deleteDate();
               info.writeData();
               break;
            }
         
         }
      }
      else{
         System.out.println("About COHOL\n"+"-------------------------------------------------------------------------------------\n"+
                  "This app will gather user's personal information, such as name, weight, and location,\nto provide the user's alcohol tolerance. \n" + "\n"+
                  "The user will be asked to provide their previous drinking habits and behaviors to be \nnotified of the minimum number of standard drink the user could take in to become\n\"legally drunk.\"\n\n"+
                  "The user should record every drink they take in (shots, cans, bottles, etc.) at that \nmoment.\n\n"+ 
                  "With the information provided, it will calculate the Blood Alcohol Content(BAC)" 
                  + "and \nalert the user once they reach their maximum recommended amount.\n\n"+"Furthermore, the app will alert the user's location to his/her trusted person\n" +
                  "when the user takes in more than the recommended amount of drink,in effort \nto notify and promote the user's safety in case of emergency.\n"+"-------------------------------------------------------------------------------------\n");
         info = new GetInfo(false, "");
      }      
         
      UserData user = new UserData(info.getName(), info.getWeightInLb(), info.getGender(), info.getLocation(), info.getTrustedName(), info.getPhoneNumber());
      System.out.println("How many hours are you planning to drink tonight?");
      int hour = in.nextInt();
         
      Today plans = new Today(hour, user);
      plans.numShotsCalc();
      System.out.println("Caution for the day:");
      System.out.println("---------------------------");
      System.out.println(plans.Warning());
      System.out.println("---------------------------");
         
      Current list = new Current();
      System.out.println("Enter the according number, if you finished consuming that alcohol:");
      System.out.println("1) A can of beer\n2) A glass of wine\n3) Shot of hard liquor\n4) Stop drinking");
      System.out.println("Keep entering the numbers as you finish a drink");
      
      int count;
      Alcohol aa;
      boolean visited1 = true;
      boolean visited2 = true;
      double bac = list.calculateDrink(user, hour);
   
      while(true){
         count = in.nextInt();
         if(count>4 || count < 1){
            continue;
         }
         if(count == 4) {
            int beer1 = 0;
            int wine1 = 0;
            int shot1 = 0;
            for(int i=0; i < list.getList().size(); i++) {
               if(list.getList().get(i).getAlch() == null){
                  break;
               }
               if(list.getList().get(i).getAlch().equals("beer")) {
                  beer1++;
               }
               else if(list.getList().get(i).getAlch().equals("wine")) {
                  wine1++;
               }
               else{
                  shot1++;
               }
            }
            System.out.println("You consumed: \n" + beer1 + " can(s) of beer\n" + wine1 + " glass(es) of wine\n" + shot1 + " shot(s) of hard liquor\n");
            break;
         }
         aa = new Alcohol(count);
         list.addAlch(aa);
         bac = list.calculateDrink(user, hour);
           
         if(bac >= .08 && visited1){
            System.out.println("Your BAC has exceeded the legal drunk percentage of 0.08%.");
            System.out.println("Please do not drive");
            visited1 = false;
         }
         if(bac >= info.getBac() && visited2){
            if(account.equals("yes")){
               System.out.println("Your BAC has exceeded your average BAC.");
            }
            else{
               System.out.println("Your BAC has exceeded the average drunk BAC ");
            }
            System.out.println("Continuing drinking could cause health complications or accidents.");
            System.out.println("You will need a person to take care of you, I will send out a messeage to your trusted person");
            visited2 = false;
         }
         System.out.println("Your BAC is " + bac);
      }   
      System.out.println("Your final BAC is " + bac);
      info.deleteDate();
      System.out.println("How are you feeling right now out of scale of 1-5?");
      int feel = in.nextInt();
      switch(feel){
         case 1:
            System.exit(1);
         case 2:
            info.setBac(((bac+.10) * info.getBac()) / 2);
            break;
         case 3:
            info.setBac(((bac+.05) * info.getBac()) / 2);
            break;
         case 4:
            info.setBac(((bac) * info.getBac()) / 2);
            break;
         case 5:
            info.setBac(((bac-.05) * info.getBac()) / 2);
            break;
      }
      info.writeData();
      System.out.println("Thank you for your input!");
   }
}