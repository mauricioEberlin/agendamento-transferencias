<template>
    
    <div>
        <h1>Lista de Transferencias</h1>
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
                </tr>
            </tbody>
        </table>
    </div>

</template>

<script>
import TransferenciaService from '../services/TransferenciaService'

    export default {
        name: 'Transferencias',
        data(){
            return {
                transferencias : []
            }
        },
        methods: {
            getTransferencias(){
                TransferenciaService.getTransferencias().then((response) => {
                    this.transferencias = response.data;
                })
            }
        },
        created() {
            this.getTransferencias()
        }
    }

</script>

<style>

</style>