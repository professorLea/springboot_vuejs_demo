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
              <div class="col-lg-12 col-xs-12">
                <div class="echarts_line">
                  <i-echarts :option="line" :loading="loading"></i-echarts>
                </div>
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
//        vintage: 'dark',
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
              return '帧号:' + params.value[0] + '，FPS值' + ':' + params.value[1]
            }
          },
//          itemStyle: {
//            normal: {
//              color: 'rgb(255, 70, 131)'
//            }
//          },
//
          xAxis: {
            type: 'value',
            name: '帧',
            splitLine: {
              show: false
            }
          },
          yAxis: {
            type: 'value',
            name: '值',
//            boundaryGap: [0, '100%'],
            splitLine: {
              show: true
            }
          },
          series: [{
            name: 'FPS',
            type: 'line',
            showSymbol: false,
            hoverAnimation: true,
            areaStyle: {normal: {}},
            data: [[0, 149.7],
              [1, 288.4],
              [2, 149.7],
              [3, 236.4],
              [4, 267.3],
              [5, 361.8],
              [6, 313.0],
              [7, 430.8],
              [8, 388.5],
              [9, 349.8],
              [10, 387.6],
              [11, 288.9],
              [12, 352.6],
              [13, 394.0],
              [14, 303.8],
              [15, 384.2],
              [16, 420.7],
              [17, 375.0],
              [18, 409.0],
              [19, 397.9],
              [20, 478.5],
              [21, 409.0],
              [22, 371.5],
              [23, 408.7],
              [24, 360.5],
              [25, 296.0],
              [26, 300.1],
              [27, 347.7],
              [28, 430.7],
              [29, 266.4],
              [30, 288.9],
              [31, 436.7],
              [32, 375.1],
              [33, 270.5],
              [34, 379.9],
              [35, 430.8],
              [36, 441.5],
              [37, 343.4],
              [38, 390.3],
              [39, 361.5],
              [40, 269.4],
              [41, 311.5],
              [42, 285.0],
              [43, 412.0],
              [44, 313.1],
              [45, 440.3],
              [46, 5.1],
              [47, 8.8],
              [48, 373.0],
              [49, 394.9],
              [50, 451.9],
              [51, 484.5],
              [52, 368.7],
              [53, 443.3],
              [54, 530.8],
              [55, 438.6],
              [56, 893.7],
              [57, 595.6],
              [58, 988.1],
              [59, 786.8],
              [60, 701.8],
              [61, 1008.1],
              [62, 745.2],
              [63, 874.9],
              [64, 861.3],
              [65, 67.5],
              [66, 5.2],
              [67, 634.5],
              [68, 41.2],
              [69, 346.3],
              [70, 639.8],
              [71, 735.3],
              [72, 572.7],
              [73, 695.9],
              [74, 726.7],
              [75, 538.2],
              [76, 740.2],
              [77, 670.2],
              [78, 473.3],
              [79, 597.4],
              [80, 611.2],
              [81, 583.1],
              [82, 749.6],
              [83, 532.8],
              [84, 569.5],
              [85, 48.1],
              [86, 310.8],
              [87, 14.4],
              [88, 13.7],
              [89, 23.9],
              [90, 113.9],
              [91, 128.3],
              [92, 134.0],
              [93, 114.7],
              [94, 136.1],
              [95, 106.4],
              [96, 35.8],
              [97, 131.2],
              [98, 105.2],
              [99, 103.2],
              [100, 124.0],
              [101, 98.3],
              [102, 96.0],
              [103, 36.6],
              [104, 121.2],
              [105, 139.8],
              [106, 145.9],
              [107, 128.4],
              [108, 137.6],
              [109, 128.9],
              [110, 125.1],
              [111, 43.0],
              [112, 116.6],
              [113, 143.1],
              [114, 132.2],
              [115, 134.8],
              [116, 148.2],
              [117, 138.6],
              [118, 42.8],
              [119, 120.3],
              [120, 138.3],
              [121, 116.4],
              [122, 97.0],
              [123, 140.4],
              [124, 44.0],
              [125, 126.5],
              [126, 151.6],
              [127, 130.5],
              [128, 144.9],
              [129, 118.7],
              [130, 131.5],
              [131, 43.1],
              [132, 123.7],
              [133, 26.4],
              [134, 3.5],
              [135, 12.6],
              [136, 23.3],
              [137, 35.7],
              [138, 10.9],
              [139, 17.9],
              [140, 28.5],
              [141, 21.1],
              [142, 27.6],
              [143, 29.6],
              [144, 34.4],
              [145, 17.6],
              [146, 35.7],
              [147, 19.0],
              [148, 25.7],
              [149, 39.7],
              [150, 17.9],
              [151, 34.9],
              [152, 35.2],
              [153, 24.2],
              [154, 16.1],
              [155, 34.6],
              [156, 19.3],
              [157, 21.1],
              [158, 20.1],
              [159, 35.2],
              [160, 13.0],
              [161, 38.0],
              [162, 22.7],
              [163, 36.5],
              [164, 36.7],
              [165, 22.0],
              [166, 36.4],
              [167, 19.9],
              [168, 34.0],
              [169, 33.7],
              [170, 21.4],
              [171, 34.8],
              [172, 32.2],
              [173, 20.9],
              [174, 36.3],
              [175, 32.4],
              [176, 21.9],
              [177, 20.7],
              [178, 35.4],
              [179, 33.6],
              [180, 20.8],
              [181, 32.4],
              [182, 32.0],
              [183, 22.7],
              [184, 38.1],
              [185, 22.4],
              [186, 36.4],
              [187, 31.9],
              [188, 18.3],
              [189, 38.5],
              [190, 34.3],
              [191, 23.8],
              [192, 20.0],
              [193, 33.9],
              [194, 34.3],
              [195, 21.3],
              [196, 31.3],
              [197, 36.3],
              [198, 23.6],
              [199, 36.0],
              [200, 32.5],
              [201, 21.3],
              [202, 31.8],
              [203, 20.8],
              [204, 21.5],
              [205, 30.9],
              [206, 24.0],
              [207, 33.6],
              [208, 21.5],
              [209, 32.6],
              [210, 20.9],
              [211, 34.9],
              [212, 20.5],
              [213, 36.2],
              [214, 34.6],
              [215, 21.1],
              [216, 36.0],
              [217, 20.3],
              [218, 36.4],
              [219, 21.1],
              [220, 35.6],
              [221, 21.3],
              [222, 34.6],
              [223, 21.3],
              [224, 32.7],
              [225, 22.2],
              [226, 33.3],
              [227, 20.8],
              [228, 37.2],
              [229, 31.6],
              [230, 21.6],
              [231, 35.2],
              [232, 22.6],
              [233, 35.8],
              [234, 20.9],
              [235, 33.7],
              [236, 21.5],
              [237, 32.9],
              [238, 20.2],
              [239, 37.0],
              [240, 21.3],
              [241, 33.6],
              [242, 20.5],
              [243, 36.3],
              [244, 35.4],
              [245, 20.5],
              [246, 38.2],
              [247, 23.0],
              [248, 33.8],
              [249, 20.7],
              [250, 39.2],
              [251, 23.4],
              [252, 33.0],
              [253, 20.2],
              [254, 38.6],
              [255, 23.3],
              [256, 33.8],
              [257, 20.6],
              [258, 32.9],
              [259, 34.9],
              [260, 20.4],
              [261, 34.3],
              [262, 22.3],
              [263, 29.7],
              [264, 22.9],
              [265, 36.8],
              [266, 21.6],
              [267, 32.7],
              [268, 20.4],
              [269, 36.0],
              [270, 21.5],
              [271, 35.8],
              [272, 21.4],
              [273, 33.4],
              [274, 37.1],
              [275, 20.4],
              [276, 34.8],
              [277, 21.4],
              [278, 34.5],
              [279, 20.5],
              [280, 35.6],
              [281, 21.9]
            ]
          }]
        }
      }
    },
    methods: {

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

  .echarts_line {
    width: 1200px;
    height: 400px;
  }
</style>
