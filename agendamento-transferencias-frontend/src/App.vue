<template>
  <div id="app">
    <Transferencia />
  </div>
</template>

<script>
import Transferencia from './components/Transferencia.vue'

export default {
  name: 'App',
  components: {
    Transferencia
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
