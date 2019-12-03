<template>
  <a-modal
    :title="title"
    :width="width"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleOk"
    @cancel="handleCancel"
    cancelText="关闭">
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">

        <a-form-item label="产品名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-dict-select-tag type="list" v-decorator="['product']" :trigger-change="true" dictCode="saas_product,product_name,product_name" placeholder="请选择产品名称"/>
        </a-form-item>
        <a-form-item label="购买方式" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-dict-select-tag type="list" v-decorator="['purchaseType']" :trigger-change="true" dictCode="purchase_type" placeholder="请选择购买方式"/>
        </a-form-item>
        <a-form-item label="购买者" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-dict-select-tag type="list" v-decorator="['purchaser']" :trigger-change="true" dictCode="saas_ternant,ternant_name,ternant_name" placeholder="请选择购买者"/>
        </a-form-item>
        <a-form-item label="服务开始时间" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-date placeholder="请选择服务开始时间" v-decorator="[ 'startTime', validatorRules.startTime]" :trigger-change="true" :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="服务结束时间" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-date placeholder="请选择服务结束时间" v-decorator="[ 'endTime', validatorRules.endTime]" :trigger-change="true" :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="企业编码" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'enterpriseCode', validatorRules.enterpriseCode]" placeholder="请输入企业编码"></a-input>
        </a-form-item>
        <a-form-item label="企业名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'enterpriseName', validatorRules.enterpriseName]" placeholder="请输入企业名称"></a-input>
        </a-form-item>
        <a-form-item label="服务状态" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-dict-select-tag type="list" v-decorator="['serviceState']" :trigger-change="true" dictCode="service_state" placeholder="请选择服务状态"/>
        </a-form-item>
        <a-form-item label="二级域名" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'subDomain', validatorRules.subDomain]" placeholder="请输入二级域名"></a-input>
        </a-form-item>
        <a-form-item label="备注一" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark1', validatorRules.remark1]" placeholder="请输入备注一"></a-input>
        </a-form-item>
        <a-form-item label="备注二" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark2', validatorRules.remark2]" placeholder="请输入备注二"></a-input>
        </a-form-item>
        <a-form-item label="备注三" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark3', validatorRules.remark3]" placeholder="请输入备注三"></a-input>
        </a-form-item>
        <a-form-item label="备注四" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark4', validatorRules.remark4]" placeholder="请输入备注四"></a-input>
        </a-form-item>
        <a-form-item label="备注五" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark5', validatorRules.remark5]" placeholder="请输入备注五"></a-input>
        </a-form-item>
        <a-form-item label="备注六" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark6', validatorRules.remark6]" placeholder="请输入备注六"></a-input>
        </a-form-item>
        <a-form-item label="备注七" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark7', validatorRules.remark7]" placeholder="请输入备注七"></a-input>
        </a-form-item>
        <a-form-item label="备注八" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark8', validatorRules.remark8]" placeholder="请输入备注八"></a-input>
        </a-form-item>
        <a-form-item label="备注九" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark9', validatorRules.remark9]" placeholder="请输入备注九"></a-input>
        </a-form-item>
        <a-form-item label="备注十" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark10', validatorRules.remark10]" placeholder="请输入备注十"></a-input>
        </a-form-item>
        <a-form-item label="备注十一" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark11', validatorRules.remark11]" placeholder="请输入备注十一"></a-input>
        </a-form-item>
        <a-form-item label="备注十二" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark12', validatorRules.remark12]" placeholder="请输入备注十二"></a-input>
        </a-form-item>
        <a-form-item label="备注十三" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark13', validatorRules.remark13]" placeholder="请输入备注十三"></a-input>
        </a-form-item>
        <a-form-item label="备注十四" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark14', validatorRules.remark14]" placeholder="请输入备注十四"></a-input>
        </a-form-item>
        <a-form-item label="备注十五" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'remark15', validatorRules.remark15]" placeholder="请输入备注十五"></a-input>
        </a-form-item>

      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>

  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'
  import JDate from '@/components/jeecg/JDate'  
  import JDictSelectTag from "@/components/dict/JDictSelectTag"

  export default {
    name: "SaasServiceModal",
    components: { 
      JDate,
      JDictSelectTag,
    },
    data () {
      return {
        form: this.$form.createForm(this),
        title:"操作",
        width:800,
        visible: false,
        model: {},
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },

        confirmLoading: false,
        validatorRules:{
        product:{rules: [{ required: true, message: '请输入产品名称!' }]},
        purchaseType:{rules: [{ required: true, message: '请输入购买方式!' }]},
        purchaser:{rules: [{ required: true, message: '请输入购买者!' }]},
        startTime:{rules: [{ required: true, message: '请输入服务开始时间!' }]},
        endTime:{rules: [{ required: true, message: '请输入服务结束时间!' }]},
        enterpriseCode:{},
        enterpriseName:{},
        serviceState:{rules: [{ required: true, message: '请输入服务状态!' }]},
        subDomain:{},
        remark1:{},
        remark2:{},
        remark3:{},
        remark4:{},
        remark5:{},
        remark6:{},
        remark7:{},
        remark8:{},
        remark9:{},
        remark10:{},
        remark11:{},
        remark12:{},
        remark13:{},
        remark14:{},
        remark15:{},
        },
        url: {
          add: "/saas/saasService/add",
          edit: "/saas/saasService/edit",
        }
     
      }
    },
    created () {
    },
    methods: {
      add () {
        this.edit({});
      },
      edit (record) {
        this.form.resetFields();
        this.model = Object.assign({}, record);
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model,'product','purchaseType','purchaser','startTime','endTime','enterpriseCode','enterpriseName','serviceState','subDomain','remark1','remark2','remark3','remark4','remark5','remark6','remark7','remark8','remark9','remark10','remark11','remark12','remark13','remark14','remark15'))
        })
      },
      close () {
        this.$emit('close');
        this.visible = false;
      },
      handleOk () {
        const that = this;
        // 触发表单验证
        this.form.validateFields((err, values) => {
          if (!err) {
            that.confirmLoading = true;
            let httpurl = '';
            let method = '';
            if(!this.model.id){
              httpurl+=this.url.add;
              method = 'post';
            }else{
              httpurl+=this.url.edit;
               method = 'put';
            }
            let formData = Object.assign(this.model, values);
            console.log("表单提交数据",formData)
            httpAction(httpurl,formData,method).then((res)=>{
              if(res.success){
                that.$message.success(res.message);
                that.$emit('ok');
              }else{
                that.$message.warning(res.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
              that.close();
            })
          }
         
        })
      },
      handleCancel () {
        this.close()
      },
      popupCallback(row){
        this.form.setFieldsValue(pick(row,'product','purchaseType','purchaser','startTime','endTime','enterpriseCode','enterpriseName','serviceState','subDomain','remark1','remark2','remark3','remark4','remark5','remark6','remark7','remark8','remark9','remark10','remark11','remark12','remark13','remark14','remark15'))
      },

      
    }
  }
</script>