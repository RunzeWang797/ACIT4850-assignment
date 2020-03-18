@RestController
public class Hello {

    @RequestMapping("/")
    public String sayHello(){
    
    return "abcdefg. Hello jenkins222, " + new Date();
}
}
