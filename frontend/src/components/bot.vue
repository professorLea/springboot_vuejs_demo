<template xmlns: xmlns: xmlns: xmlns: xmlns:>
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
        <h3>1 总览</h3>
        <div class="row">
          <div class="col-md-4 col-sm-6 col-xs-12">
            <div class="info-box">
              <span class="info-box-icon bg-aqua"><i class="fa fa-files-o"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">全部用例</span>
                <span class="info-box-number">{{summary.total_cases}}</span>
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
                <span class="info-box-number">{{summary.case_passed}}</span>
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
                <span class="info-box-text">Pass radio(%)</span>
                <span class="info-box-number">{{summary.pass_radio}}</span>
              </div>
              <!-- /.info-box-content -->
            </div>
            <!-- /.info-box -->
          </div>
          <!-- /.col -->
        </div>
        <h3>2 分类通过率</h3>
        <h4>2.1 实体维度</h4>
        <div class="row">
          <div v-for="e in entity" class="col-md-3 col-sm-6 col-xs-12">
            <div class="info-box">
              <span class="info-box-icon bg-light-blue"><i class="fa fa-file"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">{{e.entity_type}}</span>
                <span class="info-box-number">{{e.case_num}}</span>

                <div class="progress">
                  <div class="progress-bar bg-light-blue" v-bind:style="{width: calculatePercentage(e) + '%'}"></div>
                </div>
                <span class="progress-description">
                    {{e.pass_radio}}% passed
                  </span>
              </div>
              <!-- /.info-box-content -->
            </div>
          </div>
        </div>
        <h4>2.2 意图维度</h4>
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
                          :append-params="moreParams"
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
        <h3>3，错误用例分析</h3>
        <h4>3.1 错误类型维度</h4>
        <!-- Small boxes (Stat box) -->
        <div class="row">
          <div v-for="error in errorcases" class="col-lg-3 col-xs-6">
            <!-- small box -->
            <div class="small-box bg-light-blue">
              <div class="inner">
                <h3>{{error.case_num}}</h3>

                <p>{{error.error_type}}</p>
              </div>
              <!--<div class="icon">-->
              <!--<i class="fa fa-clone"></i>-->
              <!--</div>-->
            </div>
          </div>
        </div>
        <h4>3.2 错误分类</h4>
        <div class="row">
          <div class="col-xs-12">
            <errorcase-table></errorcase-table>
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
  import errorcasetable from './errorcasetable.vue'
  export default {
    name: 'bot',
    components: {
      'vuetable': Vuetable,
      'vuetable-pagination': VuetablePagination,
      'errorcase-table': errorcasetable
//      'vuetable-pagination-info': VuetablePaginationInfo
    },
    data () {
      return {
        css: BootstrapStyle,
        reportId: 1,
        fields: [
          {
            name: 'contextual',
            title: '问法',
            titleClass: 'text-center',
            dataClass: 'text-center'
          },
          {
            name: 'intent',
            title: '意图',
            titleClass: 'text-center',
            dataClass: 'text-center'
          },
          {
            name: 'caseNum',
            title: '用例数',
            titleClass: 'text-center',
            dataClass: 'text-center'
          },
          {
            name: 'casePassed',
            title: '用例通过数',
            titleClass: 'text-center',
            dataClass: 'text-center'
          },
          {
            name: 'casePassRadio',
            title: '用例通过率（%）',
            titleClass: 'text-center',
            dataClass: 'text-center'
          }
        ],
        summary: [],
        entity: [],
        errorcases: []
      }
    },
    computed: {
      moreParams () {
        return {reportId: this.reportId}
      }
    },
    methods: {
      onPaginationData (paginationData) {
        this.$refs.pagination.setPaginationData(paginationData)
//        this.$refs.paginationInfo.setPaginationData(paginationData)
      },
      onChangePage (page) {
        this.$refs.vuetable.changePage(page)
      },
      getSummary (id) {
        this.$http.get('/api/summary/', {params: {'reportId': id}}).then(response => {
          this.summary = response.body
          console.log(response.body)
        }, response => {
          console.log(response)
        })
      },
      getEntityTest (id) {
        this.$http.get('/api/entity/', {params: {'reportId': id}}).then(response => {
          this.entity = response.body
          console.log(response.body)
        }, response => {
          console.log(response)
        })
      },
      getErrorCases (id) {
        this.$http.get('/api/errorcases/', {params: {'reportId': id}}).then(response => {
          this.errorcases = response.body
          console.log(response.body)
        }, response => {
          console.log(response)
        })
      },
      calculatePercentage (e) {
        return e.pass_radio
      }
    },
    mounted () {
      this.getSummary(1)
      this.getEntityTest(1)
      this.getErrorCases(1)
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
