<template>
	<div>
		<input @keyup.enter="addTag" @keyup.space="normalizeInput" v-model="tagInput">
		<div class="tags">
			<Tag 
				v-for="(tag, index) in tags" 
				:name="tag"
				@deleteTag="this.tags.splice(index, 1)">
			</Tag>
		</div>
	</div>
</template>

<script>
import Tag from './Tag.vue'
export default {
	components: { Tag },
	data() {
		return {
			tagInput: "",
			tags: []
		}
	},
	methods: {
		addTag() {
			if (this.tags.includes(this.tagInput)) {
				console.log(`${this.tagInput} has already been added`)
			} else {
				this.tags.push(this.tagInput);
			}

			this.tagInput = "";
		},
		getTags() {
			return this.tags;
		},
		normalizeInput() {
			// strip off the space
			this.tagInput = this.tagInput.substring(0, this.tagInput.length - 1) + "-";
		}
	}
}
</script>

<style scoped>
.tags {
	display: flex;
	flex-wrap: wrap;
	padding: 4px;
}

.tags > * {
	padding: 5px;
}
</style>