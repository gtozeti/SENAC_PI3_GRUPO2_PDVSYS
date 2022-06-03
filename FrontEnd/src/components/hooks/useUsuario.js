import { useEffect, useState } from "react";

export const useUsuario = (url) => {

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
                headers: { "Content-Type": "application/json"},
                body: JSON.stringify(data)
            })


            setMetodo(method)
            setIdItem(id)
        }
        // else if (method === "PUT"){
        //     setConfig({
        //         method,
        //         headers: { "Content-Type": "application/json" },
        //         body: JSON.stringify(data)
                
        //     })

        //     setMetodo(method)
            

            
      
        // }
        // else if (method === "DELETE"){
        //     setConfig({
        //         method,
        //         headers: { "Content-Type": "application/json" }
                
        //     })
        //     setMetodo(method)
        //     setIdItem(id)
        // }

    }

    

    // Recebe o tipo de requisição
    useEffect(() => {

        let dados

        const httpRequest = async () => {


            setLoading(true)

            if (metodo === "POST" && !idItem) {

               
                let buscaOptions = [url, config]

                const resposta = await fetch(...buscaOptions)

                dados = await resposta.json()

                setData(dados)
                console.log(dados)
                

            }
            
            if (metodo === "POST" && idItem) {

                const cadastro = `${url}?id=${idItem}`
               
                let buscaOptions = [cadastro, config]

                const resposta = await fetch(...buscaOptions)

                dados = await resposta.json()
                setData(dados)
               
                

            }
 
 
            
            // else if (metodo === "PUT") {

            //     const atualizar = `${url}/${idItem}`
                

            //     const resposta = await fetch(atualizar, config)

            //     dados = await resposta.json()

            // }
            // else if (metodo === "DELETE") {

            //     const deletar = `${url}/${idItem}`           

            //     const resposta = await fetch(deletar, config)

            //     dados = await resposta.json()

            // }

            setLoading(false)

        }


        httpRequest()

    }, [config,metodo, url])


    return { data, httpConfig, loading , error}

}
