<template>
  <div class="unity">
    <div>
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Unity算法测试
          <small>报告</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
          <li class="active">Here</li>
        </ol>
      </section>
      <!-- Main content -->
      <section class="content">
        <!-- Your Page Content Here -->
        <!-- /.content -->
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
        <h1>{{ msg }}</h1>
      </section>

    </div>
  </div>
</template>

<script>
  export default {
    name: 'unity',
    data () {
      return {
        msg: 'reserved for the Unity test report'
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
