console.log("Script loaded successfully ");
Java.perform(function x() { 
    
    Java.choose("asvid.github.io.fridaapp.MainActivity" , {
      onMatch : function(instance){ //This function will be called for every instance found by frida
        console.log("Found instance: "+instance);
        instance.showToast();
      },
      onComplete:function(){}
    });
});