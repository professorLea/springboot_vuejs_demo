<template xmlns: xmlns: xmlns: xmlns: xmlns:>
  <div class="box">
    <div class="box-header">
      <h3 class="box-title">错误用例信息</h3>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
      <div id="toolbar">
        <!--<button id="remove" class="btn btn-danger" disabled>-->
        <!--<i class="glyphicon glyphicon-remove"></i> Delete-->
        <!--</button>-->
      </div>
      <table id="table"
             data-toggle="table"
             data-toolbar="#toolbar"
             data-search="true"
             data-pagination="true"
             data-show-refresh="true"
             data-show-columns="true"
             data-sort-name="error_type"
             data-sort-order="desc"
             :data-url="getUrl">
        <!--data-show-export="true"-->
        <!--:data-query-params="queryParams">-->
        <thead>
        <tr>
          <th data-field="utterance" data-sortable="true">用例详情</th>
          <th data-field="error_type" data-sortable="true">错误类型</th>
          <th data-field="error_info">错误信息</th>
        </tr>
        </thead>
      </table>
      <!-- /.box-body -->
    </div>
  </div>
</template>

<script>
  //  import $ from 'jquery'

  export default {
    name: 'errorcasetable',
    data () {
      return {
        reportId: 1
      }
    },
    computed: {
      getUrl () {
        return '/api/errordetail?reportId=' + this.reportId
      }
    }
  }
</script>
