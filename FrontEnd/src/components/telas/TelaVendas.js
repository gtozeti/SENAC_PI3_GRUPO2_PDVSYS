// ----- Styles - CSS
import styles from '../telas/css/TelaVendas.module.css'

// ----- Hooks
import { useState, useContext } from "react";
import { useProdutos } from "../hooks/useProdutos";

// ----- Links
import { Link, useNavigate } from 'react-router-dom'

import Navbar from './Navbar';

// ----- Context
import { AuthContext } from '../context/AuthContext'


const url_cli = "http://201.52.85.36:80/pdv/get/cliente/all/empresa?id="
const url_prod = "http://201.52.85.36:80/pdv/get/produto/all/empresa?id="
const url = "http://201.52.85.36:80/pdv/post/venda"

var listaProd = []
var listaQuant = []
var valor = 0
var aux = 0

const TelaVendas = () => {


    const { auth } = useContext(AuthContext)

    // Utiliza API
    const { data: clis } = useProdutos(url_cli + `${auth.empresa.id_empresa}`)
    const { data: prods } = useProdutos(url_prod + `${auth.empresa.id_empresa}`)



    const [cliente, setCliente] = useState()
    const [vt, setVt] = useState(0)
    const [pagamento, setPagamento] = useState()

    const navigate = useNavigate()

    // Função de validação de envio do formulário
    const handleEnvio = (evento) => {
        evento.preventDefault()
        console.log(auth.empresa.id_empresa, auth.id_usuario, cliente, listaProd,listaQuant, pagamento, vt)

        const venda = {
            "empresa_id": auth.empresa.id_empresa,
            "usuario_id": auth.id_usuario,
            "cliente_id": cliente,
            "lista_produto_id": listaProd,
            "lista_quantidade": listaQuant,
            "metodo_pagamento": pagamento,
            "valor_total": vt
        }

        cadastro(venda)
        
        evento.target.reset()
    }

    const cadastro = async (venda) => {

        const resposta = await fetch(url,
            {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(venda)
            })
        if (resposta.status === 201) {
            const dados = await resposta.json();
            setVt(0)
        }
        
    }

    const handlePreco = (e, preco) => {
       // console.log(e.target.id, e.target.value, preco)
        if(listaProd.includes(e.target.id)){
            aux = listaQuant[listaProd.indexOf(e.target.id)]
            listaQuant[listaProd.indexOf(e.target.id)] =  e.target.value
            valor = valor - Number(aux * preco)
            valor = valor + Number(e.target.value * preco)
            aux = 0
        }
        else{
            listaProd.push(e.target.id)
            listaQuant.push(e.target.value)
            valor +=  Number(preco * e.target.value )
        }

        setVt(valor)
        
    }
    
    const handleVt = () => {
        setVt(0)
    }


    return (
        <div>
            <Navbar />

            <div className={styles.div}>
                <form  onSubmit={handleEnvio}>
                    <h4 className='esquerda'>Cliente</h4>
                    <select name="" required onChange={(e) => setCliente(e.target.value)}>
                        <option value="" selected hidden>Selecione o cliente</option>
                        
                        {clis && clis.map((cli) => (
                            <option value={cli.id_cliente}>{cli.nome}</option>
                        ))}
                    </select>
                    <div>
                        <h4 className='esquerda'>Produtos</h4>
                        <table >
                            <tr>
                                <th>Descrição</th>
                                <th>Preço</th>
                                <th>Quantidade</th>

                            </tr>
                            {prods && prods.map((prod, index) => (
                                <tr id={prod.id_produto}>
                                    <td>
                                        {prod.nome}
                                    </td>
                                    <td>
                                        R$ {prod.preco}
                                    </td>
                                    <td>
                                        <input id={prod.id_produto}
                                            required
                                            disabled={prod.quantidade === 0}
                                            onChange={(e) => handlePreco(e, prod.preco)}
                                            className='troca'
                                            type="number"
                                            min='0'
                                            max={prod.quantidade}
                                            placeholder={prod.quantidade}>
                                        </input>

                                    </td>

                                </tr>

                            ))}

                        </table>

                        <div>

                        </div>
                        <div>

                            <h4>Método de Pagamento</h4>
                            <select className='blocoE' required onChange={(e) => setPagamento(e.target.value)}>
                                <option value="" selected hidden>Selecione o método de pagamento</option>
                            
                                <option value="Cartão de Crédito">Cartão de Crédito</option>
                                <option value="Débito">Débito</option>
                                <option value="Dinheiro">Dinheiro</option>
                                <option value="PIX">PIX</option>
                            </select>
                        </div>
                        <div>
                                <h4>Valor total: R$ {`${vt}`}</h4>
                            
                        </div>
                    </div>


                    <input type="reset" className='cancelar' value="Limpar Campos" />

                    <input type="submit" className='concluir' value="Concluir Venda" />
                </form>
            </div>
        </div>
    )
}

export default TelaVendas