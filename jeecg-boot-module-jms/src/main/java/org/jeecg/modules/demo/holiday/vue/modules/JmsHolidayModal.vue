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

        <a-form-item label="请假人" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-select-user-by-dep v-decorator="['holPerson']" :trigger-change="true"/>
        </a-form-item>
        <a-form-item label="请假类型" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-dict-select-tag type="list" v-decorator="['holType']" :trigger-change="true" dictCode="hol_type" placeholder="请选择请假类型"/>
        </a-form-item>
        <a-form-item label="请假开始时间" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-date placeholder="请选择请假开始时间" v-decorator="[ 'holStart', validatorRules.holStart]" :trigger-change="true" :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="请假结束时间" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-date placeholder="请选择请假结束时间" v-decorator="[ 'holEnd', validatorRules.holEnd]" :trigger-change="true" :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="请假事由" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-textarea v-decorator="['holReason']" rows="4" placeholder="请输入请假事由"/>
        </a-form-item>

      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>

  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'
  import JDate from '@/components/jeecg/JDate'  
  import JSelectUserByDep from '@/components/jeecgbiz/JSelectUserByDep'
  import JDictSelectTag from "@/components/dict/JDictSelectTag"

  export default {
    name: "JmsHolidayModal",
    components: { 
      JDate,
      JSelectUserByDep,
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
        holPerson:{rules: [{ required: true, message: '请输入请假人!' }]},
        holType:{rules: [{ required: true, message: '请输入请假类型!' }]},
        holStart:{rules: [{ required: true, message: '请输入请假开始时间!' }]},
        holEnd:{rules: [{ required: true, message: '请输入请假结束时间!' }]},
        holReason:{rules: [{ required: true, message: '请输入请假事由!' }]},
        },
        url: {
          add: "/holiday/jmsHoliday/add",
          edit: "/holiday/jmsHoliday/edit",
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
          this.form.setFieldsValue(pick(this.model,'holPerson','holType','holStart','holEnd','holReason'))
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
        this.form.setFieldsValue(pick(row,'holPerson','holType','holStart','holEnd','holReason'))
      },

      
    }
  }
</script>