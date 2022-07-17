import {ToastContainer} from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Header from "./components/Header"
import Login from './components/Login'
import SalesCard from "./components/SalesCard"

function App() {
  return (
    <>
      <ToastContainer />
      <Login />
    </>
  )
}

export default App
