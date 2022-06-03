// ----- Styles - CSS
import styles from './css/FormularioProduto.module.css'

// ----- Hooks
import { useProdutos } from "../hooks/useProdutos";

// ----- Links
import { Link, useParams, useLocation, useNavigate } from 'react-router-dom'

const url = "http://201.52.85.36:80/pdv/delete/produto?id="


const FormularioDelProduto = () => {

  

    // Dados recebidos da tela anterior
    const { id } = useParams()
    const fr = useLocation()
    const { from_nome } = fr.state


    const navigate = useNavigate()

    // Função de envio do formulário
    const handleEnvio = async (evento) => {
        evento.preventDefault()



        // // Utiliza API
        // httpConfig(produto, "DELETE", id)
        // setTimeout(() => { navigate("/produtos") }, 500);


        deletar()

    }

    const deletar = async () => {

        const resposta = await fetch(url + `${id}`,
            {
                method: 'DELETE',
                headers: { 'Content-Type': 'application/json' }
            })
        if (resposta.status === 202) {
            navigate(`/produtos`)
        }

    }




    return (
        <div className={styles.div}>
            <form onSubmit={handleEnvio}>
                <h2>Deletar produto</h2>
                <div>
                    {/* Campo categoria */}
                    <label>
                        <h5>Deseja realmente excluir o produto "{from_nome}" ? </h5>
                    </label>
                </div>
                {/* Botão deletar */}
                <input type="submit" value="Deletar" />
                {/* {!loading && <input type="submit" value="Deletar" />} */}
                <Link to="/produtos">
                    <button>Cancelar</button>
                </Link>
            </form>
        </div>

    )
}

export default FormularioDelProduto