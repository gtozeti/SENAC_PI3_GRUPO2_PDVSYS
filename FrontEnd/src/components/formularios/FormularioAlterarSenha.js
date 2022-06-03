// ----- Styles - CSS
import styles from './css/FormularioAlterarSenha.module.css'

// ----- Hooks
import { useState } from 'react'

const FormularioAlterarSenha = () => {


    // Variáveis
    const [senha, setSenha] = useState()
    const [confirma, setConfirma] = useState()

    //Variavél para setar o highlight das senhas erradas
    const [highlight, setHighlight] = useState(true)



    // Função de validação de envio do formulário
    const handleEnvio = (evento) => {
        evento.preventDefault()

        {
            senha === confirma ?
                //Ação caso as senhas sejam iguais
                (
                    setHighlight(true)
                )
                :
                // //Ação caso as senhas não sejam iguais
                (
                    setHighlight(false)



                )

            // console.log(senha)
            // console.log(confirma)
            // console.log(email)
        }


    }



    return (
        <div className={styles.div}>
            <form onSubmit={handleEnvio} >
            <h2>Alterar senha</h2>
                <div>
                    {/* Campo senha atual */}
                    <label>
                        <span>Senha atual</span>
                        {/* Condição para destacar o campo */}
                        <input
                            type="password"
                            name="senha"
                            required
                            placeholder='••••••••••••••••••'
                            onChange={(evento) => setSenha(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo senha */}
                    <label>
                        <span>Nova senha</span>
                        {/* Condição para destacar o campo */}
                        <input
                            type="password"
                            name="senha"
                            required
                            placeholder='••••••••••••••••••'
                            onChange={(evento) => setSenha(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo confirmar senha */}
                    <label>
                        <span>Confirme sua senha</span>
                        {/* Condição para destacar o campo */}
                        <input
                            type="password"
                            name="senha"
                            required
                            placeholder='••••••••••••••••••'
                            onChange={(evento) => setConfirma(evento.target.value)} />
                    </label>

                    {/* Span para erro de senha*/}
                    {!highlight && <span style={({color: "red", fontSize: "x-small", margin: "10px" })}>Preencha a mesma senha para os campos</span>}
                </div>
                {/* Botão cadastrar */}
                <input type="submit" value="Alterar" className={'botao_formulario'} />
            </form>
        </div>

    )
}

export default FormularioAlterarSenha