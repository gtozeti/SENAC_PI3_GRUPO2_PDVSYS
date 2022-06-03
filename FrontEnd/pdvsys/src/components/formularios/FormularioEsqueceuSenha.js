// ----- Styles - CSS
import styles from './css/FormularioEsqueceuSenha.module.css'

// ----- Hooks
import { useState } from 'react'

const FormularioEsqueceuSenha = () => {


    // Variáveis
    const [email, setEmail] = useState()



    // Função de validação de envio do formulário
    const handleEnvio = (evento) => {
        evento.preventDefault()

        console.log(email)



    }


    return (
        <div className={styles.div}>
            <form onSubmit={handleEnvio}>
                <h2>Esqueceu a senha?</h2>
                <span>Informe o e-mail para redefinir a senha. Caso ele esteja cadastrado em nosso sistema você receberá um link para alterar a senha.</span>
                <div>
                    {/* Campo e-mail */}
                    <label>
                        <input className={styles.esqueceuSenha}
                            type="email"
                            name="email"
                            required
                            placeholder='Digite seu e-mail'
                            onChange={(evento) => setEmail(evento.target.value)} />
                    </label>
                </div>
                {/* Botão enviar */}
                <input type="submit" value="Enviar" />
            </form>
        </div>

    )
}

export default FormularioEsqueceuSenha