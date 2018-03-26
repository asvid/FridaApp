console.log("Script loaded successfully ");
Java.perform(function x() { 
    
    Java.choose("asvid.github.io.fridaapp.MainActivity" , {
      onMatch : function(instance){ //This function will be called for every instance found by frida
        console.log("Found instance: "+instance);

        var start = new Date().getTime()

        for(var i=0000; i<100000; i++){
            var result = instance.checkPin(i+"");
            console.log("checking pin: " + i + " result: " + result);
            if(result){
                console.log(i + ": " + result)
                var stop = new Date().getTime()
                console.log("and it took only: " + (stop - start) +" ms")
                break
            } 
        }
      },
      onComplete:function(){}
    });
});