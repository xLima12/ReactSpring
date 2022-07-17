import { useState } from 'react';
import logo from   '../../assets/img/logo.svg'
import "./styles.css"

function Login() {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  return (
    <div className="container">
      <div className="container-login">
        <div className="wrap-login">
          <form className="login-form">

            <span className="login-form-title">Bem Vindo!</span>

            <span className="login-form-title">
              <img src={logo} alt="Login" />
            </span>

            <div className="wrap-input">
              <input className={email !== "" ? 'has-val input' : 'input'}
                type="email" value={email}
                onChange={e => setEmail(e.target.value)}
              />
              <span className="focus-input" aria-placeholder="Email"></span>
            </div>

            <div className="wrap-input">
              <input className={password !== "" ? 'has-val input' : 'input'}
                type="password"
                value={password}
                onChange={e => setPassword(e.target.value)}
              />
              <span className="focus-input" aria-placeholder="Password"></span>
            </div>

            <div className="container-login-form-btn">
              <button className="login-form-btn">Login</button>
            </div>

            <div className="text-center">

              <span className="txt1">Não possui conta?</span>

              <a className="text2" href="https://www.instagram.com/felima12">Criar Conta</a>

            </div>

          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;
