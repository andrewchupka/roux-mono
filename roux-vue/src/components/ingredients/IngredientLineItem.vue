<template>
	<div>
		<!-- for debugging -->
		<!-- <ul>
			<li>Name: {{ ingredientData.name }}</li>
			<li>descriptor: {{ ingredientData.descriptor }}</li>
			<li>quantity: {{ ingredientData.quantity }}</li>
			<li>unit: {{ ingredientData.unit }}</li>
		</ul> -->
		<!-- for debugging -->

		<div class="ingredientLine">
			<!-- Name -->
			<div>
				<label for="nameInput">Name:</label>
				<input id="nameInput" v-model="ingredientData.name">
			</div>

			<!-- descriptor (chopped, peeled) -->
			<div id="descriptorSelect">
				<label>Descriptor:</label>
				<select v-model="ingredientData.descriptor">
					<option v-for="option in descriptors" :value="option.value">
						{{ option.text }}
					</option>
				</select>

				<input id="otherDesc" v-show="ingredientData.descriptor === 'other'" v-model="ingredientData.otherDescriptor">
			</div>

			<!-- amount  -->
			<div id="amount">
				<label for="amountInput">Quantity:</label>
				<input id="amountInput" type="number">
			</div>

			<!-- unit -->
			<div id="unit">
				<label for="unitSelctor"> Unit:</label>
				<select id="unitSelector" v-model="ingredientData.unit">
					<option v-for="unit in this.units" :value="unit">
						{{ unit }}
					</option>
				</select>
			</div>

			<div>
				<button v-if="allowDelete" id="deleteIngredient" @click="this.$emit('ingredientRemove')">
					Delete
				</button>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: "IngredientLineItem",
	props: {
		allowDelete: Boolean,
		ingredientData: Object,
		descriptors: Object
	},
	data() {
		return {
			units: [
				"grams",
				"kg",
				"oz",
				"lbs",
				"servings"
			]
		}
	},
	methods: {
		getIngredients() {
			return this.ingredientData;
		}
	}
}
</script>

<style>
.ingredientLine {
	display: flex;
	align-items: center;
	justify-content: space-around;
	background-color: gray;
}

.ingredientLine>div {
	margin: 7px;
	display: flex;
	flex-direction: column;
}
</style>