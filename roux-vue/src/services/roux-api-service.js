import axios from "axios";

export async function createRecipe(recipe) {
  await axios
    .post("localhost:8080", {
      body: recipe,
    });
  console.log("Recipe submitted successfully");
}
