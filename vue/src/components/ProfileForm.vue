<template>
  <div>
    <form action="">

      <h1>The greatest form eva!</h1>

    <label for="display-name">Display Name: </label>
    <br>
    <input type="text" placeholder="Display Name">
    <br>
    <br>

    <label for="">Age: </label>
    <br>
    <input type="number" id="age" name="age"
       min="18" max="100">
    <br>
    <br>

    <label for="">Height - feet: </label>
    <br>
    <input type="number" id="height-feet" name="height-feet"
       min="0" max="8">
    <br>
    <br>

    <label for="">Height - inches: </label>
    <br>
    <input type="number" id="height-inches" name="height-inches"
       min="0" max="11">
    <br>
    <br>

    <label for="">Current Weight: </label>
    <br>
    <input type="number" id="weight" name="weight"
       min="100" max="1000">
    <br>
    <br>

    <label for="">Goal Weight: </label>
    <br>
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