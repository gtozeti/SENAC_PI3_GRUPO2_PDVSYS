// ----- Styles - CSS
import styles from './css/FormularioProduto.module.css'

// ----- Hooks
import { useState } from 'react'
import { useProdutos } from "../hooks/useProdutos";

// ----- Links
import { Link, useParams, useLocation, useNavigate } from 'react-router-dom'

const url = "http://201.52.85.36:80/pdv/put/produto?id="


const FormularioAttProduto = () => {


    // Dados recebidos da tela anterior
    const { id } = useParams()
    const fr = useLocation()
    const { from_nome, from_preco, from_quantidade } = fr.state

    const [nome, setNome] = useState(from_nome)
    const [preco, setPreco] = useState(from_preco)
    const [quantidade, setQuantidade] = useState(from_quantidade)

    const navigate = useNavigate()

    // Função de envio do formulário
    const handleEnvio = async (evento) => {
        evento.preventDefault()

        // Objeto de envio
        const produto = {
            nome,
            preco,
            quantidade
        }

        atualizar(produto)

        // // Utiliza API
        // httpConfig(produto, "PUT", id)
        // setTimeout(() => { navigate("/produtos") }, 500);

        // setNome("")

        // setQuantidade("")

    }

    const atualizar = async (produto) => {

        const resposta = await fetch(url + `${id}`,
            {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(produto)
            })
        if (resposta.status === 201) {
            const dados = await resposta.json();
            navigate(`/produtos`)
        }

    }



    return (
        <div className={styles.div}>
            <form onSubmit={handleEnvio}>
                <h2>Atualizar produto</h2>
                <div>
                    {/* Campo nome */}
                    <label>
                        <span>Nome</span>
                        <input
                            type="text"
                            name="nome"
                            value={nome}
                            required
                            onChange={(evento) => setNome(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo valor */}
                    <label>
                        <span>Valor</span>
                        <input
                            min="0"
                            step='0.01'
                            type="number"
                            name="valor"
                            required
                            placeholder='R$ '
                            value={preco}
                            onChange={(evento) => setPreco(evento.target.value)} />
                    </label>
                </div>
                <div>
                    {/* Campo quantidade */}
                    <label>
                        <span>Quantidade</span>
                        <input
                            type="number"
                            min="0"
                            name="quantidade"
                            required
                            value={quantidade}
                            onChange={(evento) => setQuantidade(evento.target.value)} />
                    </label>
                </div>
                {/* Botão salvar */}
                <input type="submit"  value="Atualizar" />
                {/* {!loading && <input type="submit" value="Atualizar" />} */}
                <Link to="/produtos">
                    <button>Cancelar</button>
                </Link>
            </form>
        </div>

    )
}

export default FormularioAttProduto