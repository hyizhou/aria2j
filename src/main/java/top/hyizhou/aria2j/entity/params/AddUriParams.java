package top.hyizhou.aria2j.entity.params;

import top.hyizhou.aria2j.entity.OptionsEntity;
import top.hyizhou.aria2j.entity.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * addUri调用接口的参数
 * @author hyizhou
 * @date 2022/8/11 17:41
 */
@Deprecated
public class AddUriParams implements Serializable,Params{
    /** 秘钥 */
    @Order(1)
    private String token;
    /** 下载链接列表 */
    @Order(2)
    private List<String> link;
    /** 设置 */
    @Order(3)
    private OptionsEntity options;
    /** 下载队列位置 */
    @Order(4)
    private Integer position;

    public AddUriParams() {
    }

    public AddUriParams(String token, List<String> link, OptionsEntity options, Integer position) {
        this.token = token;
        this.link = link;
        this.options = options;
        this.position = position;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getLink() {
        return link;
    }

    public void setLink(List<String> link) {
        this.link = link;
    }

    public void addLink(String link){
        if (this.link == null){
            this.link = new ArrayList<String>();
        }
        this.link.add(link);
    }

    public OptionsEntity getOptions() {
        return options;
    }

    public void setOptions(OptionsEntity options) {
        this.options = options;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}
