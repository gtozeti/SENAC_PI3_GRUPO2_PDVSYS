// ----- Styles - CSS
import styles from './css/FormularioProduto.module.css'

// ----- Hooks
import { useState } from 'react'
import { useProdutos } from "../hooks/useProdutos";

// ----- Links
import { Link, useParams, useLocation, useNavigate } from 'react-router-dom'

const url = "http://201.52.85.36:80/pdv/put/cliente?id="


const FormularioAttCliente = () => {

    // Variáveis
    //const { httpConfig, loading } = useProdutos(url)

    // Dados recebidos da tela anterior
    const { id } = useParams()
    const fr = useLocation()
    const { from_nome, from_documento, from_email, from_cep, from_logradouro, from_numero, from_complemento, from_bairro, from_cidade, from_estado } = fr.state

    const [nome, setNome] = useState(from_nome ? from_nome : "")
    const [documento, setDocumento] = useState(from_documento ? from_documento : "")
    const [email, setEmail] = useState(from_email ? from_email : "")
    const [logradouro, setLogradouro] = useState(from_logradouro ? from_logradouro : "")
    const [numero, setNumero] = useState(from_numero ? from_numero : "")
    const [complemento, setComplemento] = useState(from_complemento ? from_complemento : "")
    const [bairro, setBairro] = useState(from_bairro ? from_bairro : "")
    const [cidade, setCidade] = useState(from_cidade ? from_cidade : "")
    const [estado, setEstado] = useState(from_estado ? from_estado : "")
    const [cep, setCep] = useState(from_cep ? from_cep : "")

    const navigate = useNavigate()


    // Função de envio do formulário
    const handleEnvio = async (evento) => {
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
        cadastro(cliente)
    }

    // Utiliza API
    // httpConfig(produto, "PUT", id)
    // setTimeout(() => { navigate("/produtos") }, 500);
    // setCategoria("")
    // setNome("")
    // setValor("")
    // setQuantidade("")



    const cadastro = async (cliente) => {

        const resposta = await fetch(url + `${id}`,
            {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(cliente)
            })
        if (resposta.status === 201) {
            const dados = await resposta.json();
            navigate(`/clientes`)
        }

    }

    return (
        <div className={styles.div}>
            <form onSubmit={handleEnvio}>
                <h2>Atualizar cliente</h2>
                <div>
                    {/* Campo nome completo */}
                    <label>
                        <span>Nome completo</span>
                        <input
                            type="text"
                            name="nome"
                            placeholder='Nome completo'
                            value={nome}
                            required
                            onChange={(evento) => setNome(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo cpf */}
                    <label>
                        <span>Documento</span>
                        <input
                            type="text"
                            name="documento"
                            placeholder='000.000.000-00'
                            value={documento}
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
                            value={email}
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
                            type="text"
                            name="cep"
                            value={cep}
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
                            value={logradouro}
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
                            value={numero}
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
                            value={complemento}
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
                            value={bairro}
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
                            value={cidade}
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
                            <option value="AC"selected = {estado === "AC"}> Acre</option>
                            <option value="AL" selected = {estado === "AL"}> Alagoas</option>
                            <option value="AP" selected = {estado === "AP"}> Amapá</option>
                            <option value="AM" selected = {estado === "AM"}> Amazonas</option>
                            <option value="BA" selected = {estado === "BA"}> Bahia</option>
                            <option value="CE" selected = {estado === "CE"}> Ceará</option>
                            <option value="ES" selected = {estado === "ES"}> Espírito Santo</option>
                            <option value="GO" selected = {estado === "GO"}> Goiás</option>
                            <option value="MA" selected = {estado === "MA"}> Maranhão</option>
                            <option value="MT" selected = {estado === "MT"}> Mato Grosso</option>
                            <option value="MS" selected = {estado === "MS"}> Mato Grosso do Sul</option>
                            <option value="MG" selected = {estado === "MG"}> Minas Gerais</option>
                            <option value="PA" selected = {estado === "PA"}>Pará</option>
                            <option value="PB" selected = {estado === "PB"}> Paraíba</option>
                            <option value="PR" selected = {estado === "PR"}> Paraná</option>
                            <option value="PE" selected = {estado === "PE"}> Pernambuco</option>
                            <option value="RJ" selected = {estado === "RJ"}> Rio de Janeiro</option>
                            <option value="RN" selected = {estado === "RN"}> Rio Grande do Norte</option>
                            <option value="RS" selected = {estado === "RS"}> Rio Grande do Sul</option>
                            <option value="RO" selected = {estado === "RO"}> Rondônia</option>
                            <option value="SC" selected = {estado === "SC"}> Santa Catarina</option>
                            <option value="SP" selected = {estado === "SP"}> São Paulo</option>
                            <option value="SE" selected = {estado === "SE"}> Sergipe</option>
                            <option value="TO" selected = {estado === "TO"}> Tocantins</option>
                        </select>
                    </label>
                </div>
                {/* Botão salvar */}
                <input type="submit" value="Atualizar" />
                {/* {!loading && <input type="submit" value="Atualizar" />} */}
                <Link to="/clientes">
                    <button>Cancelar</button>
                </Link>
            </form>
        </div>

    )
}
export default FormularioAttCliente