<template>
  <div>
      <label for="hydration">How Many 8 oz. Glasses of Water Did You Drink Today?</label>
      <input type="number" id="hydration" name="hydration"
       min="0" max="100" />
       <button type="submit"></button>
  </div>
</template>

<script>
export default {
    data() {
        return {
            hydration: {

            }
        }
    }
}
</script>

<style>

</style>