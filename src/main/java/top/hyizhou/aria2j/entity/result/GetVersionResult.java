package top.hyizhou.aria2j.entity.result;

import java.util.List;

/**
 * getVersion结果
 * @author huanggc
 * @date 2022/8/23 15:52
 */
public class GetVersionResult {
    /** 版本号 */
    private String version;
    /** 启动功能列表 */
    private List<String> enabledFeatures;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getEnabledFeatures() {
        return enabledFeatures;
    }

    public void setEnabledFeatures(List<String> enabledFeatures) {
        this.enabledFeatures = enabledFeatures;
    }
}
