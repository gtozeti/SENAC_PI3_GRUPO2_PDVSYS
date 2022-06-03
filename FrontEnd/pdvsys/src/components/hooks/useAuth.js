import { useContext } from 'react'
import { AuthContext } from '../context/AuthContext'

export const useAuth = () => {

    const auth = useContext(AuthContext)


    if(!auth){
        
    }

    return auth

}