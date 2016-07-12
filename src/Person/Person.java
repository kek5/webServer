package Person;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Person {
    private Map<String, String[]> parameters = null;

    public Person() {}
    public Person(HttpServletRequest req) {
        if(!req.getParameterMap().isEmpty()) {
            this.parameters = req.getParameterMap();
        }
    }

    public Map<String, String[]> getParameters() {
        return this.parameters;
    }
}
