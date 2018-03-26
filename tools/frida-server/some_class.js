console.log("Script loaded successfully ");
Java.perform(function x() {    

    var someClass = Java.use("asvid.github.io.fridaapp.SomeClass");
    var someClassInstance = someClass.$new()

    console.log("SomeClass: " + someClassInstance.getSomeString())
    console.log("SomeClass: " + someClassInstance.getSomeString("with argument "))

    someClass.getSomeString.overload().implementation = function(){
        var original = this.getSomeString();
        return "some other string, and original: " + original;
    }
    console.log("SomeClass: " + someClassInstance.getSomeString())

    someClass.getSomeString.overload().implementation = function(string){
        var original = this.getSomeString("argument ");
        return "some other string, and original: " + original;
    }
    console.log("SomeClass: " + someClassInstance.getSomeString())

    console.log("SomeClass: " + someClassInstance.publicField.value)
    console.log("SomeClass: " + someClassInstance.privateField.value)
    someClassInstance.privateField.value = "changed value"
    console.log("SomeClass: " + someClassInstance.privateField.value)
});