<template>
  <div class="pill">
    <span class="name">{{ name }}</span>
    <span class="amount">{{ amount }} </span>
  </div>
</template>

<script>
export default {
  props: ['name', 'amount'],
};
</script>

<style lang="sass" scoped>
.pill
    margin: 10px
    height: 55px
    border-radius: 30px
    background-color: crimson
    color: #fff
    font-size: 1.3rem
    font-weight: bold
    display: flex
    align-items: center

    & .name
        margin-left: 15px

    & .amount
        margin: 10px
        padding: 5px
        height: 35px
        width: 35px
        border-radius: 18px
        font-size: 14px
        display: flex
        justify-content: center
        align-items: center
        background-color: #fff
        color: crimson
</style>
