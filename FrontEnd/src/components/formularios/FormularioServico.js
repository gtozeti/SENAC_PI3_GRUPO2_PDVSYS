// ----- Styles - CSS
import styles from './css/FormularioServico.module.css'

// ----- Hooks
import { useState } from 'react'

const FormularioNovoServico = () => {


    // Variáveis
    const [nome, setNome] = useState()
    const [valor, setValor] = useState()






    // Função de validação de envio do formulário
    const handleEnvio = (evento) => {
        evento.preventDefault()

        console.log(nome, valor)


    }



    return (
        <div className={styles.div}>
            <form onSubmit={handleEnvio}>
            <h2>Cadastro de serviço</h2>
                <div>
                    {/* Campo nome */}
                    <label>
                        <span>Nome</span>
                        <input 
                        className={'input_formulario'}  
                        type="text" 
                        name="nome"
                        required 
                        onChange={(evento) => setNome(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo valor */}
                    <label>
                        <span>Valor</span>
                        <input 
                        className={'input_formulario'}   
                        min="0" 
                        step='0.01' 
                        type="number"
                        name="valor"
                        required
                        placeholder='R$ '
                        onChange={(evento) => setValor(evento.target.value)} />
                    </label>
                </div>
                {/* Botão salvar */}
                <input type="submit" value="Cadastrar" className={'botao_formulario'} />
                <button>Cancelar</button>
            </form>
        </div>

    )
}

export default FormularioNovoServico