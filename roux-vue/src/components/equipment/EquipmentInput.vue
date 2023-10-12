<template>
  <div>
    <EquipmentLineItem 
      v-for="(item, index) in equipmentList" 
      :allowDelete="this.equipmentList.length > 1"
      :equipmentData="item" 
      @equipmentRemove="removeEquipment(index)">
    </EquipmentLineItem>

    <button @click="this.addEquipment">New ingredient</button>
  </div>
</template>

<script>
import EquipmentLineItem from './EquipmentLineItem.vue';

export default {
    name: "EquipmentInput",
    data() {
        return {
            equipmentList: []
        };
    },
    mounted() {
      this.addEquipment();
    }, 
    methods: {
       addEquipment() {
        this.equipmentList.push({});
       },
       removeEquipment(index) {
        this.equipmentList.splice(index, 1);
       },
       getEquipment() {
        return this.equipmentList;
       }
    },
    components: { EquipmentLineItem }
}
</script>

<style>
</style>