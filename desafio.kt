enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String,val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    override fun toString(): String{
        var texto: String
        
        texto = "Formação: $nome\nNível: "
        
        when(nivel){
            Nivel.BASICO -> texto += "Básico"
            Nivel.INTERMEDIARIO -> texto += "Intermediário"
            Nivel.AVANCADO -> texto += "Avançado"
            
        }
        
        texto += "\nLista de Conteudo:\n"
        
        for(c in conteudos){
            texto += "${c.nome}\n"
        }
        
        texto += "\nAlunos:\n${listarAlunos()}"
        
        return texto
    }
    
    fun matricular(vararg usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        for(u: Usuario in usuario){
            inscritos.add(u)
        }
    }
    
    fun listarAlunos(): String{
        var texto:String = ""
        for(i in inscritos){
            texto += "${i.nome}\n"
        }
        return texto
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")
    val usuario3 = Usuario("Pedro")
    
    val kotlin = ConteudoEducacional(nome = "Desmistificando Kotlin para programadores Java",
                                     duracao = 6, 
                                     nivel = Nivel.BASICO)
    
    val java = ConteudoEducacional("Ganhando produtividade com Java e Spring Boot ", 
                                   10, 
                                   Nivel.AVANCADO)
    
    val formacao = Formacao("Backend com Kotlin e Java", Nivel.INTERMEDIARIO,listOf(kotlin,java))
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2, usuario3)
    
    println(formacao)
    
}