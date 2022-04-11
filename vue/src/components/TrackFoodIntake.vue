<template>
  <div>
    <form>
      <h2>Food Intake Form</h2>
      <label for="food-type">Type of Food</label>
      <br />
      <input type="text" id="food-type" placeholder="Type of Food" />
      <br />
      <br />
      <label for="serving-size">Serving Size</label>
      <br />
      <input type="text" id="serving-size" placeholder="Serving Size" />
      <br />
      <br />

      <label for="number-of-servings">Number of Servings</label>
      <br />
      <input
        type="text"
        id="number-of-servings"
        placeholder="Number of Servings"
      />
      <br />
      <br />

      <label for="meal-type">Meal Breakfast/Lunch/Dinner/Snack</label>
      <br />
      <select name="meal-type" id="meal-type">
        <option value="breakfast">Breakfast</option>
        <option value="lunch">Lunch</option>
        <option value="dinner">Dinner</option>
        <option value="snack">Snack</option>
      </select>
      <br />
      <br />
      <label>
        Enter the Date:
        <input type="date" name="meal-day" />
      </label>

      <p><button>Submit</button></p>
    </form>
  </div>
</template>

<script>
export default {};
</script>

<style>
#meal-type {
  padding: 0.25rem 3rem 0.25rem 3rem;
}
</style>