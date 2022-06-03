// ----- Styles - CSS
import styles from './css/FormularioLogin.module.css'

// ----- Hooks
import { useState, useContext } from 'react'


// ----- Links
import { Link, useNavigate, Navigate } from 'react-router-dom'
import { AuthContext } from '../context/AuthContext'

const url = "http://201.52.85.36:80/pdv/post/usuario/login"


const FormularioLogin = () => {
    
 
    // Variáveis
    const [email, setEmail] = useState()
    const [senha, setSenha] = useState()

    const {auth, setAuth} = useContext(AuthContext)


    const [highlight, setHighlight] = useState(false)

    const navigate = useNavigate()



    // Função de validação de envio do formulário
    const handleEnvio = (evento) => {
        evento.preventDefault()


        const user = {
            email,
            senha
        }
        login(user)


    }


    const login = async (user) => {

        setHighlight(false)
        const resposta = await fetch(url,
            {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(user)
            })
        if (resposta.status === 202) {
            const dados = await resposta.json();
            setAuth(dados)

            navigate(`/vendas`)
        }
        else {
        
            setHighlight(true)

        }


    }

    return (
        <div className={styles.div}>
            <form onSubmit={handleEnvio}>
                <h2>Login</h2>
                <div>
                    {/* Campo e-mail */}
                    <label>
                        <input className={styles.loginEmail}
                            type="email"
                            name="email"
                            placeholder=" Digite o seu e-mail"
                            required
                            onChange={(evento) => setEmail(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo senha */}
                    <label>
                        <input className={styles.loginSenha}
                            type="password"
                            name="senha"
                            placeholder=" Digite sua senha"
                            required
                            onChange={(evento) => setSenha(evento.target.value)} />
                    </label>
                </div>
                {/* Botão entrar */}
                <input type="submit" value="Entrar" />
                {highlight && <span>E-mail ou senha incorreta</span>}

            </form>
            <Link to="/cadastro">
                <button type='button'>Cadastrar</button>
            </Link>
            <Link to="esqueceusenha">
                <button type='button'>Esqueceu a senha</button>
            </Link>
        </div>

    )
}

export default FormularioLogin