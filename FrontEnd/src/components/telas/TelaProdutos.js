// ----- Styles - CSS
import styles from '../telas/css/TelaProdutos.module.css'

// ----- Hooks
import { useState, useContext } from "react";
import { useProdutos } from "../hooks/useProdutos";

// ----- Links
import { Link } from 'react-router-dom'

import Navbar from '../../../src/components/telas/Navbar';

// ----- Context
import { AuthContext } from '../context/AuthContext'


const url = "http://201.52.85.36:80/pdv/get/produto/all/empresa?id="

const TelaProdutos = () => {


    const {auth} = useContext(AuthContext)
  
    // Utiliza API
    const { data: items } = useProdutos(url+`${auth.empresa.id_empresa}`)


    const [pesquisa, setPesquisa] = useState()


    // Função de validação de envio do formulário
    const handlePesquisa = (evento) => {
        evento.preventDefault()


    }

    return (
        <div>
            <Navbar />

            <Link to="/produtos">
                <button className='bbuttona'>Produtos</button>

            </Link>
            <Link to="/servicos">
                <button className='bbuttoni'>Serviços</button>
            </Link>
            <div className={styles.div}>

                <form onSubmit={handlePesquisa}>

                    <label>
                        <input type="search" onChange={(evento) => setPesquisa(evento.target.value)} />
                    </label>

                    <input type="submit" value="" />
                </form>
                <div>
                    <table >
                        <tr>
                            <th>Nome</th>
                            <th>Preço</th>
                            <th>Quantidade</th>
                            <th> </th>
                            <th> </th>
                        </tr>
                        {items && items.map((item) => (
                            <tr>
                                <td>
                                    {item.nome}
                                </td>
                                <td>
                                    R$ {item.preco}
                                </td>
                                <td>
                                    {item.quantidade}
                                </td>
                                <td>
                                    <Link to={`/produtos/atualizar/${item.id_produto}`} state={{ from_nome: item.nome, from_preco: item.preco, from_quantidade: item.quantidade }}>
                                        <button className='editar'></button>
                                    </Link>
                                </td>
                                <td>
                                    <Link to={`/produtos/excluir/${item.id_produto}`} state={{ from_nome: item.nome, from_preco: item.preco, from_quantidade: item.quantidade }}>
                                        <button className='excluir'></button>
                                    </Link>
                                </td>
                            </tr>

                        ))}

                    </table>
                    <Link to="/produtos/cadastro">
                        <button>Cadastrar Produto</button>
                    </Link>
                </div>
            </div>
        </div>
    )
}

export default TelaProdutos