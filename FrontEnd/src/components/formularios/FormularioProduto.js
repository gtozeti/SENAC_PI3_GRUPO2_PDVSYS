// ----- Styles - CSS
import styles from './css/FormularioProduto.module.css'

// ----- Hooks
import { useState } from 'react'
import { useProdutos } from "../hooks/useProdutos";

// ----- Links
import { Link, useNavigate } from 'react-router-dom'


// ----- Context
import { AuthContext } from '../context/AuthContext'
import { useContext } from 'react'

const url = "http://201.52.85.36:80/pdv/post/produto/empresa?id="



const FormularioProduto = () => {


    const {auth} = useContext(AuthContext)

    // Variáveis
   // const { httpConfig, loading } = useProdutos(url)


   
    const [nome, setNome] = useState("")
    const [preco, setPreco] = useState("")
    const [quantidade, setQuantidade] = useState("")

    const [loading, setLoading] = useState(false)

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
        setLoading(true)
        cadastro(produto)


        // Utiliza API
        // httpConfig(produto, "POST")
        // setTimeout(() => { navigate("/produtos") }, 500);
        // setCategoria("")
        // setNome("")
        // setValor("")
        // setQuantidade("")


    }

    const cadastro = async (produto) => {

        const resposta = await fetch(url+`${auth.empresa.id_empresa}`,
            {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(produto)
            })
        if (resposta.status === 201) {
            const dados = await resposta.json();
            setLoading(false)
            navigate(`/produtos`)
        }
        
   


    }



    return (
        <div className={styles.div}>

            <form onSubmit={handleEnvio}>
                <h2>Cadastro de produto</h2>
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
                        <span>Preço</span>
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
                {loading && <input type="submit" disabled value="Cadastrar" />}
                {!loading && <input type="submit" value="Cadastrar" />}
                <Link to="/produtos">
                    <button>Cancelar</button>
                </Link>
            </form>
        </div>

    )
}

export default FormularioProduto