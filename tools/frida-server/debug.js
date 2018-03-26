console.log("Script loaded successfully ");
Java.perform(function x() { 
    
    Java.choose("asvid.github.io.fridaapp.Logger" , {
      onMatch : function(instance){ //This function will be called for every instance found by frida
        console.log("Found instance: "+instance);
        instance.showLogs.value = true

      },
      onComplete:function(){}

    });
});