package top.hyizhou.aria2j.entity.params;

import top.hyizhou.aria2j.util.ParamsUtil;

import java.util.List;

/**
 * multicall方法批量调用方法时，表示其中一个方法以及参数
 * @author huanggc
 * @date 2022/8/25 17:10
 */
public class Method {
    /** 调用方法名 */
    private String methodName;
    /** 调用方法参数 */
    private List<Object> params;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }

    /**
     * 创建本类对象
     * @param methodName 方法名，可以查看{@link top.hyizhou.aria2j.client.Aria2}接口确认
     * @param params 参数
     * @param token 秘钥，若为空就传null
     * @return 返回创建成功的对象
     */
    public static Method create(String methodName,String token, Object... params){
        Method method = new Method();
        method.methodName = methodName;
        method.params = ParamsUtil.create(params);
        if (method.params != null && token != null){
            method.params.add(0, token);
        }
        return method;
    }
}
