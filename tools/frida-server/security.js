console.log("Script loaded successfully ");
Java.perform(function x() {    

    Java.choose("asvid.github.io.fridaapp.Security" , {
      onMatch : function(instance){ //This function will be called for every instance found by frida
        console.log("Found instance: "+instance);
        console.log("result:"+instance.getPassword());
      },
      onComplete:function(){}

    });
});