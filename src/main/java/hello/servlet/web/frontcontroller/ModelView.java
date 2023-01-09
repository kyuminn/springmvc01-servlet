package hello.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
// 논리적인 view 이름과 model 객체를 가지고 있는 class
public class ModelView {
    private String viewName;
    private Map<String,Object> model = new HashMap<>();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
}
