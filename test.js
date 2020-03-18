@RestController
public class Hello {

    @RequestMapping("/")
    public String sayHello(){
    
    return "abcdefg. Hello jenkinsxx, " + new Date();
}
}
