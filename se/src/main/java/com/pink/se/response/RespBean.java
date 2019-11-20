package com.pink.se.response;

/**
 * 返回前端的结果对象
 * 统一格式
 *
 *author 胡江喜
 *date 19-11-18
 */
public class RespBean {

    private Integer status;//状态码，500为成功，200为失败

    private String msg;//提示信息

    private Object obj;//响应数据


    public static RespBean success(String msg){
        return new RespBean(200,msg,null);
    }

    /**
     * 返回带有响应数据的成功结果
     * @param msg
     * @param obj
     * @return
     */
    public static RespBean success(String msg,Object obj){
        return new RespBean(200,msg,obj);
    }

    public static RespBean fail(String msg){
        return new RespBean(500,msg,null);
    }


    public static RespBean fail(String msg,Object obj){
        return new RespBean(500,msg,obj);
    }
    /**
     * 定义无参构造函数
     */
    private RespBean(){
    }

    private RespBean(Integer status,String msg,Object obj){
        this.status =status;
        this.msg=msg;
        this.obj=obj;

    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
