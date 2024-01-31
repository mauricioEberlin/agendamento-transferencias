<template>
    
    <div class="container-principal">
        <h1>Lista de Transferências</h1>
        
        <div class="tabela-transferencias">
            <table>
                <thead>
                    <th>ID</th>
                    <th>Conta origem</th>
                    <th>Conta destino</th>
                    <th>Valor transferencia</th>
                    <th>Taxa</th>
                    <th>Data transferencia</th>
                    <th>Data agendamento</th>
                </thead>
                <tbody>
                    <tr v-for = "transferencia in transferencias" v-bind:key = "transferencia.id">
                        <td> {{transferencia.id}} </td>
                        <td> {{transferencia.contaOrigem}} </td>
                        <td> {{transferencia.contaDestino}} </td>
                        <td> {{transferencia.valorTransferencia}} </td>
                        <td> {{transferencia.taxa}} </td>
                        <td> {{transferencia.dataTransferencia}} </td>
                        <td> {{transferencia.dataAgendamento}} </td>
                        <td> <button @click="deletarTransferencia(transferencia)">X</button> </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="formulario">

            <h1>Agendamento de transferência</h1>

            <form id="cadastro" @submit.prevent="salvarTransferencia" @reset="limpar">

                <div class="campo">
                    <label>Conta de origem</label>
                    <input type="number" v-model="transferencia.contaOrigem">
                </div>

                <div class="campo">
                    <label>Conta de destino</label>
                    <input type="number" v-model="transferencia.contaDestino">
                </div>
                
                <div class="campo">
                    <label>Valor da transferencia</label>
                    <input type="number" v-model="transferencia.valorTransferencia">
                </div>

                <div class="campo">
                    <label>Data agendada</label>
                    <input type="date" v-model="transferencia.dataAgendamento">
                </div>
                
                <button type="submit">Salvar</button>
                <button type="reset">Limpar</button>
            </form>

        </div>

    </div>

</template>

<script>
import TransferenciaService from '../services/TransferenciaService'

    export default {
        name: 'Transferencias',
        data(){
            return {
                transferencias: [],
                transferencia: {
                    contaOrigem: null,
                    contaDestino: null,
                    valorTransferencia: null,
                    dataAgendamento: null
                }
            }
        },
        methods: {
            getTransferencias(){
                TransferenciaService.getTransferencias().then((response) => {
                    this.transferencias = response.data;
                })
            },
            salvarTransferencia(){
                TransferenciaService.salvarTransferencia(this.transferencia).then((response) => {
                    if (response.status === 200) {
                        this.limpar();
                        location.reload();
                    }
                })
            },
            async deletarTransferencia(transferencia){
                const res = await TransferenciaService.deletarTransferencia(transferencia.id).then((response) => {                 
                    return response
                })
                if (res.status === 200) {
                    this.transferencias = this.transferencias.filter(t => t.id !== transferencia.id)
                    alert("Agendamento cancelado!")
                }
            },
            limpar() {
                this.transferencia.contaOrigem = null,
                this.transferencia.contaDestino = null,
                this.transferencia.valorTransferencia = null,
                this.transferencia.dataAgendamento = null
            },
        },
        created() {
            this.getTransferencias()
        }
    }

</script>

<style>

.container-principal{
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

h1 {
    color: #3d4a5b;
    text-align: center;
}

.tabela-transferencias {
    margin-top: 10px;
    margin-bottom: 40px;
    text-align: center;
}

.tabela-transferencias table {
    width: 70%;
    border: 2px solid black;
    margin-left: auto;
    margin-right: auto;
}

td, th{
    padding: 5px 10px;
}

.formulario form {
    width: 75%;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 100px;
}

.formulario .campo {
    margin-bottom: 10px;
}

.formulario input {
    display: block;
    margin-top: 2px;
    width: 100%;
    height: 30px;
}

.formulario button {
    margin-top: 10px;
    width: 100px;
    height: 30px;
    margin-right: 10px;
}

</style>