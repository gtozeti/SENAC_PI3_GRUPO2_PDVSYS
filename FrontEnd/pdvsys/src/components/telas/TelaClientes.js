// ----- Styles - CSS
import styles from '../telas/css/TelaProdutos.module.css'

// ----- Hooks
import { useState, useContext } from "react";
import { useProdutos } from "../hooks/useProdutos";

// ----- Links
import { Link } from 'react-router-dom'

import Navbar from './Navbar';

// ----- Context
import { AuthContext } from '../context/AuthContext'


const url = "http://201.52.85.36:80/pdv/get/cliente/all/empresa?id="

const TelaClientes = () => {


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
                            <th>Documento</th>
                            <th>E-mail</th>
                            <th> </th>
                            <th> </th>
                        </tr>
                        {items && items.map((item) => (
                            <tr>
                                <td>
                                    {item.nome}
                                </td>
                                <td>
                                    {item.documento}
                                </td>
                                <td>
                                    {item.email}
                                </td>
                                <td>
                                    <Link to={`/clientes/atualizar/${item.id_cliente}`} state={{ from_nome: item.nome, from_documento: item.documento, from_email: item.email, from_cep: item.cadastro.cep, from_logradouro: item.cadastro.logradouro, from_numero: item.cadastro.numero, from_complemento: item.cadastro.complemento,
                                    from_bairro: item.cadastro.bairro, from_cidade: item.cadastro.cidade, from_estado: item.cadastro.estado }}>
                                        <button className='editar'></button>
                                    </Link>
                                </td>
                                <td>
                                    <Link to={`/clientes/excluir/${item.id_cliente}`} state={{ from_nome: item.nome, from_documento: item.documento, from_email: item.email, from_cep: item.cadastro.cep, from_logradouro: item.cadastro.logradouro, from_numero: item.cadastro.numero, from_complemento: item.cadastro.complemento,
                                    from_bairro: item.cadastro.bairro, from_cidade: item.cadastro.cidade, from_estado: item.cadastro.estado }}>
                                        <button className='excluir'></button>
                                    </Link>
                                </td>
                            </tr>

                        ))}

                    </table>
                    <Link to="/clientes/cadastro">
                        <button>Cadastrar Cliente</button>
                    </Link>
                </div>
            </div>
        </div>
    )
}

export default TelaClientes