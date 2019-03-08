package uk.co.datadisk.filters;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index/index")
    public String index(){
        System.out.println("GET /index/index");
        return "index";
    }

    @GetMapping("/app/app")
    public String app() {
        System.out.println("GET /app/app");
        return "app";
    }

    @GetMapping("/one/one")
    public String one() {
        System.out.println("GET /one/one");
        return "one";
    }

    @GetMapping("/two/two")
    public String two() {
        System.out.println("GET /two/two");
        return "two";
    }

    @GetMapping("/three/three")
    public String three() {
        System.out.println("GET /three/three");
        return "three";
    }

    @GetMapping("/app1/app1")
    public String app1() {
        System.out.println("GET /app1/app1");
        return "app1";
    }

    @GetMapping("/app2/app2")
    public String app2() {
        System.out.println("GET /app2/app2");
        return "app2";
    }
}
