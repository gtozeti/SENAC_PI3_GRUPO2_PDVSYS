// ----- Styles - CSS
import styles from './css/Sucesso.module.css'

// ----- Links
import { Link } from 'react-router-dom'

const Sucesso = () => {

    return (
        <div className={styles.div}>

            <h2>Cadastro efetuado com sucesso!</h2>
            <div>
                {/* Campo categoria */}
                <label>
                    <h5>Retorne a página inicial, para efetuar o login!</h5>
                </label>
            </div>
            <Link to="/">
                <button>Tela de login</button>
            </Link>

        </div>

    )
}

export default Sucesso