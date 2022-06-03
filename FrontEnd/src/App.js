//Imagens
import logo from './assets/logo.png'

// ------------ Componentes

// ------------ Rotas
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'

// ----- Formulários
import FormularioLogin from './components/formularios/FormularioLogin';
import FormularioCadastro from './components/formularios/FormularioCadastro';
import FormularioDadosCadastrais from './components/formularios/FormularioDadosCadastrais';
import FormularioEsqueceuSenha from './components/formularios/FormularioEsqueceuSenha';

import FormularioAlterarSenha from './components/formularios/FormularioAlterarSenha';
import FormularioServico from './components/formularios/FormularioServico';
import FormularioCliente from './components/formularios/FormularioCliente';

import FormularioProduto from './components/formularios/FormularioProduto';
import FormularioAttProduto from './components/formularios/FormularioAttProduto';
import FormularioDelProduto from './components/formularios/FormularioDelProduto';

//import TelaServicos from './components/telas/TelaServicos';
import TelaProdutos from './components/telas/TelaProdutos';
import TelaClientes from './components/telas/TelaClientes';
import TelaVendas from './components/telas/TelaVendas';

import FormularioAttCliente from './components/formularios/FormularioAttCliente';
import FormularioDelCliente from './components/formularios/FormularioDelCliente';


import Sucesso from './components/telas/Sucesso';


// ----- Styles - CSS
import './App.css';
import Navbar from './components/telas/Navbar';
import FormularioNovoServico from './components/formularios/FormularioServico';


// ----- Context
import { AuthContext } from '../src/components/context/AuthContext'
import { useContext } from 'react'


function App() {


  const { auth } = useContext(AuthContext)


  return (
    <div className="App">


      <header>
        <img src={logo} alt="Logo PDVSYS" width="300" height="70" />
      </header>

      <BrowserRouter>


        <div className="container">
          <Routes>
            <Route path="/" element={<FormularioLogin />} />
            <Route path="/cadastro" element={<FormularioCadastro />} />
            <Route path="/cadastro/dados/:id" element={<FormularioDadosCadastrais />} />

            <Route path="/esqueceusenha" element={<FormularioEsqueceuSenha />} />
            <Route path="/sucesso" element={<Sucesso />} />

            <Route path="/produtos" element=
              {auth ? <TelaProdutos /> : <Navigate to="/login" />} />
            <Route path="/produtos/cadastro" element=
              {auth ? <FormularioProduto /> : <Navigate to="/login" />} />
            <Route path="/produtos/atualizar/:id" element=
              {auth ? <FormularioAttProduto /> : <Navigate to="/login" />} />
            <Route path="/produtos/excluir/:id" element=
              {auth ? <FormularioDelProduto /> : <Navigate to="/login" />} />

            <Route path="/clientes" element=
              {auth ? <TelaClientes /> : <Navigate to="/login" />} />
            <Route path="/clientes/cadastro" element=
              {auth ? <FormularioCliente /> : <Navigate to="/login" />} />
            <Route path="/clientes/atualizar/:id" element=
              {auth ? <FormularioAttCliente /> : <Navigate to="/login" />} />
            <Route path="/clientes/excluir/:id" element=
              {auth ? <FormularioDelCliente /> : <Navigate to="/login" />} />

            <Route path="/vendas" element=
              {auth ? <TelaVendas /> : <Navigate to="/login" />} />

          </Routes>
        </div>
      </BrowserRouter>


    </div>
  );
}

export default App;
