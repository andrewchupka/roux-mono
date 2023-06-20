<template>
    <div class="removeField">
        <div :style="cssProps">
            <span class="name">{{ name }}</span>
            <button @click="$emit('deleteField', this.name)">
                <img 
                    src="https://www.svgrepo.com/show/12848/x-symbol.svg" 
                    width="10" 
                    height="10"/>
            </button>
        </div>
    </div>
</template>

<script>
import {hashString} from "../util/stringUtils.js"

export default {
    props: {
        name: String
    },
    computed: {
        cssProps() {
            var code = hashString(this.name);
            var red = (code % 255).toString(16);
            var blue = ((code * 7) % 255).toString(16);
            var green = ((code * 5) % 255).toString(16);
            console.log("Color: ", red, green, blue);
            return {
                "background-color": `#${red}${green}${blue}`,
                "color": "white"
            }
        }
    },
    methods: {
    }

}
</script>

<style>
.removeField span {
    padding: 5px;
    padding-right: 30px;
}

.removeField button {
    background-color: transparent;
    transition-duration: 0.4s;
    border-radius: 50%;
}

.removeField button:hover {
    background-color: white;
}


.removeField div {
    display: inline-block;
    padding: 8px;
    border-radius: 25px;
    margin-top: 8px;
}

</style>