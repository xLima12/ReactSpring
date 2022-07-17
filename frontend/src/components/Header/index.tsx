import logo from   '../../assets/img/logo.svg'
import './styles.css'

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="WASystem" />
                <h1>WASystem</h1>
                <p>
                    Desenvolvido por
                    <a href="https://www.instagram.com/felima12">@felima12</a>
                </p>
            </div>
        </header>
    )
}

export default Header