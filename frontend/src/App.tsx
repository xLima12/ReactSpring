import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Header from "./components/Header"
import Login from './Pages/Login'
import Route from './Route'

function App() {
  return (
    <>
      <ToastContainer />
      <Login />
    </>
  )
}

export default App
