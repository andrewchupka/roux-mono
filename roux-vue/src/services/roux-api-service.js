import axios from "axios";
import { recipesPath } from "../util/constants";

export async function createRecipe(recipe) {
  await axios
    .post("http://localhost:8080" + recipesPath,
      recipe
    );
  console.log("Recipe submitted successfully");
}
