console.log("Script loaded successfully ");
Java.perform(function x() { 
    
    Java.enumerateLoadedClasses(
      {
      "onMatch": function(className){ 
            if(className.includes("asvid")){
                console.log(className);
            }            
        },
      "onComplete":function(){}
      }
    );
});