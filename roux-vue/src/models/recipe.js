export let makeRecipe = () => {
  return {
    title: "",
    description: "",
    tags: [],
    time: {
      prep: {hours: 0, minutes: 0},
      cook: {hours: 0, minutes: 0},
      total: {hours: 0, minutes: 0},
    },
    ingredients: [{}],
    equipment: [{}],
    directions: [{order: 1}],
    cookStats: {},
  };
};
