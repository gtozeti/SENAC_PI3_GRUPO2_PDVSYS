// ----- Styles - CSS
import styles from './css/FormularioDadosCadastrais.module.css'

// ----- Hooks
import { useState } from 'react'


// ----- Links
import { useParams, useNavigate } from 'react-router-dom'

const url = "http://201.52.85.36:80/pdv/post/usuario/cadastro/concluir"

const FormularioDadosCadastrais = () => {

    const { id } = useParams()


    // Variáveis
    const [nome, setNome] = useState()
    const [cpf, setCpf] = useState()
    const [cnpj, setCnpj] = useState()
    const [cep, setCep] = useState()
    const [logradouro, setLogradouro] = useState()
    const [numero, setNumero] = useState()
    const [complemento, setComplemento] = useState()
    const [bairro, setBairro] = useState()
    const [cidade, setCidade] = useState()
    const [estado, setEstado] = useState()
    const [nome_empresa, setNomeEmpresa] = useState()

    const navigate = useNavigate()



    // Função de validação de envio do formulário
    const handleEnvio = (evento) => {
        evento.preventDefault()

        const user = {
            nome,
            "documento": cpf,
            "empresa": {
                "nome":nome_empresa,
                "documento":cnpj
            },
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

        cadastro(user)



    }

    const cadastro = async (user) => {
        try {

          const resposta = await fetch(`${url}?id=${id}`, 
          {method: 'POST',
          headers: {'Content-Type': 'application/json'},
           body: JSON.stringify(user)})
          const dados = await resposta.json();
          navigate(`/sucesso`)
        } catch (error) {
          console.error(error);
        }
      }



    return (
        <div className={styles.div}>
            <form onSubmit={handleEnvio}>
                <h2>Dados Cadastrais</h2>
                <div>
                    {/* Campo nome completo */}
                    <label>
                        <span>Nome completo</span>
                        <input
                            type="text"
                            name="nome"
                            required
                            placeholder='Nome completo'
                            onChange={(evento) => setNome(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo cpf */}
                    <label>
                        <span>CPF</span>
                        <input
                            type="number"
                            name="cpf"
                            required
                            placeholder='000.000.000-00'
                            onChange={(evento) => setCpf(evento.target.value)} />
                    </label>
                </div>
                <br />
                <div>
                    {/* Campo nome empresa */}
                    <label>
                        <span>Nome da empresa</span>
                        <input
                            type="text"
                            name="nome_empresa"
                            required
                            placeholder='Nome da empresa'
                            onChange={(evento) => setNomeEmpresa(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo cnpj */}
                    <label>
                        <span>CNPJ</span>
                        <input
                            type="number"
                            name="cnpj"
                            required
                            placeholder='00.000.000/0000-00'
                            onChange={(evento) => setCnpj(evento.target.value)} />
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
                            placeholder='Rua, Avenida, Estrada...'
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
                <input type="submit" value="Salvar" />
            </form>
        </div>

    )
}

export default FormularioDadosCadastrais