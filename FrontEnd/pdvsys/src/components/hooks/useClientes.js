import { useEffect, useState } from "react";

export const useProdutos = (url) => {

    // Dados recebidos
    const [data, setData] = useState(null)

    // Configuração dos métodos
    const [config, setConfig] = useState(null)
    const [metodo, setMetodo] = useState(null)
    const [buscaDados, setbuscaDados] = useState(false)

    //Loading
    const [loading, setLoading] = useState(false)

    //Erros
    const [error, setError] = useState(null)

    // Setando o ID
    const [idItem, setIdItem] = useState(null)

    // Altera as configurações das requisições
    const httpConfig = (data, method, id) => {
        if (method === "POST") {
            setConfig({
                method,
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(data)
            })

            setMetodo(method)
        }
        else if (method === "PUT"){
            setConfig({
                method,
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(data)
                
            })

            setMetodo(method)
            setIdItem(id)
        }
        else if (method === "DELETE"){
            setConfig({
                method,
                headers: { "Content-Type": "application/json" }
                
            })
            setMetodo(method)
            setIdItem(id)
        }

    }

    // Atualiza os novos dados adicionados
    useEffect(() => {

        const buscarDados = async () => {

            setLoading(true)

            try {
                const resposta = await fetch(url)

                const dados = await resposta.json()
    
                setData(dados)
    
            } catch (error) {
                console.log(error.message)
                setError("Houve algum erro na ação!")
            }
 
            setLoading(false)
        }
        buscarDados()

    }, [url, buscaDados])


    // Recebe o tipo de requisição
    useEffect(() => {

        let dados

        const httpRequest = async () => {

            if (metodo === "POST") {

                let buscaOptions = [url, config]

                const resposta = await fetch(...buscaOptions)

                dados = await resposta.json()

                

            }
            else if (metodo === "PUT") {

                const atualizar = `${url}/${idItem}`
                

                const resposta = await fetch(atualizar, config)

                dados = await resposta.json()

            }
            else if (metodo === "DELETE") {

                const deletar = `${url}/${idItem}`           

                const resposta = await fetch(deletar, config)

                dados = await resposta.json()

            }

            // Realiza um GET sempre que existe atualizações
            setbuscaDados(dados)
        }

        httpRequest()

    }, [config,metodo, url])


    return { data, httpConfig, loading , error}

}
