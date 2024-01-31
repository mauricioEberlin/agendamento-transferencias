import axios from 'axios'

const TRANSFERENCIA_API_URL = 'http://localhost:8080/api/transferencias'
const PERSISTIR_TRANSFERENCIA_URL = '/salvar'
const DELETAR_TRANSFERENCIA_URL = '/deletar/'

class TransferenciaService {
    getTransferencias(){
        return axios.get(TRANSFERENCIA_API_URL);
    }
    salvarTransferencia(transferencia){
        return axios.post(TRANSFERENCIA_API_URL.concat(PERSISTIR_TRANSFERENCIA_URL), transferencia);
    }

    deletarTransferencia(id){
        return axios.delete(TRANSFERENCIA_API_URL.concat(DELETAR_TRANSFERENCIA_URL + id));
    }
}

export default new TransferenciaService()