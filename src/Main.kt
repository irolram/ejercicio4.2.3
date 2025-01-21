class Persona(var peso: Double, var altura:Double,var nombre:String){


    val imc: Double
        get() { //hago un get para poder acceder a él, pero no le hago set para que no se pueda modificar
            return peso/(altura*altura)
        }
    init {
        require(peso>0) {"El peso debe ser mayor que 0"}
        require(altura in 0.0..2.5) {"La altura debe ser mayor que 0 y menor de 2,5"}
    }


    constructor(nombre:String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre


    }
    override fun toString():String{
        return "Nombre:$nombre peso: $peso, altura: $altura"


    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false
        return nombre == other.nombre && peso == other.peso && altura == other.altura
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
        TODO("HACERLO")
    }

    fun pedir_nombre(): String {
        print("Ingrese su nombre: ")
        val nombre = readLine()!!
        if (nombre.isEmpty()) return pedir_nombre()
        return nombre
    }

    fun saludar() {
        return println("Hola ${nombre}")
    }
    fun alturaEncimaMedia():Boolean{
        if (altura < 1.75){
            return false
        }else{
            return true
        }
    }
    fun pesoEncimaMedia():Boolean{
        if(peso < 70.0){
            return false
        }else{
            return true
        }
    }
    fun ObtenerDescImc(){

    }
}



fun main() {
    val persona1 = Persona(60.0,1.50,"Ivan")
    persona1.saludar()
    persona1.alturaEncimaMedia()
}