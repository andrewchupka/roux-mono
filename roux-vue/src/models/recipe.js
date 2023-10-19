export let makeRecipe = () => {
  return {
    title: "",
    description: "",
    tags: [],
    time: {},
    ingredients: [],
    utensils: [],
    directions: [{order: 1}],
    cookStats: {},
  };
};
