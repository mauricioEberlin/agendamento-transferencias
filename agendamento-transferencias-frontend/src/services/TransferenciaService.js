import axios from 'axios'

const TRANSFERENCIA_API_URL = 'http://localhost:8080/api/transferencias'

class TransferenciaService {
    getTransferencias(){
        return axios.get(TRANSFERENCIA_API_URL);
    }
}

export default new TransferenciaService()