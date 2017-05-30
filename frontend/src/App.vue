<template>
  <div>
    <header class="main-header">
      <!-- Logo -->
      <a href="#" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>Q</b>A</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>AI</b>Test</span>
      </a>
      <!-- Header Navbar: style can be found in header.less -->
      <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
          <span class="sr-only">Toggle navigation</span>
        </a>
      </nav>
    </header>
    <aside class="main-sidebar">

      <!-- sidebar: style can be found in sidebar.less -->
      <section class="sidebar">

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
          <li class="header">HEADER</li>
          <!-- Optionally, you can add icons to the links -->
          <!--<li class="active"><a href="#"><i class="fa fa-link"></i> <span><router-link to="/bot">BOT算法测试</router-link></span></a></li>-->
          <li>
            <router-link to="/bot"><i class="fa fa-link"></i><span>BOT算法测试</span></router-link>
          </li>
          <li>
            <router-link to="/unity"><i class="fa fa-link"></i><span>Unity算法测试</span></router-link>
          </li>
        </ul>
        <!-- /.sidebar-menu -->
      </section>
      <!-- /.sidebar -->
    </aside>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <router-view></router-view>
    </div>
    <!-- Main Footer -->
    <footer class="main-footer">
      <!-- To the right -->
      <div class="pull-right hidden-xs">
        Netease AI
      </div>
      <!-- Default to the left -->
      <strong>Copyright &copy; 2017 <a href="http://www.163.com" target="_blank">Netease</a>.</strong>
      All rights reserved.
    </footer>

  </div>
</template>

<!--<script>-->
<!--import botalg from './components/bot'-->

<!--export default {-->
<!--name: 'app',-->
<!--components: {-->
<!--botalg-->
<!--}-->
<!--}-->
<!--</script>-->

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
