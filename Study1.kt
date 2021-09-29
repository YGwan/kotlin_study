//init가 있는 class

class Init_Car(var model:String, var color:String){//primary constructor
    fun getModelName():String{
        return model;
    }
    fun getCarColor():String{
        return color;
    }
    init{
        println("${color} ${model} car created") //init 블록 부분
    }
}

//secondary constructor가 있는 class

class Constructor_Car {
    var model:String = ""
    var color:String = ""
    fun getModeName():String{
        return model;
    }
    fun getCarColor():String{
        return color;
    }
    constructor(model:String, color:String){
        this.model = model
        this.color = color
        println("${color} ${model} car created")
    }
}

//init, constructor 둘다 있는 class
class InitWithConstructor{
    init{
        println("init created")
    }

    constructor(){
        println("constructor created")
    }

}

//main

fun main(){
    var aventador = Init_Car("aventador","blue")
    var pony = Constructor_Car("pony","red")
    println("My first car was ${pony.model} ${pony.color}")
    println("My dream car was ${aventador.getModelName()} ${aventador.getCarColor()}")
    println()
    var sequence = InitWithConstructor()

}
