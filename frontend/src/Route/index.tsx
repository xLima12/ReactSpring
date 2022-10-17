import { BrowserRouter, Routes, Route as Rout, Link } from 'react-router-dom'
import Login from '../Pages/Login'
import SalesCard from '../Pages/SalesCard'

function Route() {

    return (
        <BrowserRouter>
            <Routes>
                <Link to={'/'}>
                    <Login />
                </Link>
                <Link to={'/sales'}>
                    <SalesCard />
                </Link>
            </Routes>
        </BrowserRouter>
    )
}

export default Route