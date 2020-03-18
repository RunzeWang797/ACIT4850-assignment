@RestController
public class Hello {

    @RequestMapping("/")
    public String sayHello(){
    
    return "abcdefg. Hello jenkins123, " + new Date();
}
}
