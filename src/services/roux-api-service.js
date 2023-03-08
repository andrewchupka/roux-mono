import axios from "axios";

export const createRecipe = (recipe) => {
  return axios.post("localhost:8080", {
    body: recipe,
  })
  .then( () => {console.log("Recipe submitted successfully");})
  .catch( e => {return e;});
};
