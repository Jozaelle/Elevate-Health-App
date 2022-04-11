<template>
  <div>
    <form action="">

    <label for="display-name">Display Name: </label>
    <input type="text">
    <br>

    <label for="">Age: </label>
    <input type="number" id="age" name="age"
       min="18" max="100">
    <br>

    <label for="">Height - feet: </label>
    <input type="number" id="height-feet" name="height-feet"
       min="0" max="8">
    <br>

    <label for="">Height - inches: </label>
    <input type="number" id="height-inches" name="height-inches"
       min="0" max="11">
    <br>

    <label for="">Current Weight: </label>
    <input type="number" id="weight" name="weight"
       min="100" max="1000">
    <br>

    <label for="">Goal Weight: </label>
    <input type="number" id="goal-weight" name="goal-weight"
       min="100" max="1000">
    </form>
    <br>

    <button type="submit">Submit</button>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>