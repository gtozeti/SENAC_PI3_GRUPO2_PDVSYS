// ----- Styles - CSS
import styles from './css/Navbar.module.css'

import { NavLink } from "react-router-dom"


const Navbar = () => {
    return (
        <nav className={styles.navbar}>
            <ul  className={styles.links_list}>
                <li>
                    <NavLink to="/vendas" className={({isActive}) => (isActive ? styles.active : styles.inactive)}>Vender</NavLink>
                </li>
                <li>
                    <NavLink to="/os" className={({isActive}) => (isActive ? styles.active : styles.inactive)}>Ordem de Serviço</NavLink>
                </li>
                <li>
                    <NavLink to="/clientes" className={({isActive}) => (isActive ? styles.active : styles.inactive)}>Cliente</NavLink>
                </li>
                <li>
                    <NavLink to="/relatorios" className={({isActive}) => (isActive ? styles.active : styles.inactive)}>Relatório</NavLink>
                </li>
                <li>
                    <NavLink to="/produtos" className={({isActive}) => (isActive ? styles.active : styles.inactive)}>Estoque</NavLink>
                </li>
                <li>
                    <NavLink to="/funcionarios" className={({isActive}) => (isActive ? styles.active : styles.inactive)}>Funcionário</NavLink>
                </li>
            </ul>
        </nav>
    )
}

export default Navbar