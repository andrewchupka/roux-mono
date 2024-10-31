<template>
  <div class="equipmentLine">
    <div>
      <label for="quantityInput">Quantity</label>
      <input id="quantityInput" v-model="equipmentData.quantity" type="number">
    </div>

    <div>
      <label for="nameInput">Name</label>
      <input name="nameInput" v-model="equipmentData.name">
    </div>
    
    <button v-if="allowDelete" @click="this.$emit('equipmentRemove')">Delete</button>
  </div>
</template>

<script>
export default {
  name: "EquipmentLineItem",
  props: {
    allowDelete: Boolean,
    equipmentData: Object
  },
}
</script>

<style>
.equipmentLine {
	display: flex;
	align-items: center;
	justify-content: space-around;
	background-color: gray;
}

.equipmentLine > div {
	margin: 7px;
	display: flex;
	flex-direction: column;
}
</style>