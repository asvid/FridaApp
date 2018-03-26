console.log("Script loaded successfully ");
Java.perform(function x() { 
    
    console.log("Inside java perform function");
    //get a wrapper for our class
    var activity = Java.use("asvid.github.io.fridaapp.MainActivity");
    //replace the original implmenetation of the function `fun` with our custom function
    activity.sum.implementation = function (x, y) {
        //print the original arguments
        console.log("original call: sum(" + x + ", " + y + ")");
        //call the original implementation of `fun` with args (2,5)
        var ret_value = this.sum(2, 5);
        return ret_value;
    }
});