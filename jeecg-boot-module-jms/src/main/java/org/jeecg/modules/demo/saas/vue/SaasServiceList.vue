<template>
  <a-card :bordered="false">
    <!-- 查询区域 -->
    <div class="table-page-search-wrapper">
      <a-form layout="inline" @keyup.enter.native="searchQuery">
        <a-row :gutter="24">
          <a-col :md="6" :sm="8">
            <a-form-item label="产品名称">
              <j-dict-select-tag placeholder="请选择产品名称" v-model="queryParam.product" dictCode="saas_product,product_name,product_name"/>
            </a-form-item>
          </a-col>
          <a-col :md="6" :sm="8">
            <a-form-item label="购买方式">
              <j-dict-select-tag placeholder="请选择购买方式" v-model="queryParam.purchaseType" dictCode="purchase_type"/>
            </a-form-item>
          </a-col>
          <template v-if="toggleSearchStatus">
            <a-col :md="6" :sm="8">
              <a-form-item label="购买者">
                <j-dict-select-tag placeholder="请选择购买者" v-model="queryParam.purchaser" dictCode="saas_ternant,ternant_name,ternant_name"/>
              </a-form-item>
            </a-col>
            <a-col :md="12" :sm="16">
              <a-form-item label="服务开始时间">
                <j-date :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择开始时间" class="query-group-cust" v-model="queryParam.startTime_begin"></j-date>
                <span class="query-group-split-cust"></span>
                <j-date :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择结束时间" class="query-group-cust" v-model="queryParam.startTime_end"></j-date>
              </a-form-item>
            </a-col>
            <a-col :md="12" :sm="16">
              <a-form-item label="服务结束时间">
                <j-date :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择开始时间" class="query-group-cust" v-model="queryParam.endTime_begin"></j-date>
                <span class="query-group-split-cust"></span>
                <j-date :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择结束时间" class="query-group-cust" v-model="queryParam.endTime_end"></j-date>
              </a-form-item>
            </a-col>
            <a-col :md="6" :sm="8">
              <a-form-item label="企业编码">
                <a-input placeholder="请输入企业编码" v-model="queryParam.enterpriseCode"></a-input>
              </a-form-item>
            </a-col>
            <a-col :md="6" :sm="8">
              <a-form-item label="企业名称">
                <a-input placeholder="请输入企业名称" v-model="queryParam.enterpriseName"></a-input>
              </a-form-item>
            </a-col>
            <a-col :md="6" :sm="8">
              <a-form-item label="服务状态">
                <j-dict-select-tag placeholder="请选择服务状态" v-model="queryParam.serviceState" dictCode="service_state"/>
              </a-form-item>
            </a-col>
            <a-col :md="6" :sm="8">
              <a-form-item label="二级域名">
                <a-input placeholder="请输入二级域名" v-model="queryParam.subDomain"></a-input>
              </a-form-item>
            </a-col>
          </template>
          <a-col :md="6" :sm="8" >
            <span style="float: left;overflow: hidden;" class="table-page-search-submitButtons">
              <a-button type="primary" @click="searchQuery" icon="search">查询</a-button>
              <a-button type="primary" @click="searchReset" icon="reload" style="margin-left: 8px">重置</a-button>
              <a @click="handleToggleSearch" style="margin-left: 8px">
                {{ toggleSearchStatus ? '收起' : '展开' }}
                <a-icon :type="toggleSearchStatus ? 'up' : 'down'"/>
              </a>
            </span>
          </a-col>

        </a-row>
      </a-form>
    </div>
    <!-- 查询区域-END -->
    
    <!-- 操作按钮区域 -->
    <div class="table-operator">
      <a-button @click="handleAdd" type="primary" icon="plus">新增</a-button>
      <a-button type="primary" icon="download" @click="handleExportXls('saas服务业务表')">导出</a-button>
      <a-upload name="file" :showUploadList="false" :multiple="false" :headers="tokenHeader" :action="importExcelUrl" @change="handleImportExcel">
        <a-button type="primary" icon="import">导入</a-button>
      </a-upload>
      <a-dropdown v-if="selectedRowKeys.length > 0">
        <a-menu slot="overlay">
          <a-menu-item key="1" @click="batchDel"><a-icon type="delete"/>删除</a-menu-item>
        </a-menu>
        <a-button style="margin-left: 8px"> 批量操作 <a-icon type="down" /></a-button>
      </a-dropdown>
    </div>

    <!-- table区域-begin -->
    <div>
      <div class="ant-alert ant-alert-info" style="margin-bottom: 16px;">
        <i class="anticon anticon-info-circle ant-alert-icon"></i> 已选择 <a style="font-weight: 600">{{ selectedRowKeys.length }}</a>项
        <a style="margin-left: 24px" @click="onClearSelected">清空</a>
      </div>

      <a-table
        ref="table"
        size="middle"
        bordered
        rowKey="id"
        :columns="columns"
        :dataSource="dataSource"
        :pagination="ipagination"
        :loading="loading"
        :rowSelection="{fixed:true,selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
        
        @change="handleTableChange">

        <template slot="htmlSlot" slot-scope="text">
          <div v-html="text"></div>
        </template>
        <template slot="imgSlot" slot-scope="text">
          <span v-if="!text" style="font-size: 12px;font-style: italic;">无此图片</span>
          <img v-else :src="getImgView(text)" height="25px" alt="图片不存在" style="max-width:80px;font-size: 12px;font-style: italic;"/>
        </template>
        <template slot="fileSlot" slot-scope="text">
          <span v-if="!text" style="font-size: 12px;font-style: italic;">无此文件</span>
          <a-button
            v-else
            :ghost="true"
            type="primary"
            icon="download"
            size="small"
            @click="uploadFile(text)">
            下载
          </a-button>
        </template>

        <span slot="action" slot-scope="text, record">
          <a @click="handleEdit(record)">编辑</a>

          <a-divider type="vertical" />
          <a-dropdown>
            <a class="ant-dropdown-link">更多 <a-icon type="down" /></a>
            <a-menu slot="overlay">
              <a-menu-item>
                <a-popconfirm title="确定删除吗?" @confirm="() => handleDelete(record.id)">
                  <a>删除</a>
                </a-popconfirm>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </span>

      </a-table>
    </div>

    <saasService-modal ref="modalForm" @ok="modalFormOk"></saasService-modal>
  </a-card>
</template>

<script>

  import { JeecgListMixin } from '@/mixins/JeecgListMixin'
  import SaasServiceModal from './modules/SaasServiceModal'
  import JDictSelectTag from '@/components/dict/JDictSelectTag.vue'
  import JDate from '@/components/jeecg/JDate.vue'
  import {initDictOptions, filterMultiDictText} from '@/components/dict/JDictSelectUtil'

  export default {
    name: "SaasServiceList",
    mixins:[JeecgListMixin],
    components: {
      JDictSelectTag,
      JDate,
      SaasServiceModal
    },
    data () {
      return {
        description: 'saas服务业务表管理页面',
        // 表头
        columns: [
          {
            title: '#',
            dataIndex: '',
            key:'rowIndex',
            width:60,
            align:"center",
            customRender:function (t,r,index) {
              return parseInt(index)+1;
            }
          },
          {
            title:'产品名称',
            align:"center",
            dataIndex: 'product',
            customRender:(text)=>{
              if(!text){
                return ''
              }else{
                return filterMultiDictText(this.dictOptions['product'], text+"")
              }
            }
          },
          {
            title:'购买方式',
            align:"center",
            dataIndex: 'purchaseType',
            customRender:(text)=>{
              if(!text){
                return ''
              }else{
                return filterMultiDictText(this.dictOptions['purchaseType'], text+"")
              }
            }
          },
          {
            title:'购买者',
            align:"center",
            dataIndex: 'purchaser',
            customRender:(text)=>{
              if(!text){
                return ''
              }else{
                return filterMultiDictText(this.dictOptions['purchaser'], text+"")
              }
            }
          },
          {
            title:'服务开始时间',
            align:"center",
            dataIndex: 'startTime'
          },
          {
            title:'服务结束时间',
            align:"center",
            dataIndex: 'endTime'
          },
          {
            title:'企业编码',
            align:"center",
            dataIndex: 'enterpriseCode'
          },
          {
            title:'企业名称',
            align:"center",
            dataIndex: 'enterpriseName'
          },
          {
            title:'服务状态',
            align:"center",
            dataIndex: 'serviceState',
            customRender:(text)=>{
              if(!text){
                return ''
              }else{
                return filterMultiDictText(this.dictOptions['serviceState'], text+"")
              }
            }
          },
          {
            title:'二级域名',
            align:"center",
            dataIndex: 'subDomain'
          },
          {
            title:'备注一',
            align:"center",
            dataIndex: 'remark1'
          },
          {
            title:'备注二',
            align:"center",
            dataIndex: 'remark2'
          },
          {
            title:'备注三',
            align:"center",
            dataIndex: 'remark3'
          },
          {
            title:'备注四',
            align:"center",
            dataIndex: 'remark4'
          },
          {
            title:'备注五',
            align:"center",
            dataIndex: 'remark5'
          },
          {
            title:'备注六',
            align:"center",
            dataIndex: 'remark6'
          },
          {
            title:'备注七',
            align:"center",
            dataIndex: 'remark7'
          },
          {
            title:'备注八',
            align:"center",
            dataIndex: 'remark8'
          },
          {
            title:'备注九',
            align:"center",
            dataIndex: 'remark9'
          },
          {
            title:'备注十',
            align:"center",
            dataIndex: 'remark10'
          },
          {
            title:'备注十一',
            align:"center",
            dataIndex: 'remark11'
          },
          {
            title:'备注十二',
            align:"center",
            dataIndex: 'remark12'
          },
          {
            title:'备注十三',
            align:"center",
            dataIndex: 'remark13'
          },
          {
            title:'备注十四',
            align:"center",
            dataIndex: 'remark14'
          },
          {
            title:'备注十五',
            align:"center",
            dataIndex: 'remark15'
          },
          {
            title: '操作',
            dataIndex: 'action',
            align:"center",
            scopedSlots: { customRender: 'action' }
          }
        ],
        url: {
          list: "/saas/saasService/list",
          delete: "/saas/saasService/delete",
          deleteBatch: "/saas/saasService/deleteBatch",
          exportXlsUrl: "/saas/saasService/exportXls",
          importExcelUrl: "saas/saasService/importExcel",
        },
        dictOptions:{
         product:[],
         purchaseType:[],
         purchaser:[],
         serviceState:[],
        },
      }
    },
    computed: {
      importExcelUrl: function(){
        return `${window._CONFIG['domianURL']}/${this.url.importExcelUrl}`;
      }
    },
    methods: {
      initDictConfig(){
        initDictOptions('saas_product,product_name,product_name').then((res) => {
          if (res.success) {
            this.$set(this.dictOptions, 'product', res.result)
          }
        })
        initDictOptions('purchase_type').then((res) => {
          if (res.success) {
            this.$set(this.dictOptions, 'purchaseType', res.result)
          }
        })
        initDictOptions('saas_ternant,ternant_name,ternant_name').then((res) => {
          if (res.success) {
            this.$set(this.dictOptions, 'purchaser', res.result)
          }
        })
        initDictOptions('service_state').then((res) => {
          if (res.success) {
            this.$set(this.dictOptions, 'serviceState', res.result)
          }
        })
      }
       
    }
  }
</script>
<style scoped>
  @import '~@assets/less/common.less'
</style>