package com.solid.dip.sol;

class email{
    public String message(){
        return "mail";
    }

}

class line{
    public String message(){
        return "line";
    }

}

class IPhone{
   
    public void read(email email){
       System.out.println(email.message());
   }
   
   public void read(line line){
       System.out.println(line.message());
   }

}

public class Test {
    
    public static void main(String[] args) {
            IPhone iPhone = new IPhone();
            iPhone.read(new email());
            iPhone.read(new line());
    }
    
}
