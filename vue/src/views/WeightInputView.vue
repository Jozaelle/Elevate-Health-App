<template>
  <div>
    
      <weight-input v-bind:weightInputID="parseInt($route.params.weightInputID)"/>

  </div>
</template>

<script>

import WeightInput from '../components/WeightInput.vue';

export default {
    components: {WeightInput }

}
</script>


