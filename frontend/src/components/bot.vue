<template xmlns:>
  <div class="bot">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          BOT语义识别算法测试
          <small>报告</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i>Level</a></li>
          <li class="active">Here</li>
        </ol>
      </section>
      <!-- Main content -->
      <section class="content">
        <!-- Your Page Content Here -->
        <!-- /.content -->
        <h3>总览</h3>
        <div class="row">
          <div class="col-md-4 col-sm-6 col-xs-12">
            <div class="info-box">
              <span class="info-box-icon bg-aqua"><i class="fa fa-files-o"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">全部用例</span>
                <span class="info-box-number">1024</span>
              </div>
              <!-- /.info-box-content -->
            </div>
            <!-- /.info-box -->
          </div>
          <!-- /.col -->
          <div class="col-md-4 col-sm-6 col-xs-12">
            <div class="info-box">
              <span class="info-box-icon bg-green"><i class="fa fa-check"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">Pass用例</span>
                <span class="info-box-number">694</span>
              </div>
              <!-- /.info-box-content -->
            </div>
            <!-- /.info-box -->
          </div>
          <!-- /.col -->
          <div class="col-md-4 col-sm-6 col-xs-12">
            <div class="info-box">
              <span class="info-box-icon bg-yellow"><i class="fa fa-bar-chart"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">Pass radio</span>
                <span class="info-box-number">67.8%</span>
              </div>
              <!-- /.info-box-content -->
            </div>
            <!-- /.info-box -->
          </div>
          <!-- /.col -->
        </div>
        <h3>其中</h3>
        <h4>1，实体</h4>
        <div class="row">
          <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="info-box bg-yellow">
              <span class="info-box-icon"><i class="fa fa-file"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">无实体</span>
                <span class="info-box-number">732</span>

                <div class="progress">
                  <div class="progress-bar" style="width: 69.7%"></div>
                </div>
                <span class="progress-description">
                    69.7% passed
                  </span>
              </div>
              <!-- /.info-box-content -->
            </div>
          </div>
          <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="info-box bg-yellow">
              <span class="info-box-icon"><i class="fa fa-file"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">单实体</span>
                <span class="info-box-number">289</span>

                <div class="progress">
                  <div class="progress-bar" style="width: 62.6%"></div>
                </div>
                <span class="progress-description">
                    62.6% passed
                  </span>
              </div>
              <!-- /.info-box-content -->
            </div>
          </div>
          <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="info-box bg-yellow">
              <span class="info-box-icon"><i class="fa fa-file"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">多实体</span>
                <span class="info-box-number">3</span>

                <div class="progress">
                  <div class="progress-bar" style="width: 100%"></div>
                </div>
                <span class="progress-description">
                    100% passed
                  </span>
              </div>
              <!-- /.info-box-content -->
            </div>
          </div>
        </div>
        <h4>2，意图</h4>
        <div class="row">
          <div class="col-xs-12">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">意图维度</h3>
              </div>
              <!-- /.box-header -->
              <div class="box-body">
                <vuetable ref="vuetable"
                          api-url="/api/intent"
                          :fields="fields"
                          :css="css"
                          data-path=""
                          pagination-path=""
                          @vuetable:pagination-data="onPaginationData"
                ></vuetable>
                <!--<vuetable-pagination-info ref="paginationInfo"-->
                <!--:css="css.pagination"-->
                <!--info-class="pull-left"-->
                <!--&gt;</vuetable-pagination-info>-->
                <vuetable-pagination ref="pagination"
                                     :css="css.pagination"
                                     @vuetable-pagination:change-page="onChangePage"
                ></vuetable-pagination>
              </div>
              <!-- /.box-body -->
            </div>
          </div>
        </div>
        <h4>3，错误用例</h4>
        <div class="row">
          <div class="col-xs-12">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">用例信息</h3>
              </div>
              <!-- /.box-header -->
              <div class="box-body">
                <vuetable ref="vuetable"
                          api-url="/api/errorcase"
                          :fields="fields1"
                          :css="css"
                          data-path=""
                          pagination-path=""
                          @vuetable:pagination-data="onPaginationData"
                ></vuetable>
                <!--<vuetable-pagination-info ref="paginationInfo"-->
                <!--:css="css.pagination"-->
                <!--info-class="pull-left"-->
                <!--&gt;</vuetable-pagination-info>-->
                <vuetable-pagination ref="pagination"
                                     :css="css.pagination"
                                     @vuetable-pagination:change-page="onChangePage"
                ></vuetable-pagination>
              </div>
              <!-- /.box-body -->
            </div>
          </div>
        </div>
      </section>
  </div>
</template>

<script>
  import Vuetable from 'vuetable-2/src/components/Vuetable'
  import VuetablePagination from 'vuetable-2/src/components/VuetablePagination'
  //  import VuetablePaginationInfo from 'vuetable-2/src/components/VuetablePaginationInfo'
  import BootstrapStyle from './bootstrap-css'
  export default {
    name: 'bot',
    components: {
      'vuetable': Vuetable,
      'vuetable-pagination': VuetablePagination
//      'vuetable-pagination-info': VuetablePaginationInfo
    },
    data () {
      return {
        css: BootstrapStyle,
        fields: [
          {
            name: 'name',
            title: '意图',
            titleClass: 'text-center',
            dataClass: 'text-center'
          },
          {
            name: 'case_num',
            title: '用例数',
            titleClass: 'text-center',
            dataClass: 'text-center'
          },
          {
            name: 'case_passed',
            title: '用例通过数',
            titleClass: 'text-center',
            dataClass: 'text-center'
          },
          {
            name: 'case_pass_radio',
            title: '用例通过率',
            titleClass: 'text-center',
            dataClass: 'text-center'
          }
        ],
        fields1: [
          {
            name: 'name',
            title: '用例详情',
            titleClass: 'text-center',
            dataClass: 'text-center'
          },
          {
            name: 'error_type',
            title: '错误类型',
            titleClass: 'text-center',
            dataClass: 'text-center'
          },
          {
            name: 'intent',
            title: '意图',
            titleClass: 'text-center',
            dataClass: 'text-center'
          }
        ]
      }
    },
    methods: {
      onPaginationData (paginationData) {
        this.$refs.pagination.setPaginationData(paginationData)
//        this.$refs.paginationInfo.setPaginationData(paginationData)
      },
      onChangePage (page) {
        this.$refs.vuetable.changePage(page)
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  /*h1, h2 {*/
  /*font-weight: normal;*/
  /*}*/

  /*ul {*/
  /*list-style-type: none;*/
  /*padding: 0;*/
  /*}*/

  /*li {*/
  /*display: inline-block;*/
  /*margin: 0 10px;*/
  /*}*/

  /*a {*/
  /*color: #42b983;*/
  /*}*/
  /*.pagination {*/
  /*margin-top: 0;*/
  /*}*/
  /*.btn.btn-border {*/
  /*border: 1px solid;*/
  /*margin-right: 2px;*/
  /*}*/
  /*.vuetable-pagination-info {*/
  /*margin-top: 8px !important;*/
  /*}*/
</style>
