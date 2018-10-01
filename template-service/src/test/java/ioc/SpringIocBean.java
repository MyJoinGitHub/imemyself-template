package ioc;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpringIocBean {

    private SpringIoc single;

    private List<SpringIoc> list;

    private Set<SpringIoc> set;

    private Map<String,SpringIoc> map;

    public SpringIoc getSingle() {
        return single;
    }

    public void setSingle(SpringIoc single) {
        this.single = single;
    }

    public List<SpringIoc> getList() {
        return list;
    }

    public void setList(List<SpringIoc> list) {
        this.list = list;
    }

    public Set<SpringIoc> getSet() {
        return set;
    }

    public void setSet(Set<SpringIoc> set) {
        this.set = set;
    }

    public Map<String, SpringIoc> getMap() {
        return map;
    }

    public void setMap(Map<String, SpringIoc> map) {
        this.map = map;
    }
}
