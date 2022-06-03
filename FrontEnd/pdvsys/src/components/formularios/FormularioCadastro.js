// ----- Styles - CSS
import styles from './css/FormularioCadastro.module.css'

// ----- Hooks
import { useState } from 'react'

// ----- Links
import { useNavigate } from 'react-router-dom'

const url = "http://201.52.85.36:80/pdv/post/usuario/cadastro"


const FormularioCadastro = () => {


    // Variáveis
    const [email, setEmail] = useState("")
    const [senha, setSenha] = useState("")
    const [confirma, setConfirma] = useState("")

    const navigate = useNavigate()

    //Variavél para setar o highlight das senhas erradas
    const [highlight, setHighlight] = useState(false)
    //Variavél para setar o highlight de emails já cadastrados
    const [highlight2, setHighlight2] = useState(false)


    // Função de validação de envio do formulário
    const handleEnvio = (evento) => {
        evento.preventDefault()

        if (senha === confirma) {
            setHighlight(false)
            const user = {
                email,
                senha
            }
            cadastro(user)
        }
        // //Ação caso as senhas não sejam iguais
        else {
            setHighlight(true)
        }


    }


    const cadastro = async (user) => {
        try {
            setHighlight2(false)
          const resposta = await fetch(url, 
          {method: 'POST',
          headers: {'Content-Type': 'application/json'},
           body: JSON.stringify(user)})
          const dados = await resposta.json();
          navigate(`/cadastro/dados/${dados.id_usuario}`)
        } catch (error) {
            setHighlight2(true)
          console.error(error);
        }
      }

    return (
        <div className={styles.div}>
            <form onSubmit={handleEnvio} >
                <h2>Criar conta</h2>
                <div>
                    {/* Campo e-mail */}
                    <label>
                        <input className={styles.cadastroEmail}
                            type="email"
                            name="email"
                            placeholder="Digite o seu e-mail"
                            required
                            onChange={(evento) => setEmail(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo senha */}
                    <label>
                        <input className={styles.cadastroSenha}
                            type="password"
                            name="senha"
                            placeholder="Digite sua senha"
                            required
                            onChange={(evento) => setSenha(evento.target.value)} />
                    </label>
                </div>
                <div>
                    <label>
                        {/* Condição para destacar o campo */}
                        <input className={styles.cadastroSenha}
                            type="password"
                            name="senha"
                            placeholder="Confirme sua senha"
                            required
                            onChange={(evento) => setConfirma(evento.target.value)} />
                    </label>

                    {/* Span para erro de senha*/}
                    {highlight && <span>Preencha a mesma senha para os campos</span>}
                    {highlight2 && <span>E-mail já cadastrado na aplicação</span>}
                </div>
                {/* Botão cadastrar */}
                <input type="submit" value="Enviar" />
            </form>
        </div>

    )
}

export default FormularioCadastro