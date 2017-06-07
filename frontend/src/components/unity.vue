<template>
  <div class="unity">
    <div>
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1 class="text-muted">
          Unity算法测试
          <small class="text-muted">报告</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i>Unity算法测试</a></li>
          <li class="active">Here</li>
        </ol>
      </section>
      <!-- Main content -->
      <section class="content">
        <!-- Your Page Content Here -->
        <!-- /.content -->
        <div class="box box-default color-palette-box">
          <div class="box-header with-border">
            <h3 class="box-title"><i class="fa fa-tag"></i> 综述</h3>
          </div>
          <div class="box-body">
            <div class="row">
              <div class="col-lg-6 col-xs-6">
                <div class="echarts">
                  <i-echarts :option="Gauge1" :loading="loading"></i-echarts>
                </div>
              </div>
              <div class="col-lg-6 col-xs-6">
                <div class="echarts">
                  <i-echarts :option="Gauge2" :loading="loading"></i-echarts>
                </div>
              </div>
              <div class="col-lg-6 col-xs-6">
                <div class="echarts">
                  <i-echarts :option="Gauge3" :loading="loading"></i-echarts>
                </div>
              </div>
              <div class="col-lg-6 col-xs-6">
                <div class="echarts">
                  <i-echarts :option="Gauge4" :loading="loading"></i-echarts>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="box box-default color-palette-box">
          <div class="box-header with-border">
            <h3 class="box-title"><i class="fa fa-tag"></i> FPS均值</h3>
          </div>
          <div class="box-body">
            <div class="row">
              <div class="echarts">
                <i-echarts :theme="vintage" :option="line" :loading="loading"></i-echarts>
              </div>
            </div>
          </div>
        </div>

      </section>

    </div>
  </div>
</template>

<script>
  // https://github.com/xlsdg/vue-echarts-v3
  import IEcharts from 'vue-echarts-v3/src/full.vue'

  export default {
    name: 'unity',
    components: {
      IEcharts
    },
    data () {
      return {
        linedata: [],
        vintage: 'dark',
        loading: false,
        Gauge1: {
          tooltip: {formatter: '{a} <br/>{b} : {c}%'},
          toolbox: {
            feature: {
              restore: {},
              saveAsImage: {}
            }
          },
          series: [{
            name: 'FPS',
            type: 'gauge',
            data: {value: 21.77, name: 'FPS均值'},
            min: 0,
            max: 30,
            splitNumber: 5,
            axisLine: {
              lineStyle: {
                width: 15,
                // http://tool.oschina.net/commons?type=3
                color: [[0.4, '#c23531'], [0.67, '#CDAD00'], [1, '#32CD32']]
              }
            },
            axisLabel: {
              distance: 0
            },
            pointer: {
              width: 3
            }
          }]
        },
        Gauge2: {
          tooltip: {formatter: '{a} <br/>{b} : {c}'},
          toolbox: {
            feature: {
              restore: {},
              saveAsImage: {}
            }
          },
          series: [{
            name: 'FPS大于20比率',
            type: 'gauge',
            data: {value: 86.1, name: 'FPS大于20比率'},
            min: 0,
            max: 100,
            splitNumber: 10,
            axisLine: {
              lineStyle: {
                width: 15,
                // http://tool.oschina.net/commons?type=3
                color: [[0.4, '#c23531'], [0.67, '#CDAD00'], [1, '#32CD32']]
              }
            },
            axisLabel: {
              distance: 0
            },
            pointer: {
              width: 3
            }
          }]
        },
        Gauge3: {
          tooltip: {formatter: '{a} <br/>{b} : {c}'},
          toolbox: {
            feature: {
              restore: {},
              saveAsImage: {}
            }
          },
          series: [{
            name: 'Drawcall峰值',
            type: 'gauge',
            data: {value: 40.00, name: 'Drawcall峰值'},
            min: 0,
            max: 500,
            splitNumber: 5,
            axisLine: {
              lineStyle: {
                width: 15,
                // http://tool.oschina.net/commons?type=3
                color: [[0.4, '#32CD32'], [0.6, '#CDAD00'], [1, '#c23531']]
              }
            },
            axisTick: {
              splitNumber: 10
            },
            axisLabel: {
              distance: 0
            },
            pointer: {
              width: 3
            }
          }]
        },
        Gauge4: {
          tooltip: {formatter: '{a} <br/>{b} : {c}%'},
          toolbox: {
            feature: {
              restore: {},
              saveAsImage: {}
            }
          },
          series: [{
            name: 'Mono内存峰值',
            type: 'gauge',
            data: {value: 35, name: 'mono内存峰值'},
            min: 0,
            max: 100,
            splitNumber: 5,
            axisLine: {
              lineStyle: {
                width: 15,
                // http://tool.oschina.net/commons?type=3
                color: [[0.5, '#32CD32'], [0.6, '#CDAD00'], [1, '#c23531']]
              }
            },
            axisLabel: {
              distance: 0
            },
            pointer: {
              width: 3
            }
          }]
        },
        line: {
          title: {},
          tooltip: {
            trigger: 'axis',
            formatter: function (params) {
              params = params[0]
              let date = new Date(params.name)
              return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1]
            },
            axisPointer: {
              animation: false
            }
          },
          xAxis: {
            type: 'time',
            splitLine: {
              show: false
            }
          },
          yAxis: {
            type: 'value',
            boundaryGap: [0, '100%'],
            splitLine: {
              show: false
            }
          },
          series: [{
            name: '模拟数据',
            type: 'line',
            showSymbol: false,
            hoverAnimation: false,
            data: []
          }]
        }
      }
    },
    methods: {
      randomData (now, value, oneDay) {
        let now1 = new Date(+now + oneDay)
        let value1 = value + Math.random() * 21 - 10
        return {
          name: now1.toString(),
          value: [
            [now1.getFullYear(), now1.getMonth() + 1, now1.getDate()].join('/'),
            Math.round(value1)
          ]
        }
      }
    },
    mounted () {
      let that = this
      let now = +new Date(1997, 9, 3)
      let oneDay = 24 * 3600 * 1000
      let value = Math.random() * 1000
      for (let i = 0; i < 1000; i++) {
        that.linedata.push(that.randomData(now, value, oneDay))
      }
      that.line.series[0].data = that.linedata
      setInterval(function () {
        for (let i = 0; i < 5; i++) {
          that.linedata.shift()
          that.linedata.push(that.randomData(now, value, oneDay))
        }
        console.log(that.linedata[0].name)
        //        console.log(that.line.series[0].data)
        that.line.series[0].data = that.linedata
      }, 5000)
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

  .echarts {
    width: 400px;
    height: 400px;
  }
</style>
