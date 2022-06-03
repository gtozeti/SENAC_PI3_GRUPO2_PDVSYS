// ----- Styles - CSS
import styles from './css/FormularioCliente.module.css'

import { useState } from 'react'

// ----- Links
import { Link, useNavigate } from 'react-router-dom'

// ----- Context
import { AuthContext } from '../context/AuthContext'
import { useContext } from 'react'

const url = "http://201.52.85.36:80/pdv/post/cliente/empresa?id="

const FormularioNovoCliente = () => {

    const {auth} = useContext(AuthContext)

    // Variáveis
    const [nome, setNome] = useState("")
    const [documento, setDocumento] = useState("")
    const [email, setEmail] = useState("")
    const [logradouro, setLogradouro] = useState("")
    const [numero, setNumero] = useState("")
    const [complemento, setComplemento] = useState("")
    const [bairro, setBairro] = useState("")
    const [cidade, setCidade] = useState("")
    const [estado, setEstado] = useState("")
    const [cep, setCep] = useState("")
    

    const [loading, setLoading] = useState(false)

    const navigate = useNavigate()

    // Função de validação de envio do formulário
    const handleEnvio = (evento) => {
        evento.preventDefault()

        // Objeto de envio
        const cliente = {
            nome,
            documento,
            email,
            "cadastro": {
                logradouro,
                numero,
                complemento,
                bairro,
                cidade,
                estado,
                cep
            }
        }
        setLoading(true)
        cadastro(cliente)
        


    }

    

    const cadastro = async (cliente) => {

        const resposta = await fetch(url+`${auth.empresa.id_empresa}`,
            {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(cliente)
            })
        if (resposta.status === 201) {
            const dados = await resposta.json();
            setLoading(false)
            navigate(`/clientes`)
        }
        
    }


    return (
        <div className={styles.div}>
            <form onSubmit={handleEnvio}>
                <h2>Cadastro de cliente</h2>
                <div>
                    {/* Campo nome completo */}
                    <label>
                        <span>Nome completo</span>
                        <input
                            type="text"
                            name="nome"
                            placeholder='Nome completo'
                            required
                            onChange={(evento) => setNome(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo cpf */}
                    <label>
                        <span>Documento</span>
                        <input
                            type="number"
                            name="documento"
                            placeholder='000.000.000-00'
                            required
                            onChange={(evento) => setDocumento(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo e-mail */}
                    <label>
                        <span>E-mail</span>
                        <input
                            type="email"
                            name="email"
                            required
                            placeholder='E-mail'
                            onChange={(evento) => setEmail(evento.target.value)} />
                    </label>
                </div>
                <br />
                <div>
                    {/* Campo cep */}
                    <label>
                        <span>CEP</span>
                        <input
                            type="number"
                            name="cep"
                            required
                            placeholder='00000-000'
                            onChange={(evento) => setCep(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo logradouro */}
                    <label>
                        <span>Logradouro</span>
                        <input
                            type="text"
                            name="logradouro"
                            required
                            placeholder='Rua, Avenida, Estrada, ...'
                            onChange={(evento) => setLogradouro(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo número */}
                    <label>
                        <span>Número</span>
                        <input
                            type="text"
                            name="numero"
                            required
                            placeholder='Número'
                            onChange={(evento) => setNumero(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo complemento */}
                    <label>
                        <span>Complemento</span>
                        <input
                            type="text"
                            name="complemento"
                            placeholder='Complemento'
                            onChange={(evento) => setComplemento(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo bairro */}
                    <label>
                        <span>Bairro</span>
                        <input
                            type="text"
                            name="bairro"
                            required
                            placeholder='Bairro'
                            onChange={(evento) => setBairro(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo cidade */}
                    <label>
                        <span>Cidade</span>
                        <input
                            type="text"
                            name="cidade"
                            required
                            placeholder='Cidade'
                            onChange={(evento) => setCidade(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo Estado */}
                    <label>
                        <span>Estado</span>
                        <select name="estado" required onChange={(e) => setEstado(e.target.value)}>
                            <option value="" selected disabled hidden>Selecione o seu Estado</option>
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                    </label>
                </div>
                {/* Botão salvar */}
                {loading && <input type="submit" disabled value="Cadastrar" />}
                {!loading && <input type="submit" value="Cadastrar" />}
            <Link to="/clientes">
                    <button>Cancelar</button>
                </Link>
            </form>
        </div>

    )
}

export default FormularioNovoCliente