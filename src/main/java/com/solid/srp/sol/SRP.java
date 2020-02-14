package com.solid.srp.sol;


public class SRP {
    
    public static void main(String[] args) {
        
        IPhone iPhone = new IPhone();
        Caller caller = iPhone.caller;
        DataChannel data = iPhone.dataChannel;
        
        caller.dial("0912345678");
        caller.hangup();
        data.send("Hello");
        data.recv();
        
        
    }
    
}
