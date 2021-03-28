import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class GetInfo{
   private String info;
   private String name;
   private double weightInLb;
   private String gender;
   private String enableLocation;
   private String trustedName;
   private String phoneNumber;
   private double bac;
   
   static Scanner in = new Scanner(System.in); 
   
   File file = new File("info.txt");

   GetInfo(boolean t, String s) throws Exception{
      if(t == false){
         System.out.println("What is your name?");
         name = in.next().toLowerCase();
         System.out.println("What is your weight in pounds?");
         weightInLb = in.nextDouble();
         System.out.println("What is your gender? male or female?");
         gender = in.next().toLowerCase();
         System.out.println("Would you like to enable your location? yes or no?");
         enableLocation = in.next().toLowerCase();
         System.out.println("What is the name of your trusted person?");
         trustedName = in.next().toLowerCase();
         System.out.println("What is their phone number? Enter just the numbers");
         phoneNumber = in.next();
         this.bac = .20;
         this.writeData();
      }
      else{
         if(!file.exists()) {
            System.out.println("We are sorry, but you do not have an account with us");
            System.out.println("Please create one first");
            System.exit(0);
         }
         BufferedReader br = new BufferedReader(new FileReader(file));
         String str;
         while ((str = br.readLine()) != null){
            String[] splited = str.split("\\s+");
            if(s.equals(splited[0])){
               this.name = splited[0];
               this.weightInLb = Double.parseDouble(splited[1]);
               this.gender = splited[2];
               this.enableLocation = splited[3];
               this.trustedName = splited[4];
               this.phoneNumber = splited[5];
               this.bac = Double.parseDouble(splited[6]);
               this.info = str;
               System.out.println("According to our data you are: " + str);
               br.close();
               return;
            }
         }
         br.close();
         System.out.println("We are sorry, but you do not have an account with us");
         System.out.println("Please create one first");
         System.exit(0);
      }
   } 
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getWeightInLb() {
      return weightInLb;
   }
    
   public void setWeightInLb(double w) {
      this.weightInLb = w;
   }
   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }
   public boolean getLocation() {
      if(enableLocation == null){
         return false;
      }
      enableLocation = enableLocation.toLowerCase();
      if(enableLocation.equals("yes")){
         return true;
      }
      else{
         return false;
      }
   }

   public void setLocation(String s) {
      this.enableLocation = s;
   }

   public String getTrustedName() {
      return trustedName;
   }

   public void setTrustedName(String trustedName) {
      this.trustedName = trustedName;
   }
   
   public long getPhoneNumber() {
      if(phoneNumber == null){
         return 0;
      }
      return Long.valueOf(phoneNumber);
   }

   public void setPhoneNumber(String s) {
      this.phoneNumber = s;
   }
   
   public void setBac(double bac) {
      this.bac = bac;
   }

   public double getBac() {
      return bac;
   }
   
   public void deleteDate()throws Exception{
      BufferedReader br = new BufferedReader(new FileReader(file));
   
      File tempFile = new File("myTempFile.txt");
      tempFile.createNewFile();
      BufferedWriter w = new BufferedWriter(new FileWriter(tempFile));
   
      String lineToRemove = this.info;
      String str;
      
      while ((str = br.readLine()) != null){
         if(str.equals(lineToRemove)){
            continue;
         }
         w.write(str + System.getProperty("line.separator"));
      }
      w.close(); 
      br.close(); 
      file.delete();
   
      tempFile.renameTo(file);
   }
   public void writeData(){
      try{
         if(!file.exists()) {
            file.createNewFile();
         }
         FileWriter fileWritter = new FileWriter(file.getName(),true);
         BufferedWriter bw = new BufferedWriter(fileWritter);
         bw.write(name + " ");
         bw.write(String.valueOf(weightInLb) + " ");
         bw.write(gender + " ");
         bw.write(enableLocation + " ");
         bw.write(trustedName + " ");
         bw.write(phoneNumber + " ");
         bw.write(String.valueOf(bac) + " \n");
         bw.close();
         this.info = name + " " + String.valueOf(weightInLb) + " " +  gender + " " + enableLocation + " " +  trustedName + " " +  phoneNumber + " " + String.valueOf(bac) + " ";
      }catch(IOException e){
         e.printStackTrace();
      }
   }
}