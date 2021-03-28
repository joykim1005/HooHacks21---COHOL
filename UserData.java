public class UserData {
   private String name;
   private double weightInLb;
   private String gender;
   private boolean enableLocation;
   private String trustedName;
   private long phoneNumber;
   
   public UserData(String name, double weightInLb, String gender, boolean enableLocation, String trustedName, long phoneNumber) {
      this.name = name;
      this.weightInLb = weightInLb;
      this.gender = gender;
      this.enableLocation = enableLocation;
      this.trustedName = trustedName;
      this.phoneNumber = phoneNumber;
   }
   
   public boolean EnableLocation() {
      return enableLocation;
   }
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getTrustedName() {
      return trustedName;
   }

   public void setTrustedName(String trustedName) {
      this.trustedName = trustedName;
   }

   public long getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(long phoneNumber) {
      this.phoneNumber = phoneNumber;
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
}

