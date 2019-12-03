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

        <a-form-item label="租户编号" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'ternantCode', validatorRules.ternantCode]" placeholder="请输入租户编号"></a-input>
        </a-form-item>
        <a-form-item label="租户名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'ternantName', validatorRules.ternantName]" placeholder="请输入租户名称"></a-input>
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

      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>

  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'

  export default {
    name: "SaasTernantModal",
    components: { 
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
        ternantCode:{rules: [{ required: true, message: '请输入租户编号!' }]},
        ternantName:{rules: [{ required: true, message: '请输入租户名称!' }]},
        remark1:{},
        remark2:{},
        remark3:{},
        },
        url: {
          add: "/saas/saasTernant/add",
          edit: "/saas/saasTernant/edit",
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
          this.form.setFieldsValue(pick(this.model,'ternantCode','ternantName','remark1','remark2','remark3'))
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
        this.form.setFieldsValue(pick(row,'ternantCode','ternantName','remark1','remark2','remark3'))
      },

      
    }
  }
</script>