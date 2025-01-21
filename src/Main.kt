class Persona(var peso: Double, var altura:Double,var nombre:String){


    val imc: Double
        get() { //hago un get para poder acceder a él, pero no le hago set para que no se pueda modificar
            return obtenerImc()
        }
    init {
        require(peso>0) {"El peso debe ser mayor que 0"}
        require(altura in 0.0..2.5) {"La altura debe ser mayor que 0 y menor de 2,5"}
    }


    constructor(nombre:String, peso: Double, altura: Double) : this(peso, altura, nombre) {
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

    fun obtenerImc(): Double {
        return peso/(altura*altura)
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
        if(imc< 18.5){
            println("Peso insuficiente")
        }
        if (imc >= 18.5 && imc <24.9){
            println("Peso saludable")
        }
        if (imc >= 24.9 && imc < 29.9){
            println("Sobrepeso")
        }
        if(imc> 29.9){
            println("Obesidad")
        }

    }


    fun obtener_desc():String{
        val calcImc = obtenerImc()
        val descAltura = if(alturaEncimaMedia())"Por encima de la media" else "Por debajo de la media"
        val descPeso = if(pesoEncimaMedia())"Peso por debajo de la media" else "Peso por encima de la media"
        return "$nombre con una altura de ${"%.2f".format(altura)}m ($descAltura) y un peso de ${"%.1f".format(peso)}kg ($descPeso) tiene un IMC de ${"%.2f".format(imc)} ($calcImc)."
    }
}




fun main() {
    val persona1 = Persona(64.7, 1.72, "Julia")
    println(persona1.saludar())
    println(persona1.obtener_desc())
}